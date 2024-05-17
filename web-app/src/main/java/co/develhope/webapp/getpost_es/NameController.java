package co.develhope.webapp.getpost_es;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;


@RequestMapping("/v3")
@RestController
@CrossOrigin(origins ="9000")
public class NameController {

    // il name ="" della RequestParam sarà la variabile locale
    @GetMapping("/name")
    @Operation(summary = "Get name")
    public String nome(@RequestParam String nome) {
        return nome;
    }
    @PostMapping("/name")
    public String nomeAlContrario(@RequestParam String nome) {
        return new StringBuilder(nome).reverse().toString();
    }
/*package co.develhope.webapp.getpost_es;

import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;

    @RestController
    @RequestMapping("/v3")
    @CrossOrigin(origins ="http://localhost:9000")
    public class NameController {

        @GetMapping("/name")
        @Operation(summary = "Get name")
        public String getName(@RequestParam String nome) {
            return nome;
        }

        @PostMapping("/name")
        public String reverseName(@RequestParam String nome) {
            return new StringBuilder(nome).reverse().toString();
        }
    } */
    // PostMan
    // GET http://localhost:9000/v2/name?nome=Peppe
    // Peppe

    // POST http://localhost:9000/v2/name?nome=Peppe
    //  eppeP
}
