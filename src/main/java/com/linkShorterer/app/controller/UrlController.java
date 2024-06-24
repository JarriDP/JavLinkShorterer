package com.linkShorterer.app.controller;


import com.linkShorterer.app.model.UrlMapping;
import com.linkShorterer.app.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UrlController {

    @Autowired
    private UrlService urlService;

    @GetMapping("/urls")
        public List<UrlMapping> getAllUrls(){
            return urlService.getAllUrls();
        }


    @GetMapping("/{url}")
    public UrlMapping getByOriginalUrl(@RequestBody String originalUrl){
        return urlService.getByOriginalUrl(originalUrl);
    }

    @PostMapping("/short")
    public ResponseEntity<String> shortNewUrl (@RequestBody String originalUrl) {
        if(originalUrl == null || originalUrl.isEmpty()){
            return ResponseEntity.badRequest().body("Introduce una URL");
        }
        try{
            urlService.generateShorteredUrl(originalUrl);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Error al acortar la url");
        }

    }

}
