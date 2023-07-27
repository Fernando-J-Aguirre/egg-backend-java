//Realizar un programa en Java donde se creen dos arreglos: el primero será un arreglo A
//de 50 números reales, y el segundo B, un arreglo de 20 números, también reales. El
//programa deberá inicializar el arreglo A con números aleatorios y mostrarlo por pantalla.
//Luego, el arreglo A se debe ordenar de menor a mayor y copiar los primeros 10 números
//ordenados al arreglo B de 20 elementos, y rellenar los 10 últimos elementos con el valor
//0.5. Mostrar los dos arreglos resultantes: el ordenado de 50 elementos y el combinado de 20.
package services;

import entities.Arreglo;
import java.util.Arrays;

public class ArregloServicio {

    Arreglo a = new Arreglo(50);
    Arreglo b = new Arreglo(20);

    public void rellenarArreglo() {
        double[] array = new double[50];
        for (int i = 0; i < 50; i++) {
            array[i] = Math.floor((Math.random() * 10) * 100) / 100;
        }

        a.setArray(array);
        System.out.println("Arreglo A desordenado");
        System.out.println(Arrays.toString(a.getArray()));
        System.out.println();
    }

    public void rellenarArrayB() {
        double[] array = new double[20];
        Arrays.sort(a.getArray());
        System.arraycopy(a.getArray(), 0, array, 0, 10);
        Arrays.fill(array, 10, 20, 0.5);
        b.setArray(array);
    }

    public void mostrarArrays() {
        System.out.println("Arreglo A ordenado");
        System.out.println(Arrays.toString(a.getArray()));
        System.out.println();
        System.out.println("Arreglo B");
        System.out.println(Arrays.toString(b.getArray()));
    }
}
