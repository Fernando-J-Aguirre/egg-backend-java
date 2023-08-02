/*
Almacena en un HashMap los códigos postales de 10 ciudades a elección de esta
página: https://mapanet.eu/index.htm. Nota: Poner el código postal sin la letra, solo el
número.
• Pedirle al usuario que ingrese 10 códigos postales y sus ciudades.
• Muestra por pantalla los datos introducidos
• Pide un código postal y muestra la ciudad asociada si existe sino avisa al usuario.
• Muestra por pantalla los datos
• Agregar una ciudad con su código postal correspondiente más al HashMap.
• Elimina 3 ciudades existentes dentro del HashMap, que pida el usuario.
• Muestra por pantalla los datos
 */
package servicios;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SerCodigoPostal {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    HashMap<Integer, String> codigos = new HashMap();

    private void cargar() {
        System.out.println("INGRESE EL CODIGO DE LA CIUDAD");
        Integer c = leer.nextInt();
        if (codigos.containsKey(c)) {
            System.out.println("ESA CIUDAD YA ESTA CARGADA");
        } else {
            System.out.println("INGRESE EL NOMBRE DE LA CIUDAD");
            String n = leer.next();
            codigos.put(c, n);
        }
    }

    private void mostrar() {
        if (!codigos.isEmpty()) {
            for (Map.Entry<Integer, String> entry : codigos.entrySet()) {
                Integer key = entry.getKey();
                String value = entry.getValue();
                System.out.println("NOMBRE:: " + value + " // CODIGO POSTAL:: " + key);
            }
        } else {
            System.out.println("No se encuentran ciudades registradas");
        }
    }

    private void buscar() {
        System.out.println("INGRESE EL CODIGO DE LA CIUDAD A BUSCAR");
        String get = codigos.get(leer.nextInt());
        System.out.println(get);
        if (get == null) {
            System.out.println("NO EXISTE LA CIUDAD");
        } else {
            System.out.println("CIUDAD:: " + get);
        }
    }

    private void eliminarCiudad() {
        System.out.println("INGRESE LA CIUDAD A ELIMINAR");
        Integer codigo = leer.nextInt();
        String result = codigos.remove(codigo);
        if (result != null) {
            System.out.println("Ciudad eliminada exitosamente");
        } else {
            System.out.println("La ciudad no está registrada");
        }
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("MENU");
            System.out.println();
            System.out.println("1. Cargar ciudad");
            System.out.println("2. Mostrar ciudades");
            System.out.println("3. Eliminar ciudad");
            System.out.println("4. Buscar ciudad");
            System.out.println("5. Salir");
            opcion = leer.nextInt();
            enviarSolicitud(opcion);
        } while (opcion != 5);
    }

    private void enviarSolicitud(int opcion) {
        switch (opcion) {
            case 1:
                cargar();
                break;
            case 2:
                mostrar();
                break;
            case 3:
                eliminarCiudad();
                break;
            case 4:
                buscar();
                break;
            default:
                System.out.println("Programa finalizado");
        }
    }

}
