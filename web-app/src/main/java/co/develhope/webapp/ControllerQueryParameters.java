package co.develhope.webapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("v1/")
@RestController

public class ControllerQueryParameters {

    @GetMapping("/ciao")
    public String saluta (@RequestParam (name = "nome") String nome,
                          @RequestParam (name = "provincia") String provincia){
        return ("Ciao " + nome + " Com'è il tempo in " + provincia + "?");
    }
}
