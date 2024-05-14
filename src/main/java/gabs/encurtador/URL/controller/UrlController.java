package gabs.encurtador.URL.controller;

import com.sun.net.httpserver.Headers;
import gabs.encurtador.URL.dto.UrlRequest;
import gabs.encurtador.URL.dto.UrlResponse;
import gabs.encurtador.URL.service.EncurtarURL;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(value = "/v1/api")
public class UrlController {

    @Autowired
    private EncurtarURL service;

    @PostMapping(value = "/encurtador-url")
    public ResponseEntity<UrlResponse> encurtarURL(@RequestBody UrlRequest url, HttpServletRequest request) {
        return ResponseEntity.ok().body(service.encurtarUrl(url, request.getRequestURL().toString()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Void> redirect(@PathVariable(value = "id") String codeURL) {

        String url = service.redirectURL(codeURL);

        if (url.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(url));

        return ResponseEntity.status(HttpStatus.FOUND).headers(headers).build();
    }

}
