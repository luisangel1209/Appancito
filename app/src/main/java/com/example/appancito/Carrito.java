package com.example.appancito;

public class Carrito {
    public String idcompra;
    public int bolillos;
    public int conchas;
    public int cuernos;
    public int orejas;
    public String dineroTotal;
    public String fecha;
    public String hora;
    public String nombre;

    public Carrito(String idcompra, int bolillos, int conchas, int cuernos, int orejas, String dineroTotal, String fecha, String hora, String nombre) {
        this.idcompra = idcompra;
        this.bolillos = bolillos;
        this.conchas = conchas;
        this.cuernos = cuernos;
        this.orejas = orejas;
        this.dineroTotal = dineroTotal;
        this.fecha = fecha;
        this.hora = hora;
        this.nombre = nombre;
    }

    public String getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(String idcompra) {
        this.idcompra = idcompra;
    }

    public int getBolillos() {
        return bolillos;
    }

    public void setBolillos(int bolillos) {
        this.bolillos = bolillos;
    }

    public int getConchas() {
        return conchas;
    }

    public void setConchas(int conchas) {
        this.conchas = conchas;
    }

    public int getCuernos() {
        return cuernos;
    }

    public void setCuernos(int cuernos) {
        this.cuernos = cuernos;
    }

    public int getOrejas() {
        return orejas;
    }

    public void setOrejas(int orejas) {
        this.orejas = orejas;
    }

    public String getDineroTotal() {
        return dineroTotal;
    }

    public void setDineroTotal(String dineroTotal) {
        this.dineroTotal = dineroTotal;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
