package com.cenfotec.sucondofeliz.services;


import com.cenfotec.sucondofeliz.domain.Cuota;
import com.cenfotec.sucondofeliz.repositories.CuotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CuotaServiceImpl implements CuotaService {

    @Autowired
    CuotaRepository cuotaRepository;

    @Override
    public List<Cuota> getCuotasCondominios(Long idCondominio) {
        List<Cuota> listaTotal = cuotaRepository.findAll();
        List<Cuota> listaOficial = new ArrayList<>();
        for(int i =0; i < listaTotal.size();i++){
            if(listaTotal.get(i).getIdCondominio() == idCondominio){
                listaOficial.add(listaTotal.get(i));
            }
        }

        return listaOficial;
    }
}
