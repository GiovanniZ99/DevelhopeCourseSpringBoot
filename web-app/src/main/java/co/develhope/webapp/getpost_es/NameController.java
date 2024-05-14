package co.develhope.webapp.getpost_es;
import jdk.jfr.Description;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;

@RequestMapping("/v3")
@RestController
// Esercizio cross
@CrossOrigin(origins ="9000")
public class NameController {

    // il name ="" della RequestParam sarà la variabile locale
    @GetMapping("/name")
    @Description("Il metodo restituisce il valore del parametro")
    @Operation(summary="Riassunto più riassuntivo")
    public String nome(@RequestParam String nome) {
        return nome;
    }
    @PostMapping("/name")
    public String nomeAlContrario(@RequestParam String nome) {
        return new StringBuilder(nome).reverse().toString();
    }

    // PostMan
    // GET http://localhost:9000/v3/name?nome=Peppe
    // Peppe

    // POST http://localhost:9000/v3/name?nome=Peppe
    //  eppeP
}
