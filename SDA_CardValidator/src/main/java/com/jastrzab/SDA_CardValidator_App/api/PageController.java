package com.jastrzab.SDA_CardValidator_App.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {


    @CrossOrigin
    @GetMapping("/")
    public String index(){
        return "index.html";
    }

//    @GetMapping("{file}")
//    public String anyFile(@PathVariable("file") String file){
//        return file;
//    }
}
