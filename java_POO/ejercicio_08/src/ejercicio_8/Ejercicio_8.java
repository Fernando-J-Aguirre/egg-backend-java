package ejercicio_8;

import services.CadenaServicio;

public class Ejercicio_8 {

    public static void main(String[] args) {
        CadenaServicio frase = new CadenaServicio();

        frase.ingresarFrase();

        System.out.println(frase.mostrar());
        System.out.println();
        System.out.println("Frase invertida");
        System.out.println(frase.invertirFrase());
        System.out.println();
        frase.compararLongitud("hola todo bien?");
        System.out.println();
        int vocales = frase.contarVocales();
        System.out.println("La frase contiene " + vocales + " letras que son vocales");
        System.out.println();
        boolean contiene = frase.contiene("s");
        System.out.println(contiene);
        System.out.println();
        System.out.println("Reemplazar");
        frase.reemplazar('g');
        System.out.println();
        System.out.println("Veces repetido");
        frase.vecesRepetido('d');
        System.out.println();
        System.out.println("Unir frases");
        System.out.println(frase.unirFrases(", todo bien, estudiando"));
    }

}
