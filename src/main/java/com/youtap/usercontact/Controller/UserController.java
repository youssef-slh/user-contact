package com.youtap.usercontact.Controller;

import com.youtap.usercontact.DTO.User;
import com.youtap.usercontact.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("getusercontacts/{param}")
    public User getUserContact(@PathVariable("param") String param){
        return  userService.getUserByParam(param);
    }
}
