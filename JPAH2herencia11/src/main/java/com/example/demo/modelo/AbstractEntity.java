package com.example.demo.modelo;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

//@Entity
//se mapea en tabla independiente
//Se indica que no se mapea en tabla, sino que se realiza en la tabla de la clases hija
//Esto se prueba con la bbdd herencia12
@MappedSuperclass
public abstract class AbstractEntity extends AbstractRootEntity {

    private String description;

    public AbstractEntity() {
    }

    public AbstractEntity(String nick, String description) {
        super(nick);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }


}
