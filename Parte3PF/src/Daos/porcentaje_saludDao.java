package Daos;

import Entidad.porcentaje_salud;
import conexion.BDconexionPostgre;
import java.sql.SQLException;
import java.sql.Statement;

public class porcentaje_saludDao implements  Iporcentaje_saludDao{

    BDconexionPostgre conex = new BDconexionPostgre();
    @Override
    public boolean registrarPorcentaje_salud(porcentaje_salud salud) {
        boolean registrar = false;
        try {
            Statement stmt = conex.getConnection().createStatement();
            stmt.executeUpdate(
                    "INSERT INTO porcentaje_salud (id,valor, estado)" +
                            " VALUES ('" + salud.getId() + "','"+salud.getDescripcion() + "','"+salud.isEstado()+"')");

            registrar = true;
            stmt.close();
            conex.desconectar();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return registrar;
    }
}
