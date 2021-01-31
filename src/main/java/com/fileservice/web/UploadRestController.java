package com.fileservice.web;

import com.fileservice.model.DataObject;
import com.fileservice.repository.CrudDataJpaReposytory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * User: Vitaliy Klimov
 * Date: 22.01.2021
 */
@RestController
@RequestMapping(value = UploadRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class UploadRestController {
    static final String REST_URL = "/rest/upload";

    @Autowired
    private CrudDataJpaReposytory reposytory;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<String> create(@RequestParam("file") MultipartFile file) {
        System.out.println("Uploaded File Name = " + file.getOriginalFilename() + file.getSize());
        //File testfile = new File("C:/sure-delete/" + file.getOriginalFilename());
        if (!file.isEmpty()) {
            DataObject dataObject = new DataObject();
            try {
                dataObject.setFile(file.getBytes());
                dataObject.setName(file.getOriginalFilename());
                reposytory.save(dataObject);
                return ResponseEntity.ok("File uploaded successfully ...");
            } catch (Exception e) {
                return ResponseEntity.ok("File upload error ...");
            }
        } else {
            return ResponseEntity.ok("File is empty ...");
        }
    }
}
