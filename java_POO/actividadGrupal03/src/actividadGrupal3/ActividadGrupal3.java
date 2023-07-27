package actividadGrupal3;

import services.ClientSrv;

public class ActividadGrupal3 {

    public static void main(String[] args) {
        ClientSrv.registrarCliente();
        ClientSrv.obtenerClientes();
        ClientSrv.actualizarCliente(1, "Hola", (byte) 22, (short) 77, (short) 88, "iofjoesifj");
        ClientSrv.obtenerClientes();
        
        
        
    }

}
