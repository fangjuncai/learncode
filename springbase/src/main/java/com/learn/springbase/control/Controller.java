package com.learn.springbase.control;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.learn.springbase.service.WebService;

/**
 * @description
 * @author: fangjc
 * @create: 2021-01-30 22:10
 **/
@Slf4j
@RestController
public class Controller {
    //http://localhost:28080/private/health
    @Autowired
    WebService webService;
    @GetMapping("/health")
    public String healCheck() {
        log.info("ai-gongan-ne-performance is health");
        return  "ok";
    }
    @GetMapping("/postcon")
    public String postCheck() {
        log.info("ai-gongan-ne-performance postCheck");
        return  "postCheck";
    }
}
