package com.cenfotec.sucondofeliz.services;

import com.cenfotec.sucondofeliz.domain.Condominio;

import java.util.List;
import java.util.Optional;

public interface CondominioService {

    public List<Condominio> getAll();
    public Optional<Condominio> findById(long id);
    public  Optional<Condominio> save(Condominio condo);
    public  Optional<Condominio> update(Condominio condo);
    public Optional<Condominio> cambiarEstado(Condominio condo);
    public boolean delete(Long id);
}
