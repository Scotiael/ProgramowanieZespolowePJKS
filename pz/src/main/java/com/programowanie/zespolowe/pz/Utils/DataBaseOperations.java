package com.programowanie.zespolowe.pz.Utils;

import com.programowanie.zespolowe.pz.entities.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.NoSuchElementException;

public class DataBaseOperations {


    public static <T extends JpaRepository> ResponseEntity deleteById(String deviceId, T dao,CommonUtil commonUtil){
        try{
            dao.deleteById(Integer.parseInt(deviceId));
        } catch (NumberFormatException n){
            return commonUtil.getResponseEntity("Not a number.", HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            return commonUtil.getResponseEntity("Server error.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return commonUtil.getResponseEntity("Device deleted.", HttpStatus.OK);
    }

    public static <T extends JpaRepository> ResponseEntity getById(String deviceId, T dao,CommonUtil commonUtil){
        try{
            Object device = dao.findById(Integer.parseInt(deviceId)).get();
            return ResponseEntity.status(HttpStatus.OK).body(device);
        } catch (NumberFormatException n){
            return commonUtil.getResponseEntity("Not a number.", HttpStatus.BAD_REQUEST);
        } catch (NoSuchElementException e){
            return commonUtil.getResponseEntity("Device not found.", HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return commonUtil.getResponseEntity("Server error.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}