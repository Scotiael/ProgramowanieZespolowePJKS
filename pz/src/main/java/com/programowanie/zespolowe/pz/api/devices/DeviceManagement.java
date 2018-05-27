package com.programowanie.zespolowe.pz.api.devices;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.Gson;
import com.programowanie.zespolowe.pz.Utils.CommonUtil;
import com.programowanie.zespolowe.pz.dao.DeviceDAO;
import com.programowanie.zespolowe.pz.dao.UserDAO;
import com.programowanie.zespolowe.pz.entities.Device;
import com.programowanie.zespolowe.pz.entities.User;
import com.programowanie.zespolowe.pz.model.DeviceCreateDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class DeviceManagement implements DeviceAPI{

    Logger log = LoggerFactory.getLogger(DeviceManagement.class);

    @Autowired
    DeviceDAO deviceDAO;
    @Autowired
    UserDAO userDAO;
    @Autowired
    CommonUtil commonUtil;

    Gson gson = new Gson();

    @Override
    public ResponseEntity register(@RequestBody DeviceCreateDTO device, @RequestHeader HttpHeaders headers){
        User user = commonUtil.getTokenFromHeader(headers);

        if(user == null){
            return commonUtil.getResponseEntity("User not found.", HttpStatus.NOT_FOUND);
        }

        Device existingName = deviceDAO.findByNameAndUser(device.getName(), user);
        Device existingMac = deviceDAO.findByMacAdressAndUser(device.getName(), user);
        if(existingMac == null && existingName == null){
            return persistDevice(device, user);
        }
        return commonUtil.getResponseEntity("Duplicate mac or name.", HttpStatus.CONFLICT);
    }

    private ResponseEntity persistDevice(DeviceCreateDTO deviceDTO, User user){
        try {
            Device device = new Device();
            device.setName(deviceDTO.getName());
            device.setMacAdress(deviceDTO.getMacAdress());
            device.setUser(user);
            deviceDAO.save(device);
        } catch (DataAccessException e) {
            log.warn("Device creating exception", e);
            return commonUtil.getResponseEntity("Exception during device creating."
                    , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return commonUtil.getResponseEntity("Device created.", HttpStatus.OK);
    }

    @Override
    @JsonIgnore
    public ResponseEntity getDevicesList(@RequestHeader HttpHeaders headers){
        User user = commonUtil.getTokenFromHeader(headers);
        if(user == null){
            return commonUtil.getResponseEntity("User not found.", HttpStatus.NOT_FOUND);
        }
        List<Device> devices;
        try {
            devices = deviceDAO.findByUser(user);
        } catch (Exception e) {
            return commonUtil.getResponseEntity("Server error.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        log.info(devices.toString());
        return ResponseEntity.status(HttpStatus.OK).body(devices);
    }

}
