package com.imooc.converter;

import com.imooc.dataObject.OrderMaster;
import com.imooc.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IDEA
 * User:赵无聊
 * Date:2018/5/14
 * Time:22:20
 */
public class OrderMaster2OrderDTO {
    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
        return   orderMasterList.stream().map(e->convert(e)).collect(Collectors.toList());
    }
}
