package com.cenfotec.sucondofeliz.controller;


import com.cenfotec.sucondofeliz.domain.Condominio;
import com.cenfotec.sucondofeliz.services.CondominioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/condominios"})
public class CondominioController {

    @Autowired
    private CondominioService condoService;

    @GetMapping
    public List getAll(){
        return condoService.getAll();
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Condominio> findById(@PathVariable long id){
        Optional<Condominio> result = condoService.findById(id);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(path = "/activos")
    public List getCondominiosActivos(){
        List<Condominio> listaCompleta = condoService.getAll();
        List<Condominio> listaConActivos = new ArrayList<>();
         for(int i = 0; i < listaCompleta.size();i++){

            if(listaCompleta.get(i).getEstado().equals("Activo")){
                listaConActivos.add(listaCompleta.get(i));
            }

         }
        return listaConActivos;
    }

    @GetMapping(path = "/inactivos")
    public List getCondominiosInactivos(){
        List<Condominio> listaCompleta = condoService.getAll();
        List<Condominio> listaConActivos = new ArrayList<>();
        for(int i = 0; i < listaCompleta.size();i++){
            if(listaCompleta.get(i).getEstado().equals("Inactivo")){
                listaConActivos.add(listaCompleta.get(i));
            }
        }
        return listaConActivos;
    }


    @PostMapping
    public Condominio create(@RequestBody Condominio condo){
        condo.setEstado("Activo");
        return condoService.save(condo).get();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Condominio> update(@PathVariable("id") long id, @RequestBody Condominio condo){
        condo.setId(id);
        Optional<Condominio> result = condoService.update(condo);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value="/estado/{id}")
    public ResponseEntity<Condominio> cambiarEstado(@PathVariable("id") long id){
        Condominio condo = new Condominio();
        condo.setId(id);
        Optional<Condominio> result = condoService.cambiarEstado(condo);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        if (condoService.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
