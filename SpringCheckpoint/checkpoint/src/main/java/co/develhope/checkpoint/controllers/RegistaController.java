package co.develhope.checkpoint.controllers;

import co.develhope.checkpoint.entities.Regista;
import co.develhope.checkpoint.services.RegistaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/regista")
public class RegistaController {
    @Autowired
    RegistaService registaService;

    @GetMapping("{id}")
    public ResponseEntity <Regista> getRegista(@PathVariable Long id){
       return ResponseEntity.ok(registaService.getRegista(id));
    }
    @GetMapping
    public ResponseEntity<Iterable<Regista>> getAllRegista(){
        return ResponseEntity.ok(registaService.getAllRegista());
    }
    @PostMapping
    public ResponseEntity<?> postRegista(@Valid @RequestBody Regista regista, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }else{
            return ResponseEntity.ok(registaService.postRegista(regista));
        }
    }
    @PutMapping
    public ResponseEntity<?> updateRegista(@Valid @RequestBody Regista regista, BindingResult bindingResult, @PathVariable Long id){
        if(bindingResult.hasErrors()){
           return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }else{
            return ResponseEntity.ok().body(registaService.updateRegista(regista, id));
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRegista(@PathVariable Long id){
        registaService.deleteRegista(id);
        return ResponseEntity.ok().body("Regista deleted");
    }
}
