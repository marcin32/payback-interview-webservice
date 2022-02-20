package com.payback.interview.webservicedemo.services;

import com.payback.interview.webservicedemo.respository.CouponRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class CouponServiceTest {

    @Autowired
    private CouponRepository couponRepository;

    @Test
    public void shouldReturnCouponsForValidDate() {
        final CouponService couponService = new CouponService(couponRepository);

        assertThat(couponService.getValidMemberCoupons(0)).isNotEmpty();
    }

    @Test
    public void shouldNotReturnCouponsForInvalidMember() {
        final CouponService couponService = new CouponService(couponRepository);

        assertThat(couponService.getValidMemberCoupons(-1)).isEmpty();
    }
}