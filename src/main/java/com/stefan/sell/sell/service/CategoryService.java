package com.stefan.sell.sell.service;

import com.stefan.sell.sell.pojo.ProductCategory;

import java.util.List;

/**
 * Created by Stefan
 * Create Date 2017-12-02/18:30
 */
public interface CategoryService {
    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
