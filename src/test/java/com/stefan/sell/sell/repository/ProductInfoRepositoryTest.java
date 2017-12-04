package com.stefan.sell.sell.repository;

import com.stefan.sell.sell.pojo.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


/**
 * Created by Stefan
 * Create Date 2017-12-02/16:08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
    @Autowired
    ProductInfoRepository repository;
    @Test
    public void save(){
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId("22");
        productInfo.setProductName("蔬菜");
        repository.save(productInfo);
        System.out.println("保存成功");


    }
    @Test
    public void findByProductId(){
        List<String> ids=new ArrayList<>();
        ids.add("22");
        ids.add("11");
        ids.add("44");
        List<ProductInfo> results=repository.findByProductIdIn(ids);
        System.out.println(results);
        Assert.assertNotEquals(0,results.size());
    }


}