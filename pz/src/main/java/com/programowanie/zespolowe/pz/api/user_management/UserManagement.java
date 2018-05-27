package com.programowanie.zespolowe.pz.api.user_management;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonObject;
import com.programowanie.zespolowe.pz.Utils.CommonUtil;
import com.programowanie.zespolowe.pz.dao.RoleDAO;
import com.programowanie.zespolowe.pz.dao.UserDAO;
import com.programowanie.zespolowe.pz.entities.User;
import com.programowanie.zespolowe.pz.model.UserRegisterDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserManagement {

    Logger log = LoggerFactory.getLogger(UserManagement.class);

    @Autowired
    UserDAO userDAO;
    @Autowired
    RoleDAO roleDAO;
    @Autowired
    CommonUtil commonUtil;

    @RequestMapping(value= "/register", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity register(@RequestBody UserRegisterDTO userModel){
        if(userDAO.findByEmail(userModel.getEmail()) != null){
            return commonUtil.getResponseEntity("User already exists.", HttpStatus.CONFLICT);
        } else {
            try {
                persistUser(userModel);
            } catch (Exception e){
                return commonUtil.getResponseEntity("Server error.", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return commonUtil.getResponseEntity("User created", HttpStatus.OK);
    }

    private void persistUser(UserRegisterDTO userModel){
        User user = new User();
        user.setSurname(userModel.getLastName());
        user.setName(userModel.getFirstName());
        String passwordHashed = new BCryptPasswordEncoder().encode(userModel.getPassword());
        user.setPassword(passwordHashed);
        user.setEmail(userModel.getEmail());
        user.setRole(roleDAO.findByRole("user"));
        userDAO.save(user);
    }

}
