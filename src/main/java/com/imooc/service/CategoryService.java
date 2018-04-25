package com.imooc.service;

import com.imooc.dataObject.ProductCategory;

import java.util.List;

/**
 * Created by 赵山河
 * 2018/4/25 23:22
 */
public interface CategoryService {
    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);

}
