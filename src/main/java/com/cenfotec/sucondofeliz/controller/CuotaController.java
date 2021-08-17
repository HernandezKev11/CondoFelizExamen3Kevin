package com.cenfotec.sucondofeliz.controller;


import com.cenfotec.sucondofeliz.domain.Amenidad;
import com.cenfotec.sucondofeliz.domain.Condominio;
import com.cenfotec.sucondofeliz.domain.Cuota;
import com.cenfotec.sucondofeliz.services.CondominioService;
import com.cenfotec.sucondofeliz.services.CuotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/cuotas"})
public class CuotaController {



    @Autowired
    private CuotaService cuotaService;

    @GetMapping(value="/{id}")
    public List<Cuota> findById(@PathVariable long id){
        Condominio condo = new Condominio();
        condo.setId(id);
        List<Cuota> listaCuotas = cuotaService.getCuotasCondominios(id);
        return listaCuotas;
    }
}
