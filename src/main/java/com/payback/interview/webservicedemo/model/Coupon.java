package com.payback.interview.webservicedemo.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table
public class Coupon {

    public Coupon() {
    }

    public Coupon(final Long memberId, final UUID couponId,
                  final Date validFrom, final Date validUntil) {
        this.memberId = memberId;
        this.couponId = couponId;
        this.validFrom = validFrom;
        this.validUntil = validUntil;
    }

    @Column
    private Long memberId;

    @Id
    private UUID couponId;

    @Column
    @Temporal(TemporalType.DATE)
    private Date validFrom;

    @Column
    @Temporal(TemporalType.DATE)
    private Date validUntil;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public UUID getCouponId() {
        return couponId;
    }

    public void setCouponId(UUID couponId) {
        this.couponId = couponId;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coupon coupon = (Coupon) o;
        return Objects.equals(memberId, coupon.memberId) && Objects.equals(couponId, coupon.couponId) && Objects.equals(validFrom, coupon.validFrom) && Objects.equals(validUntil, coupon.validUntil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, couponId, validFrom, validUntil);
    }
}
