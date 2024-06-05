package co.develhope.Interceptor_es2.cotrnollers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {
    public ResponseEntity<String> getWelcome(){
        return ResponseEntity.ok().body("Welcome to the root mapping");
    }
}
