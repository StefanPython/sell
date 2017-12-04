package com.stefan.sell.sell;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Stefan
 * Create Date 2017-12-02/13:13
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class logTest1 {
    @Test
    public void test(){
        String name="stefan";
        String password="1245";
        log.info("logtest1日志");
        log.info("name:{},password {}",name,password);
        log.error("报错");
    }
}
