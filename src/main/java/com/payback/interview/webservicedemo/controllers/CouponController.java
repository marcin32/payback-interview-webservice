package com.payback.interview.webservicedemo.controllers;

import com.payback.interview.webservicedemo.model.Coupon;
import com.payback.interview.webservicedemo.services.CouponService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class CouponController {

    private final CouponService couponService;

    public CouponController(final CouponService couponService) {
        this.couponService = couponService;
    }

    @Async
    @GetMapping("/GetMemberCoupons/{id}")
    public CompletableFuture<List<Coupon>> getMemberCoupons(@PathVariable("id") long id) {
        return CompletableFuture.completedFuture(couponService.getValidMemberCoupons(id));
    }
}
