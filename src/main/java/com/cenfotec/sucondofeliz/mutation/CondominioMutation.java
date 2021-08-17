package com.cenfotec.sucondofeliz.mutation;


import com.cenfotec.sucondofeliz.domain.Condominio;
import com.cenfotec.sucondofeliz.services.CondominioService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CondominioMutation implements GraphQLMutationResolver {

    @Autowired
    private CondominioService condoService;

    public Condominio createCondo(String nombre, String cedulaJuridica, String direccion, String duenno, String cantidadUnidades, String cuotaCondominial) {
        Condominio condo = new Condominio(nombre,cedulaJuridica,direccion,duenno,cantidadUnidades,cuotaCondominial);
        return this.condoService.save(condo).get();
    }

    public Condominio updateCondo(Long id,String nombre, String cedulaJuridica, String direccion, String duenno, String cantidadUnidades, String cuotaCondominial){
        Condominio condo = new Condominio(nombre,cedulaJuridica,direccion,duenno,cantidadUnidades,cuotaCondominial);
        condo.setId(id);
        return this.condoService.update(condo).get();
    }

    public Condominio deleteCondo(Long id){
        this.condoService.delete(id);
        Condominio condo = condoService.findById(id).get();
        return condo;
    }
}
