package com.yruns.product.dao;

import com.yruns.product.entity.SpuCommentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品评价
 * 
 * @author yruns
 * @email yruns.sh@qq.com
 * @date 2023-06-16 06:35:56
 */
@Mapper
public interface SpuCommentDao extends BaseMapper<SpuCommentEntity> {
	
}
