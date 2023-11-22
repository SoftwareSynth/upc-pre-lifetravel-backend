package com.nexusnova.lifetravelapi.configuration.security;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@RestController
@RequestMapping("/iot/logger")
@Tag(name="IOT Logger Controller")
@CrossOrigin
public class IOTLogger {

    @PostMapping("/token")
    public String getToken(@RequestBody @Valid IOTLoginRequest request) throws IOException {
        String url = "https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyAYCuRtIMwuPYgezV8R5-QD373Tx4nhJAg";
        String body = "{\n" +
                "  \"email\": \"" + request.getEmail() + "\",\n" +
                "  \"password\": \"" + request.getPassword() + "\",\n" +
                "  \"returnSecureToken\": true\n" +
                "}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(body, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);



        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return String.valueOf(response.getStatusCodeValue());
        }
    }
}
