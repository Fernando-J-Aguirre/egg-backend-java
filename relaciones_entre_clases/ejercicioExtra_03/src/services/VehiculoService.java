package services;

import entities.Cliente;
import entities.Poliza;
import entities.TipoVehiculo;
import entities.Vehiculo;
import java.util.ArrayList;
import java.util.Scanner;

public class VehiculoService {

    private Scanner sc;
    private ArrayList<Vehiculo> vehiculos;
    private PolizaService polizaService;

    public VehiculoService(PolizaService polizaService) {
        sc = new Scanner(System.in).useDelimiter("\n");
        vehiculos = new ArrayList<>();
        this.polizaService = polizaService;
    }

    public Vehiculo crearVehiculo() {
        Vehiculo vehiculo = new Vehiculo();
        System.out.println("Ingrese marca");
        vehiculo.setMarca(sc.next());
        System.out.println("Ingrese modelo");
        vehiculo.setModelo(sc.next());
        System.out.println("Ingrese color");
        vehiculo.setColor(sc.next());
        System.out.println("Ingrese tipo");
        String tipo = sc.next();
        for (TipoVehiculo aux : TipoVehiculo.values()) {
            if (aux.toString().equalsIgnoreCase(tipo)) {
                vehiculo.setTipo(aux);
                break;
            }
        }
        System.out.println("Ingrese número de motor");
        vehiculo.setNumeroMotor(sc.next());
        System.out.println("Ingrese número de chasis");
        vehiculo.setChasis(sc.next());
        System.out.println("Ingrese año del vehículo");
        vehiculo.setAnio(sc.nextInt());
        Poliza poliza = polizaService.crearPoliza();
        vehiculo.setPoliza(poliza);
        vehiculos.add(vehiculo);
        return vehiculo;
    }

    public ArrayList<Vehiculo> buscarPorTipo(TipoVehiculo tipo) {
        ArrayList<Vehiculo> vehiclesByType = new ArrayList<>();
        for (Vehiculo vehicle : vehiculos) {
            if (vehicle.getTipo().equals(tipo)) {
                vehiclesByType.add(vehicle);
            }
        }
        return vehiclesByType;
    }

    public Vehiculo getByNumber() {
        System.out.println("Ingrese el número de motor o de chasis del vehículo");
        String number = sc.next();
        for (Vehiculo vehicle : vehiculos) {
            if (vehicle.getChasis().equalsIgnoreCase(number) || vehicle.getNumeroMotor().equalsIgnoreCase(number)) {
                return vehicle;
            }
        }
        return null;
    }

    public void getVehicleOwner(ArrayList<Cliente> clients) {
        Vehiculo vehicle = getByNumber();
        for (Cliente client : clients) {
            if (client.getVehiculos().contains(vehicle)) {
                System.out.println("El vehículo pertenece a: " + client.getNombre() + " " + client.getApellido());
                return;
            }
        }
        System.out.println("ERROR. No se encontró información del propietario");
    }

    public ArrayList<Vehiculo> getAllVehicles() {
        return vehiculos;
    }

    public void removeVehiclesOfClient(Cliente client) {
        ArrayList<Vehiculo> toRemove = client.getVehiculos();
        for (Vehiculo vehicle : toRemove) {
            if(vehiculos.contains(vehicle)) {
                polizaService.deletePoliza(vehicle);
                vehiculos.remove(vehicle);
            }
        }        
    }

}
