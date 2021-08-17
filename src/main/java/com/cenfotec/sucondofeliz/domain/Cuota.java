package com.cenfotec.sucondofeliz.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cuota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cuotaCondominial;

    private Long idCondominio;

    public Cuota(){

    }

    public Cuota(Long id, String cuotaCondominial, Long idCondominio) {
        this.id = id;
        this.cuotaCondominial = cuotaCondominial;
        this.idCondominio = idCondominio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCuotaCondominial() {
        return cuotaCondominial;
    }

    public void setCuotaCondominial(String cuotaCondominial) {
        this.cuotaCondominial = cuotaCondominial;
    }

    public Long getIdCondominio() {
        return idCondominio;
    }

    public void setIdCondominio(Long idCondominio) {
        this.idCondominio = idCondominio;
    }
}
