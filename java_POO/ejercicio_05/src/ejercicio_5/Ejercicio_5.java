package ejercicio_5;

import entities.Cuenta;
import services.CuentaServicio;

public class Ejercicio_5 {

    public static void main(String[] args) {

        CuentaServicio cuentaServicio = new CuentaServicio();

        Cuenta cuenta1 = cuentaServicio.crearCuenta();

        System.out.println("Datos de la cuenta 1:");
        System.out.println(cuenta1.toString());

        cuentaServicio.ingresar(cuenta1, 500.0);
        cuentaServicio.retirar(cuenta1, 200.0);
        cuentaServicio.extraccionRapida(cuenta1, 1000.0);

        System.out.println("Datos actualizados de la cuenta 1:");
        System.out.println(cuenta1.toString());

        Cuenta cuenta2 = cuentaServicio.crearCuenta();
        System.out.println("Datos de la cuenta 2:");
        System.out.println(cuenta2.toString());

        cuentaServicio.ingresar(cuenta2, 1000.0);
        cuentaServicio.retirar(cuenta2, 500.0);
        cuentaServicio.extraccionRapida(cuenta2, 200.0);

        System.out.println("Datos actualizados de la cuenta 2:");
        System.out.println(cuenta2.toString());

    }

}
