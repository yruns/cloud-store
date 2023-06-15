package com.yruns.coupon.dao;

import com.yruns.coupon.entity.MemberPriceEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品会员价格
 * 
 * @author yruns
 * @email yruns.sh@qq.com
 * @date 2023-06-15 10:23:19
 */
@Mapper
public interface MemberPriceDao extends BaseMapper<MemberPriceEntity> {
	
}
