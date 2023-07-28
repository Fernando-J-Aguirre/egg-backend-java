package ejercicio_06;

import services.ProductoService;

public class Ejercicio_06 {

    public static void main(String[] args) {

        ProductoService ps = new ProductoService();

        ps.agregarProducto();
        System.out.println("");
        
        System.out.println("Mostrar Productos");
        ps.mostrarProductos();
        System.out.println("");
        
        System.out.println("Modificar producto");
        ps.modificarPrecio("chocolate", 250.0);
        System.out.println("");
        
        System.out.println("Mostrar Productos");
        ps.mostrarProductos();
        System.out.println("");
        
        System.out.println("Eliminar producto");
        ps.eliminarProducto("aceite");
        System.out.println("");
        
        System.out.println("Mostrar Productos");
        ps.mostrarProductos();

    }

}
