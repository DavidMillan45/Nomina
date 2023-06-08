package Daos;

import Entidad.porcentaje_pension;
import conexion.BDconexionPostgre;
import java.sql.SQLException;
import java.sql.Statement;

public class porcentaje_pensionDao  implements  Iporcentaje_pensionDao{

    BDconexionPostgre conex = new BDconexionPostgre();

    @Override
    public boolean registrarPorcentaje_pension(porcentaje_pension pension) {
        boolean registrar = false;
        try {
            Statement stmt = conex.getConnection().createStatement();
            stmt.executeUpdate(
                    "INSERT INTO porcentaje_pension (id,valor, estado) " +
                            "VALUES ('" +pension.getId() + "','"+ pension.getDescripcion() + "','"+pension.isEstado()+"')");

            registrar = true;
            stmt.close();
            conex.desconectar();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return registrar;
    }
}
