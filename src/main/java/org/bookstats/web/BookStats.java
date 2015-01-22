package org.bookstats.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 22.01.2015
 * Time: 0:45
 */
@Controller
public class BookStats {

    @RequestMapping(value = "/books")
    public String testform() {
        return "main";
    }
}
