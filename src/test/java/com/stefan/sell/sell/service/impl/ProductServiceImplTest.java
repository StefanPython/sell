package com.stefan.sell.sell.service.impl;

import com.stefan.sell.sell.pojo.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.*;
import java.awt.print.Pageable;

import static org.junit.Assert.*;


/**
 * Created by Stefan
 * Create Date 2017-12-02/19:17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
    @Autowired
    ProductServiceImpl productService;
    @Test
    public void findOne() throws Exception {
        productService.findOne("22");
    }

    @Test
    public void findUpAll() throws Exception {
    }

    @Test
    public void findAll() throws Exception {
        PageRequest pageRequest=new PageRequest(0,2);
        Page<ProductInfo> results=productService.findAll(pageRequest);

        System.out.println(results.getTotalElements());
        System.out.println(results.getTotalPages());
        System.out.println(results.getContent());

    }

    @Test
    public void save() throws Exception {
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId("33");
        productInfo.setProductName("肉肉");
        ProductInfo result=productService.save(productInfo);
        System.out.println("添加成功"+result);
    }

}