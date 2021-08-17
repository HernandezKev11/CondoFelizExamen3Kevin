package com.cenfotec.sucondofeliz.services;

import com.cenfotec.sucondofeliz.domain.Amenidad;
import com.cenfotec.sucondofeliz.domain.Condominio;

import java.util.List;
import java.util.Optional;

public interface AmenidadService {

    public List<Amenidad> getAll(long idCondominio);
    public  Optional<Amenidad> save(Amenidad amenidad);

}
