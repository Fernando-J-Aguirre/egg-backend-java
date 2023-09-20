package services;

import entities.Accommodation;
import entities.Camping;
import entities.FiveStars;
import entities.FourStars;
import entities.Hotel;
import entities.Residential;
import java.util.ArrayList;
import java.util.Scanner;

public class HotelService {

    public ArrayList<Accommodation> accomodations = new ArrayList<>();

    public void createHotel() {
        Accommodation accommodation;
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese el tipo de alojamiento que quiere cargar");
        System.out.println("1- Camping");
        System.out.println("2- Residencia");
        System.out.println("4- Cuatro Estrellas");
        System.out.println("5- Cuatro Estrellas");
        int tipo = sc.nextInt();
        System.out.println("Ingrese el nombre del hotel");
        String name = sc.next();
        System.out.println("Ingrese la dirección");
        String address = sc.next();
        System.out.println("Ingrese la ciudad");
        String city = sc.next();
        System.out.println("Ingrese el nombre del gerente");
        String manager = sc.next();
        if (tipo != 1 && tipo != 2) {
            System.out.println("Ingrese cantidad de habitaciones");
            int roomsAmount = sc.nextInt();
            System.out.println("Ingrese cantidad de camas");
            int bedsAmount = sc.nextInt();
            System.out.println("Ingrese cantidad de pisos");
            int floorsAmount = sc.nextInt();
            System.out.println("Ingrese el precio de la habitación");
            double bedroomPrice = sc.nextDouble();
            System.out.println("Ingrese tipo de gimnasio (A/B)");
            String gym = sc.next();
            System.out.println("Ingrese nombre de restaurante");
            String restaurantName = sc.next();
            System.out.println("Ingrese capacidad del restaurante");
            int restaurantCapacity = sc.nextInt();
            if (tipo == 4) {
                accommodation = new FourStars(name, address, city, manager, roomsAmount, bedsAmount, floorsAmount, bedroomPrice, gym, restaurantName, restaurantCapacity);
            } else {
                System.out.println("Ingrese cantidad de salones de conferencia");
                int conferenceRoomsAmount = sc.nextInt();
                System.out.println("Ingrese cantidad de suites");
                int suitesAmount = sc.nextInt();
                System.out.println("Ingrese cantidad de limosinas");
                int limoAmount = sc.nextInt();
                accommodation = new FiveStars(name, address, city, manager, roomsAmount, bedsAmount, floorsAmount, bedroomPrice, gym, restaurantName, restaurantCapacity, conferenceRoomsAmount, suitesAmount, limoAmount);
            }
        } else {
            System.out.println("¿Es privado? true/false");
            boolean privateAcc = sc.nextBoolean();
            System.out.println("Ingrese cantidad de metros cuadrados que ocupa");
            double squareMts = sc.nextDouble();
            if (tipo == 1) {
                System.out.println("Ingrese capacidad máxima de carpas");
                int maxTent = sc.nextInt();
                System.out.println("Ingrese cantidad de baños");
                int bathroomsAmount = sc.nextInt();
                System.out.println("¿Posee restaurante? true/false");
                boolean restaurant = sc.nextBoolean();
                accommodation = new Camping(name, address, city, manager, privateAcc, squareMts, maxTent, bathroomsAmount, restaurant);
            } else {
                System.out.println("Ingrese cantidad de habitaciones");
                int roomsAmount = sc.nextInt();
                System.out.println("¿Se hacen descuentos a los gremios? true/false");
                boolean unionDiscount = sc.nextBoolean();
                System.out.println("¿Posee campo deportivo? true/false");
                boolean sportsFiled = sc.nextBoolean();
                accommodation = new Residential(name, address, city, manager, privateAcc, squareMts, roomsAmount, unionDiscount, sportsFiled);
            }
        }
        accomodations.add(accommodation);
    }

    public void createAlternativeAcc() {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese el tipo de alojamiento extra hotelero que quiere cargar (1-2)");

        int tipo = sc.nextInt();

    }

    public double calculateRoomPrice(Hotel hotel) {
        return 50 + (hotel.getBedsAmount() * hotel.getRoomsAmount()) + (restaurantExtra(hotel))
                + (gymExtra(hotel)) + (limoExtra(hotel));
    }

    public double restaurantExtra(Hotel hotel) {
        if (hotel.getRestaurantCapacity() > 50) {
            return 50;
        } else if (hotel.getRestaurantCapacity() >= 30) {
            return 30;
        } else {
            return 10;
        }
    }

    public double gymExtra(Hotel hotel) {
        if (hotel.getGym().equalsIgnoreCase("A")) {
            return 50;
        } else {
            return 30;
        }
    }

    public double limoExtra(Hotel hotel) {
        if (hotel instanceof FiveStars) {
            return ((FiveStars) hotel).getLimoAmount() * 15;
        } else {
            return 0;
        }
    }

    public ArrayList<Accommodation> getAllHotels() {
        return accomodations;
    }
    
    public ArrayList<Hotel> getHotelsSortedByPrice() {
        ArrayList<Hotel> hotels = new ArrayList<>();
        for (Accommodation acc : accomodations) {
            
        }
        
        return hotels;
    }

    
//• todos los hoteles de más caro a más barato.
//• todos los campings con restaurante
//• todos las residencias que tienen descuento.
}
