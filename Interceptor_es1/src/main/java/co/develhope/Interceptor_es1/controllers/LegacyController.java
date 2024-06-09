package co.develhope.Interceptor_es1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Legacy")
public class LegacyController {
    @GetMapping
    public String getLegacy(){
        return "This is just old code";
    }
}
