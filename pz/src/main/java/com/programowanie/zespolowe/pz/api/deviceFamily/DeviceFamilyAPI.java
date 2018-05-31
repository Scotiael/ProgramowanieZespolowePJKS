package com.programowanie.zespolowe.pz.api.deviceFamily;

import com.programowanie.zespolowe.pz.entities.Devicefamily;
import com.programowanie.zespolowe.pz.model.DeviceFamilyDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/deviceFamily")
public interface DeviceFamilyAPI {

    @RequestMapping(value= "/create/{familyName}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity create(@PathVariable(value = "familyName") String familyName, @RequestHeader HttpHeaders headers);

    @RequestMapping(value= "/get", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity getDevicesFamilyList(@RequestHeader HttpHeaders headers);

    @RequestMapping(value= "/delete/{familyId}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity deleteDeviceFamily(@PathVariable(value = "familyId") String deviceId);

    @RequestMapping(value= "/get/{familyId}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity getDeviceFamily(@PathVariable(value = "familyId") String deviceFamilyId,@RequestHeader HttpHeaders headers);

    @RequestMapping(value= "/edit", method = RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity editFamily(@RequestBody Devicefamily devicefamily);

    @RequestMapping(value= "/addDevice", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity addDeviceToFamily(DeviceFamilyDTO deviceFamilyDTO);

    @RequestMapping(value= "/removeDevice", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity removeDeviceToFamily(DeviceFamilyDTO deviceFamilyDTO);
}
