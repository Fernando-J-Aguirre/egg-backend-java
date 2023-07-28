package services;

import entities.Producto;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductoService {

    private Scanner sc = new Scanner(System.in).useDelimiter("\n");
    private HashMap<String, Double> productos = new HashMap<>();

    public void agregarProducto() {
        String resp;
        do {
            Producto producto = new Producto();
            System.out.println("Ingrese el nombre del producto");
            String nombre = sc.next();
            producto.setNombre(nombre);
            System.out.println("Ingrese el precio");
            Double precio = sc.nextDouble();
            producto.setPrecio(precio);

            productos.put(nombre, precio);

            System.out.println("Quiere ingresar otro producto) S/N");
            resp = sc.next();
        } while (resp.equalsIgnoreCase("s"));
    }
    
    public void modificarPrecio(String nombre, Double nuevoPrecio) {
        if(productos.containsKey(nombre)) {
            productos.replace(nombre, nuevoPrecio);
            System.out.println("Nuevo precio establecido para el producto: " + nombre);
        } else {
            System.out.println("No se encuentra el producto para modificar el precio");
        }
    }
    
    public void eliminarProducto(String nombre) {
        if (productos.containsKey(nombre)) {
            productos.remove(nombre);
            System.out.println("Producto eliminado");
        } else {
            System.out.println("No se encuentra el producto que quiere eliminar");
        }
    }

    public void mostrarProductos() {
        for(Map.Entry<String, Double> entry: productos.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();
            System.out.println("Producto: " + key + " - " + "Precio = " + value);
        }         
    }
}
