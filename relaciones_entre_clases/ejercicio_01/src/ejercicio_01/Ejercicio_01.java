package ejercicio_01;

import services.MenuService;
import services.PerroService;
import services.PersonaService;

public class Ejercicio_01 {

    public static void main(String[] args) {
        PerroService perroService = new PerroService();
        PersonaService personaService = new PersonaService(perroService);
        MenuService menuService = new MenuService(perroService, personaService);
        menuService.mostrarMenu();
    }

}
