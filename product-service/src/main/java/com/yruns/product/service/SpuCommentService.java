package com.yruns.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yruns.common.utils.PageUtils;
import com.yruns.product.entity.SpuCommentEntity;

import java.util.Map;

/**
 * 商品评价
 *
 * @author yruns
 * @email yruns.sh@qq.com
 * @date 2023-06-16 06:35:56
 */
public interface SpuCommentService extends IService<SpuCommentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

