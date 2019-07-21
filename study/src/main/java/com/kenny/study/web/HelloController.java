package com.kenny.study.web;

import com.kenny.study.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author kenny_peng
 * @created 2019/7/21 下午5:26
 */
@Controller
public class HelloController {

    @Autowired
    private IHelloService helloService;

    @RequestMapping("hello")
    @ResponseBody
    public Object myTest(String userid){
        System.out.println(userid+"---------------");
        Object findUser = helloService.find(userid);


        return findUser;
    }

}
