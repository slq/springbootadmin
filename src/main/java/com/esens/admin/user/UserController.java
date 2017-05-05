package com.esens.admin.user;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("users", userRepository.findAll());
        return "welcome";
    }
}
