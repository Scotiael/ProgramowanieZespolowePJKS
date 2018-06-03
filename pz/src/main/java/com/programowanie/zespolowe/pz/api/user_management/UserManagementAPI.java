package com.programowanie.zespolowe.pz.api.user_management;

import com.programowanie.zespolowe.pz.model.UserRegisterDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
public interface UserManagementAPI {

    @RequestMapping(value= "/register", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity register(@RequestBody UserRegisterDTO userModel);

    @RequestMapping(value= "/get", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity getUser(@RequestHeader HttpHeaders headers);

}
