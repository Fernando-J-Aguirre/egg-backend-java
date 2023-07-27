package ejerciciosextra;

import java.util.Scanner;

/*
21. Los profesores del curso de programación de Egg necesitan llevar un registro de las notas
adquiridas por sus 10 alumnos para luego obtener una cantidad de aprobados y
desaprobados. Durante el periodo de cursado cada alumno obtiene 4 notas, 2 por trabajos
prácticos evaluativos y 2 por parciales. Las ponderaciones de cada nota son:
Primer trabajo práctico evaluativo 10%
Segundo trabajo práctico evaluativo 15%
Primer Integrador 25%
Segundo integrador 50%
Una vez cargadas las notas, se calcula el promedio y se guarda en el arreglo. Al final del
programa los profesores necesitan obtener por pantalla la cantidad de aprobados y
desaprobados, teniendo en cuenta que solo aprueban los alumnos con promedio mayor o
igual al 7 de sus notas del curso.*/
public class Ejercicio21 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] promedios = new double[10];

        int aprobados = 0;
        int desaprobados = 0;

        for (int i = 0; i < 10; i++) {
            System.out.println("Alumno " + (i + 1) + ":");

            double notaTP1 = obtenerNota("Primer trabajo práctico evaluativo: ", 10);
            double notaTP2 = obtenerNota("Segundo trabajo práctico evaluativo: ", 15);
            double notaIntegrador1 = obtenerNota("Primer integrador: ", 25);
            double notaIntegrador2 = obtenerNota("Segundo integrador: ", 50);

            double promedio = calcularPromedio(notaTP1, notaTP2, notaIntegrador1, notaIntegrador2);
            System.out.println(promedio);
            promedios[i] = promedio;

            if (promedio >= 7) {
                aprobados++;
            } else {
                desaprobados++;
            }
        }

        System.out.println("Cantidad de aprobados: " + aprobados);
        System.out.println("Cantidad de desaprobados: " + desaprobados);
    }

    public static double obtenerNota(String mensaje, double ponderacion) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensaje);
        double nota = scanner.nextDouble();
        return nota * ponderacion;
    }

    public static double calcularPromedio(double nota1, double nota2, double nota3, double nota4) {
        return (nota1 + nota2 + nota3 + nota4) / 100;
    }
}


