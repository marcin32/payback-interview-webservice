package com.payback.interview.webservicedemo.respository;

import com.payback.interview.webservicedemo.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

    final static String SORT_BY_DATE = " ORDER BY c.validUntil DESC";

    @Query(value = "select c from Coupon c where c.memberId = :memberId AND :currentDate BETWEEN c.validFrom AND c.validUntil" + SORT_BY_DATE)
    List<Coupon> getAllCouponsForMemberValidOnDate(@Param("memberId") final Long memberId,
                                                   @Param("currentDate") final Date currentDate);
}
