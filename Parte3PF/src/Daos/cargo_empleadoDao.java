package Daos;

import Entidad.Empleado;
import Entidad.cargo_empleado;
import View.PanelCrud;
import conexion.BDconexionPostgre;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class cargo_empleadoDao implements Icargo_empleadoDao {
    private static Map<String, Integer> cargosMap = new HashMap<>();
    BDconexionPostgre conex = new BDconexionPostgre();
    @Override
    public boolean registrarCargo_empleado(cargo_empleado Cargo_empleado) {
        boolean registrar = false;
        try {
            Statement stmt = conex.getConnection().createStatement();
            stmt.executeUpdate(
                    "INSERT INTO cargo_empleado (id,descripcion, estado) " +
                            "VALUES ('" +Cargo_empleado.getId() + "','"+ Cargo_empleado.getDescripcion() + "','"+Cargo_empleado.isEstado()+"')");

            registrar = true;
            stmt.close();
            conex.desconectar();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return registrar;
    }

    @Override
    public ArrayList<cargo_empleado> listaDeCargos() {
        PanelCrud panelCrud = new PanelCrud();
        ArrayList<cargo_empleado> cargos = new ArrayList<cargo_empleado>();
        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM cargo_empleado");
            ResultSet res = consulta.executeQuery();
           int i = 1;
            while (res.next()) {
                //System.out.println(res.getArray("id"));
                cargo_empleado car = new cargo_empleado();
                car.setId(res.getInt("id"));
                car.setDescripcion(res.getString("descripcion"));
                car.setEstado(res.getBoolean("estado"));
                cargosMap.put(car.getDescripcion(),(i));
                i++;
                cargos.add(car);
            }
            res.close();
            consulta.close();
            conex.desconectar();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return cargos;
    }


}
