package com.techlab.articulo.model;

public abstract class Articulo extends Object {
    private int codigo;
    private String nombre;
    private double precio;
    private Categoria categoria;

    //constructor

    public Articulo(int codigo, String nombre, double precio, Categoria categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    //getters

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    //setters

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    //Devolver tipo de articulo
    public abstract String getTipoArticulo();

    //Devolver detalle del articulo
    public abstract String getDetalleEspecifico();

    //toString
    @Override
    public String toString() {
        return "Articulo{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", categoria=" + categoria.getNombre() +
                ", tipo de articulo=" + getTipoArticulo() +
                ", detalle especifico=" + getDetalleEspecifico() +
                '}';
    }

}
