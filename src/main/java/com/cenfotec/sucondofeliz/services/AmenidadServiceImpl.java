package com.cenfotec.sucondofeliz.services;

import com.cenfotec.sucondofeliz.domain.Amenidad;
import com.cenfotec.sucondofeliz.domain.Condominio;
import com.cenfotec.sucondofeliz.repositories.AmenidadRepository;
import com.cenfotec.sucondofeliz.repositories.CondominioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class AmenidadServiceImpl implements AmenidadService{

    @Autowired
    AmenidadRepository ameRepository;

    @Override
    public List<Amenidad> getAll(long idCondominio) {

        List<Amenidad> listaTodos = ameRepository.findAll();
        List<Amenidad> listaOficial = new ArrayList<>();

        for(int i =0;i<listaTodos.size();i++){
            if(listaTodos.get(i).getIdCondominio() == idCondominio){
                listaOficial.add(listaTodos.get(i));
            }
        }

        return listaOficial;
    }

    @Override
    public  Optional<Amenidad> save(Amenidad amenidad) {
        return Optional.of(ameRepository.save(amenidad));
    }



}
