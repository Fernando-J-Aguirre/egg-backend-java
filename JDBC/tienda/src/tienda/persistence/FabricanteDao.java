package tienda.persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tienda.entities.Fabricante;

public final class FabricanteDao extends DAO {

    public void saveFabricante(Fabricante fabricante) throws Exception {
        try {
            if (fabricante == null) {
                throw new Exception("Fabricante no puede ser nulo");
            }
            String sql = "INSERT INTO fabricante (codigo, nombre)"
                    + "VALUES ( " + fabricante.getCodigo() + ", '" + fabricante.getNombre() + "' );";
            insertUpdateDelete(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public void updateFabricante(Fabricante fabricante) throws Exception {
        try {
            if (fabricante == null) {
                throw new Exception("Debe indicar un fabricante para modificar");
            }
            String sql = "UPDATE fabricante SET "
                    + "nombre = '" + fabricante.getNombre() + "' WHERE codigo = " + fabricante.getCodigo() + ";";
            System.out.println(sql);
            insertUpdateDelete(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public void deleteFabricante(int codigo) throws SQLException {
        try {
            String sql = "DELETE FROM fabricante WHERE codigo = " + codigo + ";";
            insertUpdateDelete(sql);
        } catch (SQLException e) {
            throw e;
        }
    }

    public Fabricante getByCodigo(int codigo) throws Exception {
        try {
            String sql = "SELECT * FROM fabricante WHERE codigo = " + codigo + ";";
            getData(sql);

            Fabricante fabricante = null;
            
            while (resultSet.next()) {
                fabricante = new Fabricante();
                fabricante.setCodigo(resultSet.getInt(1));
                fabricante.setNombre(resultSet.getString(2));
            }
            disconnect();
            return fabricante;

        } catch (Exception e) {
            disconnect();
            throw e;
        }
    }
    
    public ArrayList<Fabricante> getAll() throws Exception {
        try {
            String sql = "SELECT * FROM fabricante;";
            getData(sql);

            Fabricante fabricante;
            ArrayList<Fabricante> fabricantes = new ArrayList<>();
            while (resultSet.next()) {
                fabricante = new Fabricante();
                fabricante.setCodigo(resultSet.getInt(1));
                fabricante.setNombre(resultSet.getString(2));
                fabricantes.add(fabricante);
            }
            disconnect();
            return fabricantes;

        } catch (Exception e) {
            disconnect();
            throw e;
        }
    }

}
