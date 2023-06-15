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

import com.yruns.coupon.entity.HomeSubjectEntity;
import com.yruns.coupon.service.HomeSubjectService;
import com.yruns.common.utils.PageUtils;
import com.yruns.common.utils.R;



/**
 * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
 *
 * @author yruns
 * @email yruns.sh@qq.com
 * @date 2023-06-15 10:23:19
 */
@RestController
@RefreshScope
@RequestMapping("coupon/smshomesubject")
public class HomeSubjectController {
    @Autowired
    private HomeSubjectService smsHomeSubjectService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("coupon:smshomesubject:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = smsHomeSubjectService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("coupon:smshomesubject:info")
    public R info(@PathVariable("id") Long id){
		HomeSubjectEntity smsHomeSubject = smsHomeSubjectService.getById(id);

        return R.ok().put("smsHomeSubject", smsHomeSubject);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("coupon:smshomesubject:save")
    public R save(@RequestBody HomeSubjectEntity smsHomeSubject){
		smsHomeSubjectService.save(smsHomeSubject);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("coupon:smshomesubject:update")
    public R update(@RequestBody HomeSubjectEntity smsHomeSubject){
		smsHomeSubjectService.updateById(smsHomeSubject);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("coupon:smshomesubject:delete")
    public R delete(@RequestBody Long[] ids){
		smsHomeSubjectService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
