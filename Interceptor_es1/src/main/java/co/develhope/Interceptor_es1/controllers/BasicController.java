package co.develhope.Interceptor_es1.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/time")
public class BasicController {

    @GetMapping
    public String currentDateTime(){
        return LocalDate.now().toString();
    }
}
