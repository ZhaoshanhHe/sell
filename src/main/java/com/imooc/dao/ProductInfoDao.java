package com.imooc.dao;

import com.imooc.dataObject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created with IDEA
 * User:赵无聊
 * Date:2018/5/1
 * Time:19:49
 */
public interface ProductInfoDao extends JpaRepository<ProductInfo,String> {

List<ProductInfo> findByProductStatus(Integer productStatus);
}
