package com.yruns.member.feign;

import com.yruns.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("coupon-service")
public interface CouponFeignService {

    @RequestMapping("/coupon/coupon/member/list")
    R memberCoupons();
}
