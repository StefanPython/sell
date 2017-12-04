package com.stefan.sell.sell.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Stefan
 * Create Date 2017-12-02/22:32
 */
@RestController
@RequestMapping("/hello")
public class hello {
    @GetMapping("/words")
    public String say(){
        return "hello";
    }
}
