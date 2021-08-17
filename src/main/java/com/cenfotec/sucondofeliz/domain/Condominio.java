package com.cenfotec.sucondofeliz.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Condominio {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private static final long serialVersionUID = 1L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    private String nombre;

    private String cedulaJuridica;

    private String direccion;

    private String duenno;

    private String cantidadUnidades;

    private String cuotaCondominial;

    private String estado;

    public Condominio(){

    }

    public Condominio(String nombre, String cedulaJuridica, String direccion, String duenno, String cantidadUnidades, String cuotaCondominial) {
        this.nombre = nombre;
        this.cedulaJuridica = cedulaJuridica;
        this.direccion = direccion;
        this.duenno = duenno;
        this.cantidadUnidades = cantidadUnidades;
        this.cuotaCondominial = cuotaCondominial;
        this.estado = "Activo";
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedulaJuridica() {
        return cedulaJuridica;
    }

    public void setCedulaJuridica(String cedulaJuridica) {
        this.cedulaJuridica = cedulaJuridica;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDuenno() {
        return duenno;
    }

    public void setDuenno(String duenno) {
        this.duenno = duenno;
    }

    public String getCantidadUnidades() {
        return cantidadUnidades;
    }

    public void setCantidadUnidades(String cantidadUnidades) {
        this.cantidadUnidades = cantidadUnidades;
    }

    public String getCuotaCondominial() {
        return cuotaCondominial;
    }

    public void setCuotaCondominial(String cuotaCondominial) {
        this.cuotaCondominial = cuotaCondominial;
    }
}
