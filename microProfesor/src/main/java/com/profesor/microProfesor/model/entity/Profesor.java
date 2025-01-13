package com.profesor.microProfesor.model.entity;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotEmpty; 

@Entity
@Table(name = "profesores")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private Integer version=0;
    @NotEmpty(message = "El nombre no puede estar vacio")
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private int sueldo; 
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_contratacion",nullable = false,updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date fechaContratacion;
    @PrePersist
    protected  void onCreate(){
        this.fechaContratacion = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getSueldo() {
        return sueldo;
    }
    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }
    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }



    
}
