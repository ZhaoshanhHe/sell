package com.imooc.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 商品包含类目
 * Created with IDEA
 * User:赵无聊
 * Date:2018/5/3
 * Time:0:37
 */
@Data
public class ProductVO {
    @JsonProperty("name")
private String categoryName;
    @JsonProperty("type")
private Integer categoryType;
    @JsonProperty("foods")
    private List<ProductInfoVO> categoryFoods;
}
