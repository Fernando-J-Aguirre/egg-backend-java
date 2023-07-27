package ejercicio_7;

import services.PersonaServicio;

public class Ejercicio_7 {

    public static void main(String[] args) {

        PersonaServicio[] personas = new PersonaServicio[4];
        int pesoIdeal = 0;
        int bajoPeso = 0;
        int sobrePeso = 0;
        int mayorDeEdad = 0;
        int menorDeEdad = 0;

        for (int i = 0; i < 4; i++) {
            System.out.println("Ingrese los datos para la persona n° " + (i + 1));
            personas[i] = new PersonaServicio();
            personas[i].crearPersona();
            int peso = personas[i].calcularIMC();
            boolean edad = personas[i].esMayorDeEdad();

            switch (peso) {
                case -1:
                    System.out.println(personas[i].mostrar() + " - está por debajo de su peso ideal");
                    bajoPeso++;
                    break;
                case 0:
                    System.out.println(personas[i].mostrar() + " - está en su peso ideal");
                    pesoIdeal++;
                    break;
                case 1:
                    System.out.println(personas[i].mostrar() + " - tiene sobrepeso");
                    sobrePeso++;
                    break;
            }

            if (edad) {
                mayorDeEdad++;
            } else {
                menorDeEdad++;
            }
        }

        System.out.println("Porcentaje de personas en peso ideal: " + (int) (((double) pesoIdeal / 4) * 100) + "%");
        System.out.println("Porcentaje de personas por debajo de su peso ideal: " + (int) (((double) bajoPeso / 4) * 100) + "%");
        System.out.println("Porcentaje de personas con sobrepeso: " + (int) (((double) sobrePeso / 4) * 100) + "%");
        System.out.println("Porcentaje de personas mayores de edad: " + (int) (((double) mayorDeEdad / 4) * 100) + "%");
        System.out.println("Porcentaje de personas menores de edad: " + (int) (((double) menorDeEdad / 4) * 100) + "%");

    }

}
