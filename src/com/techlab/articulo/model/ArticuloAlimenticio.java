package com.techlab.articulo.model;

public class ArticuloAlimenticio extends Articulo {

    private int diasParaVencimiento;

    //constructor
    public ArticuloAlimenticio(int codigo, String nombre, double precio, Categoria categoria, int diasParaVencimiento) {
        super(codigo, nombre, precio, categoria);
        this.diasParaVencimiento = diasParaVencimiento;
    }

    //getter y setter
    public int getDiasParaVencimiento() {
        return diasParaVencimiento;
    }

    public void setDiasParaVencimiento(int diasParaVencimiento) {
        this.diasParaVencimiento = diasParaVencimiento;
    }

    //Se sobreescribe el método getDetalleEspecifico para devolver los días para vencimiento
    @Override
    public String getDetalleEspecifico() {
        return "Días para vencimiento: " + diasParaVencimiento;
    }

    //Se sobreescribe el método getTipoArticulo para devolver "Alimenticio"
    @Override
    public String getTipoArticulo() {
        return "Alimenticio";
    }

    //ToString
    @Override
    public String toString() {
        return super.toString() + " [subtipo alimenticio]";
    }

}
