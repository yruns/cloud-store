package com.yruns.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yruns.common.utils.PageUtils;
import com.yruns.product.entity.SkuInfoEntity;

import java.util.Map;

/**
 * sku信息
 *
 * @author yruns
 * @email yruns.sh@qq.com
 * @date 2023-06-15 07:46:57
 */
public interface SkuInfoService extends IService<SkuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

