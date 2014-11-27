package org.bookstats.web;

import org.bookstats.mapper.AuthorMapper;
import org.bookstats.mapper.LinkMapper;
import org.bookstats.mapper.UserMapper;
import org.bookstats.model.Author;
import org.bookstats.model.Link;
import org.bookstats.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 27.11.2014
 * Time: 2:48
 */

@RestController
public class RestControllers {

    @Autowired
    private AuthorMapper authorMapper;

    @RequestMapping(value = "/author/add")
    public List createAuthor(@RequestParam("nick") String nick) {
        Author author = new Author();
        author.setNick(nick);
        authorMapper.addAuthor(author);

        return authorMapper.getAllAuthors();
    }

    @Autowired
    private LinkMapper linkMapper;

    @RequestMapping(value = "/link/add")
    public List createLink(@RequestParam(value = "title", required = false) String title,
                           @RequestParam(value = "url", required = true) String url) {
        Link link = new Link();
        if (title == null || title == "") {
            title = url;
        }
        link.setTitle(title);
        link.setUrl(url);
        linkMapper.addLink(link);

        return linkMapper.getAllLinks();
    }

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/user/add")
    public List createUser(@RequestParam("login") String login) {
        User user = new User();
        user.setLogin(login);
        userMapper.addUser(user);

        return userMapper.getAllUsers();
    }

}
