package com.cenfotec.sucondofeliz.repositories;

import com.cenfotec.sucondofeliz.domain.Amenidad;
import com.cenfotec.sucondofeliz.domain.Condominio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AmenidadRepository extends JpaRepository<Amenidad, Long> {
}
