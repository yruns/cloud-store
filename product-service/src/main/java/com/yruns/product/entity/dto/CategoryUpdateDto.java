package com.yruns.product.entity.dto;

import com.yruns.product.entity.CategoryEntity;
import lombok.Data;

/**
 * CategoryUpdateDto for
 *
 * @Author yruns
 * @Version 2023/6/25
 */
@Data
public class CategoryUpdateDto {

    private CategoryEntity[] nodes;
}
