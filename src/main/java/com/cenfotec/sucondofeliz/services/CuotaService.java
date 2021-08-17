package com.cenfotec.sucondofeliz.services;

import com.cenfotec.sucondofeliz.domain.Condominio;
import com.cenfotec.sucondofeliz.domain.Cuota;

import java.util.List;

public interface CuotaService {

    public List<Cuota> getCuotasCondominios(Long idCondominio);
}
