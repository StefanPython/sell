package com.stefan.sell.sell.Controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;



/**
 * Created by Stefan
 * Create Date 2017-12-02/22:17
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BuyerProductControllerTest {
    @Autowired
    private MockMvc mvc;
    BuyerProductController buyerProductController;
    @Test
    public void list() throws Exception {
        /*mvc.perform(MockMvcRequestBuilders.get("/buyer/product/list")).andExpect(MockMvcResultMatchers.status().isOk());*/



    }

}