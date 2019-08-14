package com.ghozay19.issm.controller;

import com.ghozay19.issm.model.User;
import com.ghozay19.issm.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class PageController {

    @Autowired
    UserRepo userRepo;

    @RequestMapping(value = {"/login"})
    @ResponseBody
    public User getUserWithUsernameAndPassword(HttpServletRequest httpServletRequest, String username, String password) {

        System.out.println("GOJAY : " + username + " " + password);

        return userRepo.findByUsernameAndPassword(username, password);
    }

    @RequestMapping(value = {"/Register"})
    @ResponseBody
    public User registerUser(String name, String username, String password, String birthDate) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date formattedBirthDate = simpleDateFormat.parse(birthDate);
        return userRepo.save(new User(null, name, username, password, null, formattedBirthDate));

    }

}
