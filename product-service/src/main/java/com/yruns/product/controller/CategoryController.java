package com.yruns.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

// import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.yruns.product.entity.dto.CategoryDeleteDto;
import com.yruns.product.entity.dto.CategoryUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import com.yruns.product.entity.CategoryEntity;
import com.yruns.product.service.CategoryService;
import com.yruns.common.utils.PageUtils;
import com.yruns.common.utils.R;



/**
 * 商品三级分类
 *
 * @author yruns
 * @email yruns.sh@qq.com
 * @date 2023-06-16 06:35:56
 */
@RestController
@RefreshScope
@RequestMapping("product/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 查出所有分类以及其子分类，以树形结构组装起来
     */
    @RequestMapping("/list/tree")
    // @RequiresPermissions("product:category:list")
    public R list(@RequestParam Map<String, Object> params){
        List<CategoryEntity> entities = categoryService.listWithTree();

        return R.ok().put("data", entities);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{catId}")
    // @RequiresPermissions("product:category:info")
    public R info(@PathVariable("catId") Long catId){
		CategoryEntity category = categoryService.getById(catId);

        return R.ok().put("category", category);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    // @RequiresPermissions("product:category:save")
    public R save(@RequestBody CategoryEntity category){
		categoryService.save(category);

        return R.ok();
    }

    /**
     * 修改排序
     */
    @PostMapping("/update/sort")
    // @RequiresPermissions("product:category:update")
    public R update(@RequestBody CategoryUpdateDto category){
		categoryService.updateBatchById(Arrays.asList(category.getNodes()));

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    // @RequiresPermissions("product:category:delete")
    public R delete(@RequestBody CategoryDeleteDto categoryDeleteDto){
		categoryService.removeMenusByIds(Arrays.asList(categoryDeleteDto.getCatIds()));

        return R.ok();
    }

}
