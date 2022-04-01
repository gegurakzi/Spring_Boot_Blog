package com.cos.blog.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class BoardController {

    @GetMapping({"", "/"})
    public String Index() {
        return "index";
    }
}
