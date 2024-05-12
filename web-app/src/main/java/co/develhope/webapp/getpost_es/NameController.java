package co.develhope.webapp.getpost_es;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/v2")
@RestController
@CrossOrigin(origins = "http://localhost:9000")
public class NameController {

    // il name ="" della RequestParam sarà la variabile locale
    @GetMapping("/name")
    public String nome(@RequestParam String nome) {
        return nome;
    }
    @PostMapping("/name")
    public String nomeAlContrario(@RequestParam String nome) {
        return new StringBuilder(nome).reverse().toString();
    }

    // PostMan
    // GET http://localhost:9000/v2/name?nome=Peppe
    // Peppe

    // POST http://localhost:9000/v2/name?nome=Peppe
    //  eppeP
}
