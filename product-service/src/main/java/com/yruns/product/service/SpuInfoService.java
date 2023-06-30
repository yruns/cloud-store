package com.yruns.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yruns.common.utils.PageUtils;
import com.yruns.product.entity.SpuInfoEntity;

import java.util.Map;

/**
 * spu信息
 *
 * @author yruns
 * @email yruns.sh@qq.com
 * @date 2023-06-16 06:35:57
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

