package com.stefan.sell.sell.repository;

import com.stefan.sell.sell.pojo.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;


/**
 * Created by Stefan
 * Create Date 2017-12-03/17:14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {
    @Autowired
    OrderDetailRepository orderDetailRepository;
    @Test
    public void findByOrderId() throws Exception {
        List<OrderDetail> orderDetails=orderDetailRepository.findByOrderId("1");
        System.err.println(orderDetails);
    }

}