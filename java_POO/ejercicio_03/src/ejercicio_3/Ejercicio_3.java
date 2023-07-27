
package ejercicio_3;

import entities.Operacion;
import services.OperacionService;

public class Ejercicio_3 {

    public static void main(String[] args) {
        
        OperacionService os = new OperacionService();
        Operacion op = os.crearOperacion();
        System.out.println(op.toString());
        int suma = os.sumar(op);
        System.out.println("Suma = " + suma);
        int resta = os.restar(op);
        System.out.println("Resta = " + resta);
        int multi = os.multiplicar(op);
        System.out.println("Multiplicación = " + multi);
        int div = os.dividir(op);
        System.out.println("División = " + div);
    }

}
