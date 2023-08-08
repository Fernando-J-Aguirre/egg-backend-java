package services;

import entities.Usuario;
import java.util.Scanner;

public class UsuarioService {

    private Scanner sc = new Scanner(System.in).useDelimiter("\n");
    
    public Usuario crearUsuario() {
        System.out.println("Ingrese el nombre del usuario");
        String nombre = sc.next();
        System.out.println("Usuario registrado exitosamente"); 
        return new Usuario(nombre);
    }
    
    
}
