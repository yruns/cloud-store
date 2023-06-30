package com.yruns.member.dao;

import com.yruns.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author yruns
 * @email yruns.sh@qq.com
 * @date 2023-06-15 12:24:07
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
