package com.tekup.Project.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tekup.Project.entity.User;
import com.tekup.Project.repository.UserRepository;

//////////////requests related to user registration and login


@Controller
public class ParentController {

    @Autowired
    private UserRepository userRepository;

    // for testing purpose
    @GetMapping("/")
    public String show() {
        return "home";// the view name
    }

    // handler for showing the registration page
    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("user") User user) {
        return "registrationPage";//to display the registration form
    }
    //Handler for showing the login page
    @GetMapping("/loginPage")
    public String loginPage(@ModelAttribute("user") User user) {
        return "loginPage";
    }
    //Handler for registration process
    @PostMapping("/register")
    @ResponseBody
    public String register(@ModelAttribute("user") User user) {
        //for hashing the password and saving user data
        System.out.println(user);
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));
        user.setPassword(hashedPassword);

        userRepository.save(user);
        return "Data saved Successfully!!";
    }
    //Handler for Login process
    @PostMapping("/login")
    @ResponseBody
    public String loginProcess(@RequestParam("email") String email,
    @RequestParam("password") String password) {
        //for checking login credentials
        User dbuser=userRepository.findByEmail(email);
        Boolean isPasswordMatch=BCrypt.checkpw(password, dbuser.getPassword());
        if(isPasswordMatch)
            return "welcome to Dashboard of user " + dbuser.getEmail();
        else
            return "failed to login";
    }
}
