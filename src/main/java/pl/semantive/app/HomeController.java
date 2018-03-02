package pl.semantive.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Maciek on 2018-03-01.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String homepage() {
        return "index";
    }
}
