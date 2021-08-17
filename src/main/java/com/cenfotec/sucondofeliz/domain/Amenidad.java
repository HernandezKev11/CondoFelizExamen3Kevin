package com.cenfotec.sucondofeliz.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Amenidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoAmenidad;

    private Long idCondominio;

    public Amenidad(){

    }

    public Amenidad(Long id, String tipoAmenidad, long idCondominio) {
        this.id = id;
        this.tipoAmenidad = tipoAmenidad;
        this.idCondominio = idCondominio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoAmenidad() {
        return tipoAmenidad;
    }

    public void setTipoAmenidad(String tipoAmenidad) {
        this.tipoAmenidad = tipoAmenidad;
    }

    public Long getIdCondominio() {
        return idCondominio;
    }

    public void setIdCondominio(Long idCondominio) {
        this.idCondominio = idCondominio;
    }
}
