package com.example.demo.modelo;

import javax.persistence.Entity;

@Entity
public class ConcreteEntity extends AbstractEntity {

    private String name;

    public ConcreteEntity() {
    }

    public ConcreteEntity(String nick, String description, String name) {
        super(nick, description);
        this.name = name;
    }

    public String getName() {
        return name;
    }

	@Override
	public String toString() {
		return "ConcreteEntity [name=" + name + "]"+ getDescription()+":"+getNick()+":"+getId();
	}

    
}
