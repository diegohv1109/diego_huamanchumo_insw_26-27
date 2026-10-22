package com.uem.model;

import com.uem.Calculator;

public class Article {
    
    // Declaracion de atributos
    private String nombre;
    private int cantidad;
    private double precio;
    private double descuento;

    // Creamos una clase vacía para poder añadir los datos de JSON
    public Article() {

    }
    
    // Constructor
    public Article(String nombre, int cantidad, double precio, double descuento) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }
    public String setNombre(String nombre) {
        return this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }
    public int setCantidad(int cantidad) {
        return this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getDescuento() {
        return descuento;
    }
    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    // Creacion metodo getGrossAmount()
    public double getGrossAmount() {
        Calculator calculadora = new Calculator();
        return calculadora.multiply(cantidad, precio);
    }

    // Creacion metodo getDiscountedAmount()
    public double getDiscountedAmount() {
        Calculator calculadora = new Calculator();
        return calculadora.discount(getGrossAmount(), descuento);
    }

}