package com.yruns.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yruns.common.utils.PageUtils;
import com.yruns.product.entity.SkuSaleAttrValueEntity;

import java.util.Map;

/**
 * sku销售属性&值
 *
 * @author yruns
 * @email yruns.sh@qq.com
 * @date 2023-06-16 06:35:56
 */
public interface SkuSaleAttrValueService extends IService<SkuSaleAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

