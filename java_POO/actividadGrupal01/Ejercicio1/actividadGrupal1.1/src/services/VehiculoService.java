package services;

import entities.Vehiculo;
import java.util.Scanner;


public class VehiculoService {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        
        public Vehiculo crearVehiculo(){
            Vehiculo vehi = new Vehiculo();
            
            System.out.println("Ingrese la marca del vehiculo");
            vehi.setMarca(leer.next());
            System.out.println("Ingrese el modelo del vehiculo");
            vehi.setModelo(leer.next());
            System.out.println("Ingrese el anio del vehiculo");
            vehi.setAnio(leer.nextInt());
            System.out.println("Ingrese el tipo de vehiculo");
            vehi.setTipo(leer.next());
            
            return vehi;
        }
        
        public void moverse(Vehiculo vehiculo, int tiempo){
//            Un automóvil avanza 3 metros por segundo.
//            Una motocicleta avanza 2 metros por segundo.
//            Una bicicleta avanza 1 metro por segundo.
            int distancia;
            distancia = 0;

            switch (vehiculo.getTipo()){
                case "automovil":
                    distancia = tiempo * 3; 
                    break;
                case "motocicleta":
                    distancia = tiempo * 2;
                    break;
                case "bicicleta":
                    distancia = tiempo;
                    break;
            }
            
            vehiculo.setMetrosR(vehiculo.getMetrosR() + distancia);
        }
        
        public void frenar(Vehiculo vehiculo){
//            Dejará de avanzar y se frenará 2 metros más adelante. En el caso de la bicicleta, se frenará y no avanzará
//más metros. trayecto 5 minutos.
            if (!"bicicleta".equals(vehiculo.getTipo())){
                vehiculo.setMetrosR(vehiculo.getMetrosR() + 2);
            }
            
        }
        
}
