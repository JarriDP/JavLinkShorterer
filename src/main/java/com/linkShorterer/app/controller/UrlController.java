package com.linkShorterer.app.controller;


import com.linkShorterer.app.model.UrlMapping;
import com.linkShorterer.app.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
        return urlService.getByOriginalUrl(originalUrl)
    }

}
