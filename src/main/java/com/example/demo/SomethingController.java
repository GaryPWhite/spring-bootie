package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SomethingController {

    private RedisController redisController = new RedisController();

    @RequestMapping("/")
    public String index() {
        String value = (String) redisController.getValue("fuck");
        return "your value is "+value;
    }

    @RequestMapping("/{value}")
    public String writeValue(@PathVariable("value") String value) {
        redisController.setValue("fuck", value);
        return "Wrote "+value;
    }
}