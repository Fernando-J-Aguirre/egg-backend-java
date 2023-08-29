package services;

import entities.Cliente;
import entities.Policy;
import entities.TipoVehiculo;
import entities.Vehiculo;
import java.util.ArrayList;
import java.util.Scanner;

public class DataManager {

    private final ClienteService clienteService;
    private final VehiculoService vehiculoService;
    private final PolicyService policyService;
    private final InstallmentService cuotaService;

    public DataManager() {
        this.cuotaService = new InstallmentService();
        this.policyService = new PolicyService(cuotaService);
        this.vehiculoService = new VehiculoService(policyService);
        this.clienteService = new ClienteService(vehiculoService);
    }

    public void programInit() {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        int option;
        do {
            menu();
            System.out.println("Ingrese una opción del menú");
            option = sc.nextInt();
            optionMenu(option);
        } while (option != 0);
    }

    private void menu() {
        System.out.println("Menu");
        System.out.println("-------");
        System.out.println("1- Registrar cliente");
        System.out.println("2- Buscar cliente por DNI");
        System.out.println("3- Mostrar vehículos de un cliente");
        System.out.println("4- Mostrar todos los clientes");
        System.out.println("5- Agregar vehículo a cliente");
        System.out.println("6- Eliminar cliente (Se eliminará todo lo relacionado con él, póliza, vehículo)");
        System.out.println("7- Buscar vehículo por tipo");
        System.out.println("8- Buscar vehículo por número de motor o chasis");
        System.out.println("9- Buscar propietario de un vehículo");
        System.out.println("10- Mostrar todos los vehículos");
        System.out.println("11- Buscar póliza por número");
        System.out.println("12- Buscar póliza relacionada a un vehículo");
        System.out.println("13- Mostrar todas las pólizas");
        System.out.println("0- Salir");
    }

    private void optionMenu(int option) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        switch (option) {
            case 1:
                clienteService.registrarCliente();
                break;
            case 2:
                System.out.println("Ingrese dni");
                Cliente clien = clienteService.getClientByDni(sc.nextInt());
                System.out.println(clien.getVehiculos());
                break;
            case 3:
                clienteService.listarVehiculosDeCliente();
                break;
            case 4:
                ArrayList<Cliente> allClients = clienteService.getAllClients();
                for (Cliente client : allClients) {
                    System.out.println(client);
                }
                break;
            case 5:
                System.out.println("Ingrese dni");
                int dni = sc.nextInt();
                Vehiculo vehicle = vehiculoService.crearVehiculo();
                clienteService.addVehicleToClient(dni, vehicle);
                break;
            case 6:
                clienteService.deleteCliente();
                break;
            case 7:
                System.out.println("Ingrese el tipo de vehículo");
                TipoVehiculo tipo = TipoVehiculo.valueOf(sc.next().toUpperCase());
                ArrayList<Vehiculo> vehicles = vehiculoService.buscarPorTipo(tipo);
                for (Vehiculo vehicle1 : vehicles) {
                    System.out.println(vehicle1);
                }
                break;
            case 8:
                Vehiculo vehic = vehiculoService.getByNumber();
                if (vehic != null) {
                    System.out.println(vehic);
                }
                break;
            case 9:
                ArrayList<Cliente> clients = clienteService.getAllClients();
                vehiculoService.getVehicleOwner(clients);
                break;
            case 10:
                ArrayList<Vehiculo> vehics = vehiculoService.getAllVehicles();
                for (Vehiculo vehi1 : vehics) {
                    System.out.println(vehi1);
                }
                break;
            case 11:
                System.out.println("Ingrese el número de póliza");
                Policy policy = policyService.getByPolicyNumber(sc.nextInt());
                System.out.println(policy);
                break;
            case 12:
                Vehiculo vehiculo = vehiculoService.getByNumber();
                Policy policy1 = policyService.findPolicyByVehicle(vehiculo);
                if (policy1 != null) {
                    System.out.println(policy1);
                }
                break;
            case 13:
                ArrayList<Policy> policies = policyService.getAllPolicies();
                for(Policy policy2 : policies) {
                    System.out.println(policy2);
                }
                break;
            case 0:
                System.out.println("Saliendo...");
                sc.close();
                break;
            default:
                System.out.println("Opción inválida. Ingrese nuevamente.");
        }
    }

}
