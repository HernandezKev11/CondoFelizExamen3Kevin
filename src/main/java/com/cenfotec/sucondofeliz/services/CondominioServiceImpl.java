package com.cenfotec.sucondofeliz.services;


import com.cenfotec.sucondofeliz.domain.Condominio;
import com.cenfotec.sucondofeliz.domain.Cuota;
import com.cenfotec.sucondofeliz.repositories.CondominioRepository;
import com.cenfotec.sucondofeliz.repositories.CuotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CondominioServiceImpl implements CondominioService{

    @Autowired
    CondominioRepository condoRepository;

    @Autowired
    CuotaRepository cuotaRepository;

    @Override
    public List<Condominio> getAll() {
        return condoRepository.findAll();
    }

    @Override
    public Optional<Condominio> findById(long id) {
        return condoRepository.findById(id).map(record -> Optional.of(record)).orElse(Optional.empty());
    }

    @Override
    public  Optional<Condominio> save(Condominio condo) {
        Optional<Condominio> nuevoCondominio = Optional.of(condoRepository.save(condo));
        Cuota cuoNue = new Cuota();
        cuoNue.setCuotaCondominial(nuevoCondominio.get().getCuotaCondominial());
        cuoNue.setIdCondominio(nuevoCondominio.get().getId());
        cuotaRepository.save(cuoNue);
        return nuevoCondominio;
    }

    @Override
    public  Optional<Condominio> update(Condominio condo) {
        Optional<Condominio> record = condoRepository.findById(condo.getId());
        if (record.isPresent()) {
            if(record.get().getEstado().equals("Activo")){
                Condominio data = record.get();
                if(data.getCuotaCondominial().equals( condo.getCuotaCondominial())){

                }else{
                    data.setCuotaCondominial(condo.getCuotaCondominial());
                    Cuota cuotaNueva = new Cuota();
                    cuotaNueva.setCuotaCondominial(condo.getCuotaCondominial());
                    cuotaNueva.setIdCondominio(condo.getId());
                    cuotaRepository.save(cuotaNueva);
                }
                data.setNombre(condo.getNombre());
                data.setCantidadUnidades(condo.getCantidadUnidades());
                data.setCedulaJuridica(condo.getCedulaJuridica());
                data.setDireccion(condo.getDireccion());
                data.setDuenno(condo.getDuenno());

                return Optional.of(condoRepository.save(data));
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Condominio> cambiarEstado(Condominio condo) {

        Optional<Condominio> record = condoRepository.findById(condo.getId());

        if (record.isPresent()) {
            Condominio data = record.get();
            if(record.get().getEstado().equals("EX-Condominio")){
                return Optional.empty();
            }else{
                if(record.get().getEstado().equals("Activo")){
                    data.setEstado("Inactivo");
                }else{
                    data.setEstado("Activo");
                }

                return Optional.of(condoRepository.save(data));
            }


        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        Optional<Condominio> result = condoRepository.findById(id);
        if (result.isPresent()){
            result.get().setEstado("EX-Condominio");
            condoRepository.save(result.get());
            return true;
        }
        return false;
    }
}
