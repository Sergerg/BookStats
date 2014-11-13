package org.bookstats.web;

import org.bookstats.mapper.AuthorMapper;
import org.bookstats.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 13.11.2014
 * Time: 11:55
 */
@RestController
public class AuthorController {
    @Autowired
    private AuthorMapper mapper;

    @RequestMapping(value = "/author/add")
    public List createUser(@RequestParam("nick") String nick) {
        Author author = new Author();
        author.setNick(nick);
        mapper.addAuthor(author);

        return mapper.getAllAuthors();
    }
}
