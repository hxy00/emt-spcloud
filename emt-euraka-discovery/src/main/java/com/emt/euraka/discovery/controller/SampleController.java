package com.emt.euraka.discovery.controller;


import com.emt.euraka.discovery.pojo.PayAccountVO;
import com.emt.euraka.discovery.service.inter.IPayAccountSv;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2018-01-17.
 */
@Controller
@EnableAutoConfiguration
public class SampleController {

    public void InitBinderPayAccountVO(WebDataBinder binder)
    {
        binder.setFieldDefaultPrefix("payAccountVO.");
    }

    @Autowired
    private IPayAccountSv iPayAccountSv;

//    @RequestMapping("/")
//    @ResponseBody
//    String home(){
//        return "hello world";
//    }

    @RequestMapping("/pageAccount")
    @ResponseBody
    public PageInfo pageAccount(int pageIndex, int pageSize, PayAccountVO payAccountVO){
        PageInfo pageInfo = iPayAccountSv.pageAccount(pageIndex, pageSize, payAccountVO);
       return pageInfo;
    }

}
