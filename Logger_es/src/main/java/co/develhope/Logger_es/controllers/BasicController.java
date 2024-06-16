package co.develhope.Logger_es.controllers;

import co.develhope.Logger_es.services.PowerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    private static final Logger logger = LoggerFactory.getLogger(BasicController.class);

    @Autowired
    PowerService powerService;

    @GetMapping("/:")
    public String welcomeMessage(){
        String welcomeMessage = "Welcome";
        logger.info(welcomeMessage);
        return welcomeMessage;
    }

    @GetMapping("/exp")
    public double servicePow(){
        return powerService.getPowEnv();
    }

    @GetMapping("/get-errors")
    public void getLoggingError(){
        Error error = new Error("Custom Error");
        logger.error("this is the logging error", error);
    }
}
