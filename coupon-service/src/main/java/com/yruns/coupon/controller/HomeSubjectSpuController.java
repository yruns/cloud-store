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

import com.yruns.coupon.entity.HomeSubjectSpuEntity;
import com.yruns.coupon.service.HomeSubjectSpuService;
import com.yruns.common.utils.PageUtils;
import com.yruns.common.utils.R;



/**
 * 专题商品
 *
 * @author yruns
 * @email yruns.sh@qq.com
 * @date 2023-06-15 10:23:19
 */
@RestController
@RefreshScope
@RequestMapping("coupon/smshomesubjectspu")
public class HomeSubjectSpuController {
    @Autowired
    private HomeSubjectSpuService smsHomeSubjectSpuService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("coupon:smshomesubjectspu:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = smsHomeSubjectSpuService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("coupon:smshomesubjectspu:info")
    public R info(@PathVariable("id") Long id){
		HomeSubjectSpuEntity smsHomeSubjectSpu = smsHomeSubjectSpuService.getById(id);

        return R.ok().put("smsHomeSubjectSpu", smsHomeSubjectSpu);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("coupon:smshomesubjectspu:save")
    public R save(@RequestBody HomeSubjectSpuEntity smsHomeSubjectSpu){
		smsHomeSubjectSpuService.save(smsHomeSubjectSpu);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("coupon:smshomesubjectspu:update")
    public R update(@RequestBody HomeSubjectSpuEntity smsHomeSubjectSpu){
		smsHomeSubjectSpuService.updateById(smsHomeSubjectSpu);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("coupon:smshomesubjectspu:delete")
    public R delete(@RequestBody Long[] ids){
		smsHomeSubjectSpuService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
