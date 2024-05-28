package co.develhope.checkpoint.services;

import co.develhope.checkpoint.entities.Regista;
import co.develhope.checkpoint.repositories.RegistaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistaService {
    @Autowired
    RegistaRepository registaRepository;

    public Regista getRegistaById(Long id){
        Optional<Regista> optionalRegista = registaRepository.findById(id);
        if(optionalRegista.isPresent()){
        Regista regista = optionalRegista.get();
       return registaRepository.save(regista);
        }else{
            throw new EntityNotFoundException("Not found");
        }
    }
    public Iterable<Regista> getAllRegista(){
       return registaRepository.findAll();
    }
    public Regista postRegista(Regista regista){
        return registaRepository.save(regista);
    }
    public Regista updateRegista(Regista regista, Long id){
        Optional <Regista> optionalRegista = registaRepository.findById(id);
        if(optionalRegista.isPresent()){
          Regista updated =  optionalRegista.get();
          updated.setNome(regista.getNome());
          updated.setNationality(regista.getNationality());
          updated.setBirthday(regista.getBirthday());
          return registaRepository.save(updated);
        }else{
            throw new EntityNotFoundException("Not found");
        }
    }
    public void deleteRegistaById(Long id){
        Optional<Regista> optionalRegista = registaRepository.findById(id);
        if(optionalRegista.isPresent()){
            Regista regista = optionalRegista.get();
            registaRepository.deleteById(id);
        }else{
            throw new EntityNotFoundException("Not found");
        }
    }
}
