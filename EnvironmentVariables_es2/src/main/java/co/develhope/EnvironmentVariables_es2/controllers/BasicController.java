package co.develhope.EnvironmentVariables_es2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {
    @Autowired
    Environment environment;
    @GetMapping
    public String getHello(){
        return environment.getProperty("welcomeMsg");
    }
}
