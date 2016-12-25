package ru.kamagames.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Timofey on 25.12.2016.
 */
@RestController
@RequestMapping("test")
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello controller";
    }
}
