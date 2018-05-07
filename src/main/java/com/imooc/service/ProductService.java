package com.imooc.service;

import com.imooc.dataObject.ProductInfo;
import com.imooc.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created with IDEA
 * User:赵无聊
 * Date:2018/5/1
 * Time:22:17
 */
public interface ProductService {
    ProductInfo findOne(String productId);

    /**
     * 查询上架商品列表
     * @return
     */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);
    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);
}
