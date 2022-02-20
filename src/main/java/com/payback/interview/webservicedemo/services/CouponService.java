package com.payback.interview.webservicedemo.services;

import com.payback.interview.webservicedemo.model.Coupon;
import com.payback.interview.webservicedemo.respository.CouponRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class CouponService {

    private final CouponRepository couponRepository;

    public CouponService(final CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public List<Coupon> getValidMemberCoupons(final long memberId) {
        final Date currentDate = Date.from(Instant.now());
        return couponRepository.getAllCouponsForMemberValidOnDate(memberId, currentDate);
    }
}
