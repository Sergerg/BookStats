package org.bookstats.web;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 11.11.2014
 * Time: 6:05
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetingController {

    @RequestMapping("/greeting")
    public String greeting() {
        return "greeting";
    }

}
