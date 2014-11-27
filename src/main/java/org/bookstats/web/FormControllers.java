package org.bookstats.web;

import org.bookstats.mapper.AuthorMapper;
import org.bookstats.mapper.LinkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
    private LinkMapper linkMapper;

    // Form for links
    @RequestMapping(value = "/links")
    public String links(Model model) {
        model.addAttribute("links", linkMapper.getAllLinks());
        return "links";
    }

    @Autowired
    private AuthorMapper authorMapper;
    // Form for authors
    @RequestMapping(value = "/authors")
    public String authors(Model model) {
        model.addAttribute("authors", authorMapper.getAllAuthors());
        return "authors";
    }

}
