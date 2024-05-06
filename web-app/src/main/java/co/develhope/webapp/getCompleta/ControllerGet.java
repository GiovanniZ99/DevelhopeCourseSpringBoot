package co.develhope.webapp.getCompleta;

import org.springframework.web.bind.annotation.*;

@RequestMapping("v2/")
@RestController
public class ControllerGet {
    @GetMapping ("/ciao/{provincia}")
    public Persona saluta(@RequestParam String nome, @PathVariable String provincia){
    return new Persona(nome, provincia, "Ciao " + nome + " Com'è il tempo in " + provincia + "?");
    }
}
