package Daos;

import Entidad.Empleado;
import Entidad.detalle_nomina;
import conexion.BDconexionPostgre;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class detalle_nominaDao implements Idetalle_nominaDao {

    BDconexionPostgre conex = new BDconexionPostgre();


    @Override
    public boolean registrarDetalle_nomina(detalle_nomina detalle_nomina) {
        boolean registrar = false;
        try {
            Statement stmt = conex.getConnection().createStatement();
            stmt.executeUpdate(
                    "INSERT INTO detalle_nomina (id,id_tpo_cotizante, id_subtpo_cotizante,id_empleado,periodo,periodo_salario,id_novedad,num_dias_trabajados,num_dias_incapacidad,num_dias_licencia,num_dias_permisos_remunerados,num_dias_permisos_no_remunerados,num_dias_vacaciones,num_dias_huelga,id_porcentaje_salud,id_porcentaje_pension)" +
                            " VALUES ('" +detalle_nomina.getId() + "','"+ detalle_nomina.getId_tpo_cotizante() + "','"+ detalle_nomina.getId_subtpo_cotizante()+ "','"+detalle_nomina.getId_empleado()+ "','"+ detalle_nomina.getPeriodo()+ "','"+ detalle_nomina.getPeriodo_salario()+
                            "','"+ detalle_nomina.getId_novedad()+ "','"+ detalle_nomina.getNum_dias_trabajados()+ "','"+ detalle_nomina.getNum_dias_incapacidad()+ "','"+ detalle_nomina.getNum_dias_licencia()+ "','"+ detalle_nomina.getNum_dias_permisos_remunerados()
                            + "','"+ detalle_nomina.getNum_dias_permisos_no_remunerados()+ "','"+ detalle_nomina.getNum_dias_vacaciones()+ "','"+ detalle_nomina.getNum_dias_huelga()+"','"+detalle_nomina.getId_porcentaje_salud()+  "','"+detalle_nomina.getId_porcentaje_pension()+"')");


            if (registrar) {
                JOptionPane.showMessageDialog(null, "Empleado registrado en la nomina exitosamente", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo registrar en nomina el empleado", "INFORMACION", JOptionPane.ERROR_MESSAGE);
            }
            registrar = true;
            stmt.close();
            conex.desconectar();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return registrar;
    }

    @Override
    public ArrayList<detalle_nomina> listaNomina() {
        ArrayList<detalle_nomina> nom = new ArrayList<detalle_nomina>();
        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM detalle_nomina");
            ResultSet rs = consulta.executeQuery();
            while (rs.next()) {
                //System.out.println(res.getArray("id"));
                detalle_nomina dNomina = new detalle_nomina();
                dNomina.setId(rs.getInt("id"));
                dNomina.setId_tpo_cotizante(rs.getInt("id_tpo_cotizante"));
                dNomina.setId_subtpo_cotizante(rs.getInt("id_subtpo_cotizante"));
                dNomina.setId_empleado(rs.getInt("id_empleado"));
                dNomina.setPeriodo(rs.getString("periodo"));
                dNomina.setPeriodo_salario(rs.getString("periodo_salario"));
                dNomina.setId_novedad(rs.getInt("id_novedad"));
                dNomina.setNum_dias_trabajados(rs.getString("num_dias_trabajados"));
                dNomina.setNum_dias_incapacidad(rs.getString("num_dias_incapacidad"));
                dNomina.setNum_dias_licencia(rs.getString("num_dias_licencia"));
                dNomina.setNum_dias_permisos_remunerados(rs.getString("num_dias_permisos_remunerados"));
                dNomina.setNum_dias_permisos_no_remunerados(rs.getString("num_dias_permisos_no_remunerados"));
                dNomina.setNum_dias_vacaciones(rs.getString("num_dias_vacaciones"));
                dNomina.setNum_dias_huelga(rs.getString("num_dias_huelga"));
                dNomina.setId_porcentaje_salud(rs.getInt("id_porcentaje_salud"));
                dNomina.setId_porcentaje_salud(rs.getInt("id_porcentaje_pension"));

                nom.add(dNomina);
            }
            rs.close();
            consulta.close();
            conex.desconectar();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return nom;
    }
}
