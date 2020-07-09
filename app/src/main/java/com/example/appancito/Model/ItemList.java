package com.example.appancito.Model;

import java.io.Serializable;

public class ItemList implements Serializable {
    private String titulo;
    private String descripcion;
    private String disponible;
    private int imgResource;

    public ItemList(String titulo, String descripcion, String disponible, int imgResource) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.disponible = disponible;
        this.imgResource = imgResource;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDisponible() {
        return disponible;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }

    public int getImgResource() {
        return imgResource;
    }

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }
}