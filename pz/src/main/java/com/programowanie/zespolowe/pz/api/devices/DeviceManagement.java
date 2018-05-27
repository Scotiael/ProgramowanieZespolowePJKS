package com.programowanie.zespolowe.pz.api.devices;

import com.programowanie.zespolowe.pz.Utils.CommonUtil;
import com.programowanie.zespolowe.pz.dao.DeviceDAO;
import com.programowanie.zespolowe.pz.dao.UserDAO;
import com.programowanie.zespolowe.pz.entities.Device;
import com.programowanie.zespolowe.pz.entities.User;
import com.programowanie.zespolowe.pz.model.DeviceCreateDTO;
import com.programowanie.zespolowe.pz.model.UserRegisterDTO;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.NonTransientDataAccessException;
import org.springframework.dao.RecoverableDataAccessException;
import org.springframework.dao.TransientDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.font.Script;

import javax.script.ScriptException;
import javax.xml.ws.Response;
import java.sql.SQLException;

@RestController
@RequestMapping("/device")
public class DeviceManagement {

    Logger log = LoggerFactory.getLogger(DeviceManagement.class);

    @Autowired
    DeviceDAO deviceDAO;
    @Autowired
    UserDAO userDAO;

    @RequestMapping(value= "/create", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity register(@RequestBody DeviceCreateDTO device, @RequestHeader HttpHeaders headers){
        String userEmail = CommonUtil.getTokenFromHeader(headers);

        if(userEmail == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }

        User user = userDAO.findByEmail(userEmail);
        Device existingName = deviceDAO.findByNameAndUser(device.getName(), user);
        Device existingMac = deviceDAO.findByMacAdressAndUser(device.getName(), user);
        if(existingMac == null && existingName == null){
            return persistDevice(device, user);
        }
        return  ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body("Duplicate mac or name.");
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
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Exception during device creating.");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Device created.");
    }

}
