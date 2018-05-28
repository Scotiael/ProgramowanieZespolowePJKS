package com.programowanie.zespolowe.pz.api.user_management;

import com.programowanie.zespolowe.pz.model.UserRegisterDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/user")
public interface UserManagementAPI {

    @RequestMapping(value= "/register", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity register(@RequestBody UserRegisterDTO userModel);

}
