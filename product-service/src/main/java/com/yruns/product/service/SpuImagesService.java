package com.yruns.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yruns.common.utils.PageUtils;
import com.yruns.product.entity.SpuImagesEntity;

import java.util.Map;

/**
 * spu图片
 *
 * @author yruns
 * @email yruns.sh@qq.com
 * @date 2023-06-15 07:46:57
 */
public interface SpuImagesService extends IService<SpuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

