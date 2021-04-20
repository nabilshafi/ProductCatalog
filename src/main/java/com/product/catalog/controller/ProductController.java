package com.product.catalog.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.catalog.model.Category;
import com.product.catalog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProductController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public ResponseEntity <String> createProduct(@RequestBody Category category, UriComponentsBuilder ucBuilder) {

        categoryService.save(category);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/category/{id}").buildAndExpand(category).toUri());
        return new ResponseEntity<String>("Successful", HttpStatus.CREATED);

    }

    @RequestMapping(value = "/addProducts", method = RequestMethod.POST)
    public ResponseEntity <String> createProduct(@RequestBody List <Category> category, UriComponentsBuilder ucBuilder) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
      //  mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        //List <Category> category = mapper.readValue(jsonInString, new TypeReference<List<Category>>(){});
        /*List <Category> category = mapper.reader()
                .forType(new TypeReference<List<Category>>() {})
                .readValue(jsonInString);*/
        categoryService.saveAll(category);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/category/{id}").buildAndExpand(category).toUri());
        return new ResponseEntity<String>("Successful", HttpStatus.CREATED);

    }

    @RequestMapping(value = "getAll",method = RequestMethod.GET)
    public ResponseEntity<List<Category>> listAllUsers() {
        List<Category> category = categoryService.getAll();
        if (category.isEmpty()) {
            return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Category>>(category, HttpStatus.OK);
    }
}
