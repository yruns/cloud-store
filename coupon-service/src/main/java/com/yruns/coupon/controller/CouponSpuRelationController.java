package com.yruns.coupon.controller;

import java.util.Arrays;
import java.util.Map;

// import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yruns.coupon.entity.CouponSpuRelationEntity;
import com.yruns.coupon.service.CouponSpuRelationService;
import com.yruns.common.utils.PageUtils;
import com.yruns.common.utils.R;



/**
 * 优惠券与产品关联
 *
 * @author yruns
 * @email yruns.sh@qq.com
 * @date 2023-06-15 10:23:19
 */
@RestController
@RefreshScope
@RequestMapping("coupon/smscouponspurelation")
public class CouponSpuRelationController {
    @Autowired
    private CouponSpuRelationService smsCouponSpuRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("coupon:smscouponspurelation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = smsCouponSpuRelationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("coupon:smscouponspurelation:info")
    public R info(@PathVariable("id") Long id){
		CouponSpuRelationEntity smsCouponSpuRelation = smsCouponSpuRelationService.getById(id);

        return R.ok().put("smsCouponSpuRelation", smsCouponSpuRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("coupon:smscouponspurelation:save")
    public R save(@RequestBody CouponSpuRelationEntity smsCouponSpuRelation){
		smsCouponSpuRelationService.save(smsCouponSpuRelation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("coupon:smscouponspurelation:update")
    public R update(@RequestBody CouponSpuRelationEntity smsCouponSpuRelation){
		smsCouponSpuRelationService.updateById(smsCouponSpuRelation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("coupon:smscouponspurelation:delete")
    public R delete(@RequestBody Long[] ids){
		smsCouponSpuRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
