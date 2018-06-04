package com.programowanie.zespolowe.pz.api.blobs;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/blob")
public interface BlobAPI {

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity create(@RequestBody MultipartFile file,
                          @RequestParam("fileName") String fileName,
                          @RequestHeader HttpHeaders headers);

    @RequestMapping(value = "/{blobId}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity getBlob(@PathVariable(value = "blobId") String blobId);

    @RequestMapping(value = "/get", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity getBlobsNamesAndIds(@RequestHeader HttpHeaders headers);
}
