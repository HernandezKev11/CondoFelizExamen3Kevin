package com.cenfotec.sucondofeliz.repositories;

import com.cenfotec.sucondofeliz.domain.Condominio;
import com.cenfotec.sucondofeliz.domain.Cuota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuotaRepository extends JpaRepository<Cuota, Long> {
}
