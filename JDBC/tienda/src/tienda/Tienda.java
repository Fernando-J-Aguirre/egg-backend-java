package tienda;

import tienda.services.FabricanteService;

public class Tienda {

    public static void main(String[] args) throws Exception {

        FabricanteService fs = new FabricanteService();
//        fs.createFabricante("HOLA");
//        fs.updateNombre(11, "Philips");
//        fs.deleteFabricante(11);
        fs.getFabricanteById(9);
        System.out.println();
        fs.printFabricantes();
    }

}
