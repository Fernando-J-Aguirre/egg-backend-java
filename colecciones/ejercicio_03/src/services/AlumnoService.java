package services;

import java.util.ArrayList;
import entities.Alumno;
import java.util.Scanner;

public class AlumnoService {

    private Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    private ArrayList<Alumno> alumnos = new ArrayList();

    public void crearAlumnos() {
        String resp;
        do {
            Alumno alumno = new Alumno();
            ArrayList<Integer> notas = new ArrayList<>();
            System.out.println("Ingrese el nombre del alumno");
            alumno.setNombre(scanner.next());

            System.out.println("Ingrese sus 3 notas");
            notas.add(scanner.nextInt());
            notas.add(scanner.nextInt());
            notas.add(scanner.nextInt());

            alumno.setNotas(notas);
            alumnos.add(alumno);

            System.out.println("Desea agregar más alumnos? S/N");
            resp = scanner.next();
        } while (resp.equalsIgnoreCase("s"));
    }

    public double notaFinal(String nombre) {
        double promedio = 0;
        for (Alumno alumno : alumnos) {
            if (alumno.getNombre().equals(nombre)) {
                for (int i = 0; i < alumno.getNotas().size(); i++) {
                    promedio += alumno.getNotas().get(i);
                }
            }
        }
        return promedio / 3;
    }

}
