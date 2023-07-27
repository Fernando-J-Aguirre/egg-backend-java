package services;

import entities.Curso;
import java.util.Scanner;

public class CursoService {

    Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    Curso curso = new Curso();

    public void cargarAlumnos() {
        System.out.println("Ingrese cantidad de alumnos (máximo 5): ");
        int cantidadAlumnos = scanner.nextInt();
        if (cantidadAlumnos > 5) {
            cantidadAlumnos = 5;
        }
        String[] alumnos = curso.getAlumnos();
        for (int i = 0; i < cantidadAlumnos; i++) {
            System.out.println("Ingrese nombre del alumno " + (i + 1));
            String nombre = scanner.next();
            alumnos[i] = nombre;
        }
        curso.setAlumnos(alumnos);
    }

    public Curso crearCurso() {
        System.out.println("Ingrese nombre del curso");
        curso.setNombreCurso(scanner.next());
        System.out.println("Ingrese cantidad de horas por día");
        curso.setCantidadHorasPorDia(scanner.nextDouble());
        System.out.println("Ingrese cantidad de días por semana");
        curso.setCantidadDiasPorSemana(scanner.nextInt());
        System.out.println("Ingrese turno (mañana o tarde)");
        curso.setTurno(scanner.next());
        System.out.println("Ingrese precio por hora");
        curso.setPrecioPorHora(scanner.nextDouble());
        cargarAlumnos();
        return curso;
    }

    public void calcularGananciaSemanal() {
        double ganancia = (curso.getCantidadHorasPorDia() * curso.getPrecioPorHora() * curso.getAlumnos().length) * curso.getCantidadDiasPorSemana();
        System.out.println("Ganancia semanal para el curso: " + curso.getNombreCurso() + " es de $" + ganancia);
    }
    
    

}
