package com.learn.springbase.control;

import com.learn.springbase.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.learn.springbase.service.WebService;

/**
 * @description
 * @author: fangjc
 * @create: 2021-01-30 22:10
 **/
@Slf4j
@RestController(value = "controller1")
public class Controller {
    //http://localhost:28080/private/health
    @Autowired
    WebService webService;

    @GetMapping("/health")
    public String healCheck() {
        log.info("ai-gongan-ne-performance is health");
        return "ok";
    }

    @GetMapping("/postcon")
    public String postCheck() {
        log.info("ai-gongan-ne-performance postCheck");
        return "postCheck";
    }

    @GetMapping("/testAop1")
    public String testAop1() {
        log.info("testAop1");
        return "postCheck";
    }

    @RequestMapping(value = "/testAop3", method = RequestMethod.GET)
    public String testAop3() {
        log.info("testAop3");
        return "postCheck";
    }

    @RequestMapping(value = "/testGet", method = RequestMethod.GET)
    public User testAop3(@RequestBody User user) {
        log.info("test Get");

        return user == null ? null : user;
    }
    /*
    {
    "timestamp": "2021-04-06T12:38:00.748+00:00",
    "status": 405,
    "error": "Method Not Allowed",
    "message": "",
    "path": "/private/testAop3"
}
     */
}
