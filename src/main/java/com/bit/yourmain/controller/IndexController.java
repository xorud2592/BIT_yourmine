package com.bit.yourmain.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequiredArgsConstructor
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }


    @GetMapping("/upload")
    public String upload(){
        return "upload";
    }

    @GetMapping("/v")
    public String f(){
        return "f";
    }
}
