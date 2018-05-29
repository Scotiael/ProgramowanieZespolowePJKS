package com.programowanie.zespolowe.pz.api.devices;

import com.programowanie.zespolowe.pz.model.DeviceCreateDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/device")
public interface DeviceAPI {

    @RequestMapping(value= "/create", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity register(@RequestBody DeviceCreateDTO device, @RequestHeader HttpHeaders headers);

    @RequestMapping(value= "/get", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity getDevicesList(@RequestHeader HttpHeaders headers);

    @RequestMapping(value= "/delete/{someId}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity deleteDevice(@PathVariable(value = "someId") String deviceId, @RequestHeader HttpHeaders headers);

}
