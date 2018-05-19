package com.imooc.controller;

import com.imooc.Utils.ResultVOUtil;
import com.imooc.VO.ResultVO;
import com.imooc.converter.OrderForm2OrderDTO;
import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.form.OrderForm;
import com.imooc.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IDEA
 * User:赵无聊
 * Date:2018/5/19
 * Time:14:31
 */
@RestController
@Slf4j
@RequestMapping("/buyer/order")
public class BuyerController {
    @Autowired
    private OrderService orderService;
    //创建订单
    @RequestMapping("create")
    public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("[创建订单] 参数不正确,orderForm={}",orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTO.convert(orderForm);
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("[创建订单] 购物车不能为空");
            throw new SellException((ResultEnum.CART_EMPTY));
        }
        OrderDTO result = orderService.create(orderDTO);
        Map<String,String> map = new HashMap<>();
        map.put("orderId",result.getOrderId());
        return ResultVOUtil.success(map);
    }

    //订单列表
    @RequestMapping("list")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,@RequestParam(value = "page",defaultValue = "0") Integer page,@RequestParam(value = "size",defaultValue = "10") Integer size){
        if(StringUtils.isEmpty(openid)){
            log.error("[查询订单列表] openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest pageRequest = new PageRequest(page,size);
        Page<OrderDTO> list = orderService.findList(openid, pageRequest);

        return ResultVOUtil.success(list.getContent());
    }

    //订单详情
    @RequestMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam("openid") String openid,@RequestParam("orderId") String orderId){
        //TODO 不安全的做法，改进
        OrderDTO orderDTO = orderService.findOne(orderId);
        if(!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)){

        }
        return ResultVOUtil.success(orderDTO);
    }

    //订单取消
    @RequestMapping("/cancel")
    public ResultVO cancel(@RequestParam("openid") String openid,@RequestParam("orderId") String orderId){
        //TODO 不安全 改进
        OrderDTO orderDTO = orderService.findOne(orderId);
        orderService.cancel(orderDTO);
        return ResultVOUtil.success();
    }
}
