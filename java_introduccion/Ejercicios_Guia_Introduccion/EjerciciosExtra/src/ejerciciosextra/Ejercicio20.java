package ejerciciosextra;

/*Crear una función rellene un vector con números aleatorios, pasándole un arreglo por
parámetro. Después haremos otra función o procedimiento que imprima el vector.*/
public class Ejercicio20 {

    public static void main(String[] args) {
        int[] vector = new int[10];
        rellenarRandom(vector);
        mostrarVector(vector); 
        System.out.println("");
    }

    public static void rellenarRandom(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int) (Math.random() * 10);
        }
    }

    public static void mostrarVector(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + " ");
        }
    }
}
