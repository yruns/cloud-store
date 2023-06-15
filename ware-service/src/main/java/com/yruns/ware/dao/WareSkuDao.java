package com.yruns.ware.dao;

import com.yruns.ware.entity.WareSkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品库存
 * 
 * @author yruns
 * @email yruns.sh@qq.com
 * @date 2023-06-15 10:45:47
 */
@Mapper
public interface WareSkuDao extends BaseMapper<WareSkuEntity> {
	
}
