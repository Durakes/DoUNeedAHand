package com.example.myapplication;

public class Direccion {


     private String nombre;
        private String telefono;
        public Direccion(String nombre,String telefono) {
            this.nombre=nombre;
            this.telefono=telefono;
        }

        public String getNombre()
        {
            return nombre;
        }

        public String getTelefono()
        {
            return telefono;
        }
    }

