package gabs.encurtador.URL.controller;

import gabs.encurtador.URL.dto.UrlRequest;
import gabs.encurtador.URL.dto.UrlResponse;
import gabs.encurtador.URL.service.EncurtarURL;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlController {

    @Autowired
    private EncurtarURL service;

    @PostMapping(value = "/encurtador-url")
    public ResponseEntity<UrlResponse> encurtarURL(@RequestBody UrlRequest url, HttpServletRequest request) {
        return ResponseEntity.ok().body(service.encurtarUrl(url, request.getRequestURL().toString()));
    }

}
