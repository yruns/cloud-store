package com.yruns.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yruns.common.utils.PageUtils;
import com.yruns.common.utils.Query;

import com.yruns.product.dao.CategoryDao;
import com.yruns.product.entity.CategoryEntity;
import com.yruns.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        // 1.查出所有分类
        List<CategoryEntity> entities = this.list();
        // 2.组装成父子结构
        // 2.1找到所有的一级分类
        List<CategoryEntity> collect = entities.stream()
                .filter((categoryEntity -> categoryEntity.getParentCid() == 0))
                .map((menu) -> {
                    menu.setChildren(getChildren(menu, entities));
                    return menu;
                }).sorted(Comparator.comparingInt(m -> (m.getSort() == null ? 0 : m.getSort())))
                .collect(Collectors.toList());

        return collect;
    }

    @Override
    public void removeMenusByIds(List<Long> asList) {
        // todo 检查当前删除的菜单，是否被其他地方引用
        this.removeByIds(asList);
    }

    private List<CategoryEntity> getChildren(CategoryEntity root, List<CategoryEntity> all) {
        List<CategoryEntity> collect = all.stream().filter(categoryEntity -> {
                return categoryEntity.getParentCid() == root.getCatId();
            }).map(categoryEntity -> {
                categoryEntity.setChildren(getChildren(categoryEntity, all));
                return categoryEntity;
            }).sorted(Comparator.comparingInt(m -> (m.getSort() == null ? 0 : m.getSort())))
            .collect(Collectors.toList());
        return collect;
    }

}