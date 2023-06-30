package com.yruns.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yruns.common.utils.PageUtils;
import com.yruns.product.entity.BrandEntity;

import java.util.Map;

/**
 * 品牌
 *
 * @author yruns
 * @email yruns.sh@qq.com
 * @date 2023-06-16 06:33:39
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

