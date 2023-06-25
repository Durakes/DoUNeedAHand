package com.example.myapplication.entidades;

public class Tarjeta {

    private String tarjeta;
    private String descripcion;
    private int tarjetaid;

    public Tarjeta(){

    }

    public Tarjeta(String tarjeta, String descripcion, int tarjetaid) {
        this.tarjeta = tarjeta;
        this.descripcion = descripcion;
        this.tarjetaid = tarjetaid;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTarjetaid() {
        return tarjetaid;
    }

    public void setTarjetaid(int tarjetaid) {
        this.tarjetaid = tarjetaid;
    }
}

