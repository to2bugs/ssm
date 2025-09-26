package com.otto.springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 用户优惠券服务
 */
@Slf4j
@Service
public class CouponService {

    public void giveCoupons(String username) {
        log.info("发放优惠券给用户 {}", username);
    }
}
