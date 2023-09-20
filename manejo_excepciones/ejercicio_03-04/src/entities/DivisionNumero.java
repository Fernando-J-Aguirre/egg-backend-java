package entities;

public class DivisionNumero {

    private int num1;
    private int num2;

    public DivisionNumero() {
    }

    public void dividir(int n1, int n2) {
        int resultado;
        try {
            resultado = (n1 / n2);
            System.out.println("El resultado es: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("EXCEPCIÓN : " + e);
            System.out.println("EXCEPCIÓN - message : " + e.getMessage());
        }
    }

}
