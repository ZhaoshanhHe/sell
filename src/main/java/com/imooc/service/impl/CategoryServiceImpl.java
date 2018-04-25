package com.imooc.service.impl;

import com.imooc.dao.ProductCategoryDao;
import com.imooc.dataObject.ProductCategory;
import com.imooc.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类目
 * Created by 赵山河
 * 2018/4/25 23:25
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private ProductCategoryDao categoryService;
    @Override
    public ProductCategory findOne(Integer categoryId) {
        return categoryService.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return categoryService.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return categoryService.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return categoryService.save(productCategory);
    }
}
