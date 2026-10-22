package com.uem.model;

import java.util.ArrayList;
import java.util.List;
import com.uem.Calculator;

public class Order {
    
    private String idPedido;
    private List<Article> articulos;

    // Creamos una clase vacía para poder añadir los datos de JSON
    public Order() {

    }

    public Order(String idPedido, List<Article> articulos) {
        this.idPedido = idPedido;
        this.articulos = articulos;
    }

    public String getIdPedido() {
        return idPedido;
    }
    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public List<Article> getArticulos(){
        return articulos;
    }
    public void setArticulos(List<Article> articulos){
        this.articulos = articulos;
    }

    public double getGrossTotal() {
        List<Double> listaTotal = new ArrayList<>();
        
        for (Article articulo : articulos) {
            listaTotal.add(articulo.getGrossAmount());
        }

        Calculator calculadora = new Calculator();
        return calculadora.calculateTotal(listaTotal);
    }
    
    public double getDiscountedTotal() {
        List<Double> listaDescuento = new ArrayList<>();

        for (Article articulo : articulos) {
            listaDescuento.add(articulo.getDiscountedAmount());
        }
        Calculator calculadora = new Calculator();
        return calculadora.calculateTotal(listaDescuento);
    }

    @Override
    public String toString() {
        return "Order [idPedido=" + idPedido + ", articulos=" + articulos + "]";
    }
}