package com.stefan.sell.sell.repository;

import com.stefan.sell.sell.pojo.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Stefan
 * Create Date 2017-12-02/15:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    ProductCategoryRepository repository;
    @Test
    public void save(){
      System.out.println("测试");
        ProductCategory productCategory=new ProductCategory();
        productCategory.setCategoryName("女神最爱");
        productCategory.setCategoryType(2);
        productCategory.setCreateTime(new Date());
        productCategory.setUpdateTime(new Date());
      repository.save(productCategory);
    }
@Test
    public  void findone(){
        repository.findOne(1);
    }
    @Test
  public  void findByCategoryTypeIn(){
        List<Integer> ids=new ArrayList<Integer>(1);
        ids.add(1);
        ids.add(2);
        System.out.println(repository.findByCategoryTypeIn(ids));
  }
}