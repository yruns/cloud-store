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

import com.yruns.coupon.entity.CouponHistoryEntity;
import com.yruns.coupon.service.CouponHistoryService;
import com.yruns.common.utils.PageUtils;
import com.yruns.common.utils.R;



/**
 * 优惠券领取历史记录
 *
 * @author yruns
 * @email yruns.sh@qq.com
 * @date 2023-06-15 10:23:19
 */
@RestController
@RefreshScope
@RequestMapping("coupon/smscouponhistory")
public class CouponHistoryController {
    @Autowired
    private CouponHistoryService smsCouponHistoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("coupon:smscouponhistory:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = smsCouponHistoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("coupon:smscouponhistory:info")
    public R info(@PathVariable("id") Long id){
		CouponHistoryEntity smsCouponHistory = smsCouponHistoryService.getById(id);

        return R.ok().put("smsCouponHistory", smsCouponHistory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("coupon:smscouponhistory:save")
    public R save(@RequestBody CouponHistoryEntity smsCouponHistory){
		smsCouponHistoryService.save(smsCouponHistory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("coupon:smscouponhistory:update")
    public R update(@RequestBody CouponHistoryEntity smsCouponHistory){
		smsCouponHistoryService.updateById(smsCouponHistory);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("coupon:smscouponhistory:delete")
    public R delete(@RequestBody Long[] ids){
		smsCouponHistoryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
