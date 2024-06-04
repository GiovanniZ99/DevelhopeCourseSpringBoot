package co.develhope.Interceptor_es1.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/time")
public class BasicController {
    public ResponseEntity<LocalDate> currentDateTime(){
        return ResponseEntity.ok(LocalDate.now());
    }
}
