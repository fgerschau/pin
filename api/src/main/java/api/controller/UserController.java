package api.controller;

import api.model.User;
import api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;

@RestController
public class UserController {
    @Autowired
    UserService service;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
     public Page<User> get(@RequestParam(value="search", required=false) String search, @RequestParam(value="teacher", required=false, defaultValue = "true") Boolean isTeacher, Pageable pageable) {

        Page<User> users = service.get(search, isTeacher, pageable);

        return users;
    }
}
