package org.bookstats.web;

import org.bookstats.mapper.UserMapper;
import org.bookstats.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 11.11.2014
 * Time: 7:19
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper mapper;

    @RequestMapping(value = "/user/add")
    public List createUser(@RequestParam("login") String login) {
        User user = new User();
        user.setLogin(login);
        mapper.addUser(user);

        return mapper.getAllUsers();
    }
}