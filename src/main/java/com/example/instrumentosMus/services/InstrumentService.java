package com.example.instrumentosMus.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.instrumentosMus.models.Instrument;
import com.example.instrumentosMus.repositories.InstrumentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstrumentService {
    @Autowired
    InstrumentRepository InstrumentRepo;

    public ArrayList<Instrument> todoLosInstrumentos(){     
        return (ArrayList<Instrument>) InstrumentRepo.findAll();
   }

   public String guardar(Instrument inst){
       InstrumentRepo.save(inst);
       return "guardado correctamente";
   }
   public Optional<Instrument> buscarporId(Long id){
    return InstrumentRepo.findById(id);
}
public List buscarPorPalabra(String query){
    List <Instrument> instrumentos = InstrumentRepo.findByKeyword(query);
     return instrumentos;
}
   
}
