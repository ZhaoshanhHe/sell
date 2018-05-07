package com.imooc.Utils;

import java.util.Random;

/**生成随机数方法
 *
 * Created with IDEA
 * User:赵无聊
 * Date:2018/5/7
 * Time:16:50
 */
public class KeyUtil {
    /**
     * 生成唯一主键
     * 格式:时间+随机数
     * @return
     */
    public static synchronized String genUniqueKey(){
        Random random=new Random();
        Integer number = random.nextInt(900000) + 100000;
        return  System.currentTimeMillis()+String.valueOf(number);
    }
}
