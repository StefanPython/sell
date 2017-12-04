package com.stefan.sell.sell.service.impl;

import com.stefan.sell.sell.service.CategoryService;
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
 * Create Date 2017-12-02/23:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {
    @Autowired
    CategoryService categoryService;
    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<Integer> ids=new ArrayList<Integer>(1);
        ids.add(1);
        ids.add(2);
        System.out.println(categoryService.findByCategoryTypeIn(ids));

    }

}