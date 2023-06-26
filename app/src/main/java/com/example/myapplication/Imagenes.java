package com.example.myapplication;

public class Imagenes {


    public Imagenes(){

    }

    public Imagenes(String titulo, String fecha, String hora, int imagen) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.hora = hora;
        this.imagen = imagen;
    }

    private String titulo,fecha,hora;
    private int imagen;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
