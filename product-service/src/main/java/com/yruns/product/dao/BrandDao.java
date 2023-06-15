package com.yruns.product.dao;

import com.yruns.product.entity.BrandEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 品牌
 * 
 * @author yruns
 * @email yruns.sh@qq.com
 * @date 2023-06-15 07:46:57
 */
@Mapper
public interface BrandDao extends BaseMapper<BrandEntity> {
	
}
