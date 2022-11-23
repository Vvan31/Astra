package com.project.astral.CRUD;

import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class CRUDController {
    
    public CRUDService crudService;

    public CRUDController(CRUDService crudService){
        this.crudService = crudService;
    }

    @PostMapping("/create")
    public String createCRUD(@RequestBody CRUD crud) throws IllegalAccessException, ExecutionException, InterruptedException{
        return crudService.createCRUD(crud);
    }

    @GetMapping("/get")
    public CRUD getCRUD(@RequestParam String documentId) throws IllegalAccessException, ExecutionException, InterruptedException{
        return crudService.getCRUD(documentId);
    }

    @PutMapping("/update")
    public String updateCRUD(@RequestBody CRUD crud) throws IllegalAccessException, ExecutionException{
        return crudService.updateCRUD(crud);
    }

    @PutMapping("/delete")
    public String deleteCRUD(@RequestParam String documentId) throws IllegalAccessException, ExecutionException{
        return crudService.deleteCRUD(documentId);
    }
    
    @GetMapping("/test")
    public ResponseEntity<String> testGetEndpoint(){
        return ResponseEntity.ok("Test get is working!! :)");
    }
}
