package com.yruns.product;

import com.yruns.product.entity.BrandEntity;
import com.yruns.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServiceApplicationTests {

    @Autowired
    BrandService brandService;

    @Test
    void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName("iphone");

        brandService.save(brandEntity);

        System.out.println("保存成功");
    }

}
