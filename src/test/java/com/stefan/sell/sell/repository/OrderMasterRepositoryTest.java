package com.stefan.sell.sell.repository;

import com.stefan.sell.sell.pojo.OrderMaster;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


/**
 * Created by Stefan
 * Create Date 2017-12-03/17:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
    @Autowired
    OrderMasterRepository orderMasterRepository;
    @Test
    public void findByBuyerOpenid() throws Exception {
        PageRequest pageRequest=new PageRequest(0,2);
        Page<OrderMaster> masterPage=orderMasterRepository.findByBuyerOpenid("1213asfjsnmdfj",pageRequest);
        System.out.println(masterPage.getContent());
        System.err.println(masterPage);

    }

}