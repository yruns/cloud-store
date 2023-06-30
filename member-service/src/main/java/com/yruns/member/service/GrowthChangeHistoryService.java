package com.yruns.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yruns.common.utils.PageUtils;
import com.yruns.member.entity.GrowthChangeHistoryEntity;

import java.util.Map;

/**
 * 成长值变化历史记录
 *
 * @author yruns
 * @email yruns.sh@qq.com
 * @date 2023-06-15 12:24:07
 */
public interface GrowthChangeHistoryService extends IService<GrowthChangeHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

