package com.yruns.product.dao;

import com.yruns.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author yruns
 * @email yruns.sh@qq.com
 * @date 2023-06-16 06:35:56
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
