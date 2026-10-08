package com.techlab.articulo.model;

public class ArticuloElectronico extends Articulo {

    private int garantiaMeses;

    //constructor
    public ArticuloElectronico(int codigo, String nombre, double precio, Categoria categoria, int garantiaMeses) {
        super(codigo, nombre, precio, categoria);
        this.garantiaMeses = garantiaMeses;
    }

    //getter y setter
    public int getGarantiaMeses() {
        return garantiaMeses;
    }

    public void setGarantiaMeses(int garantiaMeses) {
        this.garantiaMeses = garantiaMeses;
    }

    //Se sobreescribe el método getDetalleEspecifico para devolver la garantía en meses
    @Override
    public String getDetalleEspecifico() {
        return "Garantía: " + garantiaMeses + " meses";
    }

    //Se sobreescribe el método getTipoArticulo para devolver "Electrónico"
    @Override
    public String getTipoArticulo() {
        return "Electrónico";
    }

    //metodo que devuelve el numero para reclamos
    public String nroTelMesaDeAyudaParaReclamos(){
        return "0800-123-4567";
    }

    //ToString
    @Override
    public String toString() {
        return super.toString() + " [subtipo electrónico]";
    }

}