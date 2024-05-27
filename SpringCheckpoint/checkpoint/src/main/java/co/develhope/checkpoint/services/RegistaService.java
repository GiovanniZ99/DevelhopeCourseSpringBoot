package co.develhope.checkpoint.services;

import co.develhope.checkpoint.entities.Regista;
import co.develhope.checkpoint.repositories.RegistaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.NoSuchElementException;
import java.util.Optional;

public class RegistaService {
    @Autowired
    RegistaRepository registaRepository;
    public Regista getRegista(Long id){
      return registaRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
    public Iterable<Regista> getAllRegista(){
        return registaRepository.findAll();
    }
    public Regista postRegista(Regista regista){
        Optional<Regista> optionalRegista = registaRepository.findById(regista.getId());
        if(optionalRegista.isPresent()){
            throw new NoSuchElementException("already exists");
        }else{
           return registaRepository.save(regista);
        }
    }
    public Regista updateRegista(Regista regista, Long id){
        Optional<Regista> optionalRegista = registaRepository.findById(id);
        if(optionalRegista.isPresent()){
         Regista updatedRegista = optionalRegista.get();
         updatedRegista.setName(regista.getName());
         updatedRegista.setNationality(regista.getNationality());
         updatedRegista.setBirthday(regista.getBirthday());
         return registaRepository.save(updatedRegista);
        }else{
            throw new NoSuchElementException("not found");
        }
    }
    public void deleteRegista(Long id){
        registaRepository.deleteById(id);
    }
}
