package com.programowanie.zespolowe.pz.api.blobs;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Api do zarządzania plikami
 */
@RequestMapping("/blob")
public interface BlobAPI {

    /**
     * Pozawala dodać plik do bazy
     *
     * @param file     - plik
     * @param fileName - nazwa pliku
     * @param headers  - nagłówek
     */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity create(@RequestBody MultipartFile file,
                          @RequestParam("fileName") String fileName,
                          @RequestHeader HttpHeaders headers);

    /**
     * Pobiera plik o podanym id.
     *
     * @param blobId - identyfikator pliku
     */
    @RequestMapping(value = "/{blobId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity getBlob(@PathVariable(value = "blobId") String blobId);

    /**
     * Pobiera wszystkie pliki
     *
     * @param headers - nagłówek
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity getBlobsNamesAndIds(@RequestHeader HttpHeaders headers);
}
