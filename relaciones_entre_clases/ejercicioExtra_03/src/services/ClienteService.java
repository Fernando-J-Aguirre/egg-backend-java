package services;

import entities.Cliente;
import entities.Vehiculo;
import java.util.ArrayList;
import java.util.Scanner;

public class ClienteService {

    private Scanner sc;
    private Cliente cliente;
    private VehiculoService vehiculoService;
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Cliente> clientes;

    public ClienteService(VehiculoService vehiculoService) {
        sc = new Scanner(System.in).useDelimiter("\n");
        cliente = new Cliente();
        this.vehiculoService = vehiculoService;
        vehiculos = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    public Cliente registrarCliente() {
        System.out.println("Ingrese nombre");
        cliente.setNombre(sc.next());
        System.out.println("Ingrese apellido");
        cliente.setApellido(sc.next());
        System.out.println("Ingrese DNI");
        cliente.setDni(sc.nextInt());
        System.out.println("Ingrese Domicilio");
        cliente.setDomicilio(sc.next());
        System.out.println("Ingrese mail");
        cliente.setMail(sc.next());
        System.out.println("Ingrese teléfono");
        cliente.setTelefono(sc.nextInt());
        System.out.println("Ingrese cuántos vehículos están a su nombre");
        int cantidad = sc.nextInt();
        for (int i = 0; i < cantidad; i++) {
            Vehiculo vehiculo = vehiculoService.crearVehiculo();
            vehiculos.add(vehiculo);
        }
        cliente.setVehiculos(vehiculos);
        clientes.add(cliente);
        return cliente;
    }

    public void listarVehiculosDeCliente() {
        System.out.println("Ingrese DNI del cliente");
        int dni = sc.nextInt();
        Cliente client = getClientByDni(dni);
        if (client != null) {
            System.out.println(client.getVehiculos());
        }
    }

    public Cliente getClientByDni(int dni) {
        for (Cliente client : clientes) {
            if (cliente.getDni() == dni) {
                return client;
            }
        }
        return null;
    }

    public void deleteCliente() {
        System.out.println("Ingrese DNI del cliente que desea desvincular");
        int dni = sc.nextInt();
        Cliente client = getClientByDni(dni);
        if (client != null) {
            vehiculos.removeAll(client.getVehiculos());
            vehiculoService.removeVehiclesOfClient(client);
            clientes.remove(client);
            System.out.println("Cliente desvinculado exitosamente");
        }
    }
    
    public void addVehicleToClient(int dni, Vehiculo vehiculo) {
        for(Cliente client : clientes) {
            if(client.getDni() == dni) {
                ArrayList<Vehiculo> listVehicles = client.getVehiculos();
                listVehicles.add(vehiculo);
                client.setVehiculos(listVehicles);
                System.out.println("Vehículo añadido a cliente: " + client.getNombre() + " " + client.getApellido());
                return;
            }
        }
        System.out.println("No se encuentra cliente con el dni proporcionado");
    }
    
    public ArrayList<Cliente> getAllClients() {
        return clientes;
    }

}
