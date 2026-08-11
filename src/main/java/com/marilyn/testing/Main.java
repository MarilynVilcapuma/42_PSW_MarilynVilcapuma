package com.marilyn.testing;

public class Main {
    public static void main(String[] args) {
        Producto producto = new Producto("Laptop", 2500.0);
        System.out.println("Producto: " + producto.getNombre());
        System.out.println("Precio unitario: " + producto.getPrecio());
        System.out.println("Total por 3 unidades: " + producto.calcularTotal(3));
    }
}
