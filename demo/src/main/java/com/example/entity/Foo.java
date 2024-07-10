package com.example.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="foo")
public class Foo {
    
    @Id
    public Integer id;
    public String name;
    public String dni;

    


}
