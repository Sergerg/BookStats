package org.bookstats.web;

import org.bookstats.mapper.LinkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 25.11.2014
 * Time: 2:59
 */
@Controller
public class FormControllers {

    // TESTS
    @RequestMapping(value = "/testform")
    public String testform() {
        return "testform";
    }

    // TESTS
    @RequestMapping("/greeting")
    public String greeting() {
        return "greeting";
    }


    @Autowired
    private LinkMapper mapper;

    // Form for links
    @RequestMapping(value = "/links")
    public String links(Model model) {

//        return mapper.getAllLinks();
        model.addAttribute("links", mapper.getAllLinks());
        return "links";
    }

}
