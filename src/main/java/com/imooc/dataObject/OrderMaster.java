package com.imooc.dataObject;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imooc.Utils.serializer.Date2LongSerializer;
import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created with IDEA
 * User:赵无聊
 * Date:2018/5/3
 * Time:21:13
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {
    @Id
    private  String orderId;
    private  String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;
    private BigDecimal orderAmount;
    private Integer orderStatus=OrderStatusEnum.NEW.getCode();
    private Integer payStatus=PayStatusEnum.WAIT.getCode();

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

}
