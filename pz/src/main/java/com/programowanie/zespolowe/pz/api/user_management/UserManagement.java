package com.programowanie.zespolowe.pz.api.user_management;

import com.programowanie.zespolowe.pz.dao.RoleDAO;
import com.programowanie.zespolowe.pz.dao.UserDAO;
import com.programowanie.zespolowe.pz.entities.User;
import com.programowanie.zespolowe.pz.model.UserRegisterDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @RequestMapping(value= "/register", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity register(@RequestBody UserRegisterDTO userModel){
        if(userDAO.findByEmail(userModel.getEmail()) != null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email is already used.");
        } else {
            try {
                persistUser(userModel);
            } catch (Exception e){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server error.");
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body("User created");
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
