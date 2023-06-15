package com.yruns.ware.dao;

import com.yruns.ware.entity.WareInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 仓库信息
 * 
 * @author yruns
 * @email yruns.sh@qq.com
 * @date 2023-06-15 10:45:47
 */
@Mapper
public interface WareInfoDao extends BaseMapper<WareInfoEntity> {
	
}
