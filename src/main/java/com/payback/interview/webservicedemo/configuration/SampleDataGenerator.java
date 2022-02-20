package com.payback.interview.webservicedemo.configuration;

import com.payback.interview.webservicedemo.model.Coupon;
import com.payback.interview.webservicedemo.respository.CouponRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.springframework.boot.Banner.Mode.LOG;

@Component
public class SampleDataGenerator implements ApplicationListener<ApplicationReadyEvent> {

    private final static Logger logger = LoggerFactory.getLogger(SampleDataGenerator.class);

    private final CouponRepository couponRepository;

    public SampleDataGenerator(final CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        final Set<Coupon> sampleCoupons = new HashSet<>();

        sampleCoupons.add(new Coupon(0L, UUID.randomUUID(), monthAgo(), nextMonth()));
        sampleCoupons.add(new Coupon(0L, UUID.randomUUID(), weekAgo(), nextWeek()));
        sampleCoupons.add(new Coupon(0L, UUID.randomUUID(), monthAgo(), weekAgo()));
        sampleCoupons.add(new Coupon(0L, UUID.randomUUID(), nextWeek(), nextMonth()));

        sampleCoupons.add(new Coupon(1L, UUID.randomUUID(), monthAgo(), nextMonth()));
        sampleCoupons.add(new Coupon(1L, UUID.randomUUID(), weekAgo(), nextWeek()));
        sampleCoupons.add(new Coupon(1L, UUID.randomUUID(), monthAgo(), weekAgo()));
        sampleCoupons.add(new Coupon(1L, UUID.randomUUID(), nextWeek(), nextMonth()));

        couponRepository.saveAll(sampleCoupons);
        logger.info("Sample data stored");
    }

    static Date monthAgo() {
        return Date.from(Instant.now().minus(30, ChronoUnit.DAYS));
    }

    static Date weekAgo() {
        return Date.from(Instant.now().minus(7, ChronoUnit.DAYS));
    }

    static Date nextMonth() {
        return Date.from(Instant.now().plus(30, ChronoUnit.DAYS));
    }

    static Date nextWeek() {
        return Date.from(Instant.now().plus(7, ChronoUnit.DAYS));
    }
}
