package pl.semantive.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Maciek on 2018-02-27.
 */

@RestController
public class HomeController {

    @RequestMapping(value = "/")
    public String home(){
        return "home";
    }
}
