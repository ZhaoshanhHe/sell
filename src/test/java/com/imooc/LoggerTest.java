package com.imooc;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {
    String name="赵山河";
    String password="123456";
    @Test
    public void test1(){
        log.debug("debug...");
        log.error("error...");
        log.info("info...");
        log.info("name:{},password:{}",name,password);
    }

}
