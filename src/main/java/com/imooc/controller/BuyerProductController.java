package com.imooc.controller;

import com.imooc.VO.ProductInfoVO;
import com.imooc.VO.ProductVO;
import com.imooc.VO.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * 买家商品相关
 * Created with IDEA
 * User:赵无聊
 * Date:2018/5/1
 * Time:22:56
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @GetMapping("/list")
    public ResultVO list(){
        ResultVO resultVO = new ResultVO();
        ProductVO productVO = new ProductVO();
        ProductInfoVO productInfoVO = new ProductInfoVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        productVO.setCategoryFoods(Arrays.asList(productInfoVO));
        resultVO.setData(Arrays.asList(productVO));
        return resultVO;
    }
}
