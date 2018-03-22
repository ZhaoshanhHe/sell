package com.imooc.dao;

import com.imooc.dataObject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 赵山河
 * 2018/3/8 22:57
 */
public interface ProductCategoryDao extends JpaRepository<ProductCategory,Integer>{

}
