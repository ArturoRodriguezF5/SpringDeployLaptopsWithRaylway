package com.arthycode.RestAPILaptos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Laptop {

    // Atributos encapsulados
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private Boolean touch;

    // Constructores

    public Laptop() {
    }
    public Laptop(Long id, String marca, String modelo, Boolean touch) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.touch = touch;
    }

    // Setters and getters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Boolean getTouch() {
        return touch;
    }

    public void setTouch(Boolean touch) {
        this.touch = touch;
    }

    // Métodos

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", touch=" + touch +
                '}';
    }
}
