//Pongamos de lado un momento el concepto de POO, ahora vamos a trabajar solo con la
//clase Date. En este ejercicio deberemos instanciar en el main, una fecha usando la clase
//Date, para esto vamos a tener que crear 3 variables, dia, mes y anio que se le pedirán al
//usuario para poner el constructor del objeto Date. Una vez creada la fecha de tipo Date,
//deberemos mostrarla y mostrar cuantos años hay entre esa fecha y la fecha actual, que
//se puede conseguir instanciando un objeto Date con constructor vacío.
//Ejemplo fecha: Date fecha = new Date(anio, mes, dia);
//Ejemplo fecha actual: Date fechaActual = new Date();
package ejercicio_11;

//import java.util.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Ejercicio_11 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese dia, mes y año");
        int dia = scanner.nextInt();
        int mes = scanner.nextInt();
        int anio = scanner.nextInt();

        LocalDate fecha = LocalDate.of(anio, mes, dia);
        LocalDate hoy = LocalDate.now();

        System.out.println("La fecha creada es");
        System.out.println(fecha);
        System.out.println("La fecha actual es");
        System.out.println(hoy);
        System.out.println();
        System.out.println("La diferencia de años es");
        System.out.println(calcularAnios(hoy, fecha) + " años");
        
        System.out.println();
        System.out.println("Utilizando la clase Period y el método Between que incluye el primer valor y excluye el siguiente");
        Period period = Period.between(fecha, hoy);
        System.out.println(period.getYears());
        
        System.out.println();
        System.out.println("Utilizando la clase Period y el método Between para calcular los DIAS");
        Period period2 = Period.between(fecha, hoy);
        System.out.println(period.getDays());
        
    }

    public static int calcularAnios(LocalDate fecha1, LocalDate fecha2) {
        int anio1 = fecha1.getYear();
        int anio2 = fecha2.getYear();
        return anio1 - anio2;
    }

//        System.out.println("Ingrese fecha inicio en formato: yyyy-mm-dd");
//        LocalDate fechaInicio = LocalDate.parse(scanner.nextLine());
//        System.out.println(fechaInicio);
//        System.out.println("Ingrese fecha fin en formato: yyyy-mm-dd");
//        LocalDate fechaFin = LocalDate.parse(scanner.nextLine());
//        System.out.println(fechaFin);
//        System.out.println(fechaInicio.getDayOfMonth());
    
    
    //////////////////////////         UTILIZANDO CLASE DATE          //////////////////////////////////
    
//        Date fecha = new Date(anio - 1900, mes - 1, dia);
//        Date fechaActual = new Date();
//        
//        System.out.println(fecha);
//        System.out.println(fechaActual);
//        System.out.println(fecha.getYear());
//        System.out.println(fechaActual.getYear());
//        System.out.println("Hay " + calcularAnios(fecha, fechaActual));
//    public static int calcularAnios(Date fecha1, Date fecha2) {
//        int anio1 = fecha1.getYear();
//        int anio2 = fecha2.getYear();
//        
//        return anio2 - anio1;
//    }
}
