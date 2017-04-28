package com.dhc.springdemo.controller;

import com.dhc.springdemo.entity.User;
import com.dhc.springdemo.repository.UserRepo;
import com.dhc.springdemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by reed on 2017/4/27.
 */
@Controller
public class HelloController {
    private static final Logger logger= LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserService userService;

    @RequestMapping(value="/hello.do",method= RequestMethod.GET)
    public String hello(User user) {
        logger.debug("Here: are users");
        logger.debug("Users:" + userRepo.findAll());
        return "hello";
    }
    @RequestMapping( value="/hello.do", method = RequestMethod.POST)
    public String doHello(@Valid User user , BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "hello";
        }
        userService.save(user);
        logger.debug("name: "+user.getUsername());
        return "redirect:/hello.do";
    }
    @RequestMapping( value = "/listusers.do", method = RequestMethod.GET)
    @ResponseBody
    public List<User> listUsers() {

       return userRepo.findAll();
    }
}
