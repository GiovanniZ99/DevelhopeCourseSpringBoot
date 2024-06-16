package co.develhope.Logger_es.services;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class PowerService {
    @Autowired
    private Environment env;
    private static final Logger logger = LoggerFactory.getLogger(PowerService.class);

    // creiamo dal codice la directory con mkdirs (make directories)
    @PostConstruct
    public void init() {
        File logDir = new File("logs/myCustomLogs");
        if (!logDir.exists()) {
            logDir.mkdirs();
        }
    }
    public double getPowEnv() {
        double value1 = Double.parseDouble(env.getProperty("custom.value1", "2"));
        double value2 = Double.parseDouble(env.getProperty("custom.value2", "8"));
        logger.info("Calculation is starting");
        double result = Math.pow(value1,value2);
        logger.info("Calculation finished");
        return result;
    }
}
