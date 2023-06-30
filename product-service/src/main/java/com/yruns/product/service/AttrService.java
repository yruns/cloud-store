package com.yruns.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yruns.common.utils.PageUtils;
import com.yruns.product.entity.AttrEntity;

import java.util.Map;

/**
 * 商品属性
 *
 * @author yruns
 * @email yruns.sh@qq.com
 * @date 2023-06-16 06:35:57
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

