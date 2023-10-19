package tienda.services;

import java.util.ArrayList;
import tienda.entities.Fabricante;
import tienda.persistence.FabricanteDao;

public class FabricanteService {

    private FabricanteDao fabricanteDao;

    public FabricanteService() {
        this.fabricanteDao = new FabricanteDao();
    }

    public void createFabricante(String nombre) throws Exception {
        try {
            if (nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar un nombre");
            }
            Fabricante fabricante = new Fabricante();
            fabricante.setNombre(nombre);
            fabricanteDao.saveFabricante(fabricante);
        } catch (Exception e) {
            throw e;
        }
    }

    public void updateNombre(int codigo, String nombre) throws Exception {
        try {
            if (fabricanteDao.getByCodigo(codigo) == null) {
                throw new Exception("No existe un fabricante con ese número de código");
            }
            if (nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nuevo nombre");
            }
            Fabricante fabricante = fabricanteDao.getByCodigo(codigo);
            fabricante.setNombre(nombre);
            fabricanteDao.updateFabricante(fabricante);
        } catch (Exception e) {
            throw e;
        }
    }

    public void deleteFabricante(int codigo) throws Exception {
        try {
            if (fabricanteDao.getByCodigo(codigo) == null) {
                throw new Exception("No existe un fabricante con ese número de código");
            }
            fabricanteDao.deleteFabricante(codigo);
        } catch (Exception e) {
            throw e;
        }
    }

    public Fabricante getFabricanteById(Integer id) throws Exception {
        try {
            if (id == null) {
                throw new Exception("Debe indicar el id");
            }
            Fabricante fabricante = fabricanteDao.getByCodigo(id);
            System.out.println(fabricante);
            return fabricante;
        } catch (Exception e) {
            throw e;
        }
    }

    public ArrayList<Fabricante> getAllFabricantes() throws Exception {
        try {
            ArrayList<Fabricante> fabricantes = fabricanteDao.getAll();
            return fabricantes;
        } catch (Exception e) {
            throw e;
        }
    }

    public void printFabricantes() throws Exception {
        try {
            ArrayList<Fabricante> fabricantes = getAllFabricantes();

            if (fabricantes.isEmpty()) {
                throw new Exception("No existen usuarios para imprimir");
            } else {
                for (Fabricante f : fabricantes) {
                    System.out.println(f);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
