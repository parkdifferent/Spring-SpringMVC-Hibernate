package com.mangosis.ssh.controller;

import com.mangosis.ssh.entity.Test;
import com.mangosis.ssh.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by admin on 2017/5/9.
 */

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping(value = "/find",method = RequestMethod.GET)
    @ResponseBody
    public List<Test> test() {
        List<Test> list = testService.findByFirstName("tain");
        return list;
    }
}
