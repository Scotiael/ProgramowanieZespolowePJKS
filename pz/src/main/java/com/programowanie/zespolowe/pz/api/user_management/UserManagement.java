package com.programowanie.zespolowe.pz.api.user_management;

import com.programowanie.zespolowe.pz.dao.RoleDAO;
import com.programowanie.zespolowe.pz.dao.UserDAO;
import com.programowanie.zespolowe.pz.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserManagement {

    @Autowired
    UserDAO userDAO;
    @Autowired
    RoleDAO roleDAO;

    @RequestMapping(value= "/register", method = RequestMethod.POST)
    public String register(){
        User user = new User();
        user.setSurname("test");
        user.setName("test");
        user.setPassword("test");
        user.setEmail("test");
        //user.setRole(roleDAO.findById(1L).get());
        userDAO.save(user);
        return "Hello World";
    }
}
