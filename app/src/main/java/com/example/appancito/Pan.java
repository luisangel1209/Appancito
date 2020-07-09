package com.example.appancito;

public class Pan {
    String nombre;
    String descripcion;
    int piezas;
    int precio;

    public Pan(String nombre, String descripcion, int piezas, int precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.piezas = piezas;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPiezas() {
        return piezas;
    }

    public void setPiezas(int piezas) {
        this.piezas = piezas;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
