package com.yruns.coupon.dao;

import com.yruns.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author yruns
 * @email yruns.sh@qq.com
 * @date 2023-06-15 12:13:33
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
