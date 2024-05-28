package co.develhope.checkpoint.controllers;

import co.develhope.checkpoint.entities.Regista;
import co.develhope.checkpoint.services.RegistaService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registi")
public class RegistaController {
    @Autowired
    RegistaService registaService;

    @GetMapping("{id]")
    public ResponseEntity<?> getRegista(@PathVariable Long id){
        try {
            return ResponseEntity.ok().body(registaService.getRegistaById(id));
        } catch (EntityNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping
    public ResponseEntity<Iterable<Regista>> getAllRegista(){
        return ResponseEntity.ok(registaService.getAllRegista());
    }
    @PostMapping
    public ResponseEntity<?> postRegista(@Valid @RequestBody Regista regista, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            bindingResult.getAllErrors();
        }
            return ResponseEntity.ok().body(registaService.postRegista(regista));
    }
    @PutMapping("{id}")
    public ResponseEntity<?> putRegista(@Valid @RequestBody Regista regista, @PathVariable Long id, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            bindingResult.getAllErrors();
        }
        try {
            return ResponseEntity.ok().body(registaService.updateRegista(regista,id));
        }catch(EntityNotFoundException e){
           return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping
    public ResponseEntity<String> deleteRegista(Long id){
        registaService.deleteRegistaById(id);
        return ResponseEntity.ok("Deleted");
    }
}
