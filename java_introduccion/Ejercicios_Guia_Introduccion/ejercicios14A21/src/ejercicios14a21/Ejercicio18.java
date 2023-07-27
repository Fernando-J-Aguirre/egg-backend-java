package ejercicios14a21;


public class Ejercicio18 {

    /*Realizar un programa que rellene un matriz de 4 x 4 de valores aleatorios y muestre la
traspuesta de la matriz. La matriz traspuesta de una matriz A se denota por B y se obtiene
cambiando sus filas por columnas (o viceversa).*/
    public static void main(String[] args) {

        int[][] matriz = new int[4][4];
        rellenarMatriz(matriz);
        mostrarMatriz(matriz);
        System.out.println("Traspuesta");
        trasponerMatriz(matriz);
        mostrarMatriz(matriz);
    }

    public static void rellenarMatriz(int[][] matriz) {

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = (int) (Math.random() * 10);
            }
        }
    }

    public static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
//                System.out.println("[" + i + "]" + "[" + j + "] = " + matriz[i][j]);
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void trasponerMatriz(int[][] matriz) {
        int[][] matrizAux = new int[matriz.length][matriz.length];
        
        for (int j = 0; j < matriz.length; j++) {
            for (int i = 0; i < matriz[j].length; i++) {
                matrizAux[j][i] = matriz[i][j];
            }
        }
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = matrizAux[i][j];
            }
        }
    }

}
