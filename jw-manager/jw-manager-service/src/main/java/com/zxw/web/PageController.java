package com.zxw.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {

    @RequestMapping("/{category}/{path}")
    public String page(@PathVariable String category,@PathVariable String path){
//        return "/"+category+"/"+path;
        return category+"/"+path;
    }
}
