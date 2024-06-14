package co.develhope.Deploy_es2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class BasicController {
    @GetMapping
    public int getRandInt(){
        Random random = new Random();
        int firstNum = random.nextInt(10);
        int secondNum = random.nextInt(10);
        return firstNum + secondNum;
    }
}
