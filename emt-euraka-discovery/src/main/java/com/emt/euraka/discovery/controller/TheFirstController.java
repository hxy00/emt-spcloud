package com.emt.euraka.discovery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2018-01-19.
 */
@Controller
@RequestMapping("/first")
public class TheFirstController {

    @RequestMapping("/hello")
    @ResponseBody
    public String helloWorld(){
        return "Hello World!";
    }

}
