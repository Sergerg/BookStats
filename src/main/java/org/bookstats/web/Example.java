package org.bookstats.web;

import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 11.11.2014
 * Time: 3:44
 */

@RestController
public class Example {

    @RequestMapping("/")
    String home() {
        return "Hello World1!";
    }
}