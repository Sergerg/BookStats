package org.bookstats.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 18.11.2014
 * Time: 10:17
 */
@Controller
public class TestForm {
    @RequestMapping(value = "/testform")
    public String greeting() {
        return "testform";
    }
}
