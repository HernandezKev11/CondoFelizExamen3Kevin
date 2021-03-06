package com.cenfotec.sucondofeliz.controller;


import com.cenfotec.sucondofeliz.domain.Amenidad;
import com.cenfotec.sucondofeliz.domain.Condominio;
import com.cenfotec.sucondofeliz.services.AmenidadService;
import com.cenfotec.sucondofeliz.services.CondominioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/amenidades"})
public class AmenidadController {

    @Autowired
    private AmenidadService ameService;

    @Autowired
    private CondominioService condoService;


    @GetMapping(value = "/{id}")
    public List getAmenidadesById(@PathVariable long id){
        Condominio condo = new Condominio();
        condo.setId(id);
        List<Amenidad> listaAmenidades = ameService.getAll(id);
        return listaAmenidades;
    }

    @PostMapping(value = "/{id}")
    public Amenidad create(@PathVariable long id,@RequestBody Amenidad amenidad){
        amenidad.setIdCondominio(id);
        Optional<Condominio> result = condoService.findById(id);
        if(result.isPresent()){
            if(result.get().getEstado().equals("Activo")){
                return ameService.save(amenidad).get();
            }
        }
        Amenidad ame = new Amenidad();
        ame.setTipoAmenidad("El condominio esta desactivado");
        return ame;
    }
}
