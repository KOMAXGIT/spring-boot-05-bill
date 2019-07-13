package com.menxuegu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BillController {

    @GetMapping("/bills")
    public String list(){
        //模拟500
        int i=0;
        if(i==0){
            throw new RuntimeException("i不能为0");
        }
        return "bill/list";
    }


}
