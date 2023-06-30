package com.yruns.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yruns.common.utils.PageUtils;
import com.yruns.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author yruns
 * @email yruns.sh@qq.com
 * @date 2023-06-16 06:35:56
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryEntity> listWithTree();

    void removeMenusByIds(List<Long> asList);
}

