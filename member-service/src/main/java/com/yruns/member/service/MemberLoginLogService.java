package com.yruns.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yruns.common.utils.PageUtils;
import com.yruns.member.entity.MemberLoginLogEntity;

import java.util.Map;

/**
 * 会员登录记录
 *
 * @author yruns
 * @email yruns.sh@qq.com
 * @date 2023-06-15 12:24:07
 */
public interface MemberLoginLogService extends IService<MemberLoginLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

