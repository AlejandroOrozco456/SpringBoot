package com.example.instrumentosMus.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.instrumentosMus.models.Instrument;
import com.example.instrumentosMus.services.InstrumentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/instrumentos")
public class InstrumentController {
    @Autowired
    InstrumentService instrumentService;

    //GET
    @GetMapping()
    public ArrayList<Instrument> obtenerInstrumentos(){
        return instrumentService.todoLosInstrumentos();
    }
    //POST
    @PostMapping()
    public String guardarInstrument(@RequestBody Instrument inst ){       
        return instrumentService.guardar(inst);
        
    }
    @GetMapping("/{id}")
    public Optional<Instrument> guardar(@PathVariable("id") Long id){       
        return instrumentService.buscarporId(id);

    }
    @PostMapping("/{search}")
    public List<Instrument> buscar(@RequestParam("query") String query){
         var ins = instrumentService.buscarPorPalabra(query);
         System.out.println(ins);
        return ins;   
    }

    
    
    
}
