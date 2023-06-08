package Daos;

import Controller.Controller;
import Entidad.Empleado;
import Entidad.cargo_empleado;
import conexion.BDconexionPostgre;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class EmpleadoDao implements IempleadoDao{

    BDconexionPostgre conex = new BDconexionPostgre();
    @Override
    public boolean registrarEmpleado(Empleado emp)  {
        boolean registrar = false;
        try {
            Statement stmt = conex.getConnection().createStatement();
            stmt.executeUpdate(
                    "INSERT INTO empleado (id,tpo_documento, documento_cotizante,nombre_cotizante,id_cargo,salario_basico,estado) " +
                            "VALUES ('" + emp.getId() + "','"+ emp.getTpo_documento() + "','"+ emp.getDocumento_cotizante() + "','"+ emp.getNombre_cotizante() + "','"+ emp.getId_cargo() + "','"
                            + emp.getSalario_basico() + "','"+emp.isEstado()+"')");

            registrar = true;
            stmt.close();
            conex.desconectar();
            if (registrar) {
                JOptionPane.showMessageDialog(null, "Registro añadido exitosamente", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo añadido el registro", "INFORMACION", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return registrar;


    }


    @Override
    public ArrayList<Empleado> listaDeEmpleados() {
        ArrayList<Empleado> emp = new ArrayList<Empleado>();
        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM empleado");
            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                //System.out.println(res.getArray("id"));
                Empleado empleado = new Empleado();
                empleado.setId(res.getInt("id"));
                empleado.setTpo_documento(res.getString("tpo_documento"));
                empleado.setDocumento_cotizante(res.getString("documento_cotizante"));
                empleado.setNombre_cotizante(res.getString("nombre_cotizante"));
                empleado.setId_cargo(res.getInt("id_cargo"));
                empleado.setSalario_basico(res.getString("salario_basico"));
                empleado.setEstado(res.getBoolean("estado"));
               // System.out.println("B"+empleado.getId());
                emp.add(empleado);
            }
            res.close();
            consulta.close();
            conex.desconectar();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return emp;
    }

    @Override
    public ArrayList<Empleado> listaDeBusqueda(String columna, String valor) {
        ArrayList<Empleado> busqueda = new ArrayList<Empleado>();
        try {
            valor = "'"+valor+"'";
            if (columna.equals("Tipo de documento")){
                System.out.println("columna "+columna+" valor "+valor);
                PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM empleado WHERE tpo_documento = "+valor);//UPDATE empleado SET tpo_documento ='"+emp.getTpo_documento()+"'" +" WHERE id="+emp.getId()
                ResultSet res = consulta.executeQuery();
                while (res.next()) {
                    //System.out.println(res.getArray("id"));
                    Empleado empleado = new Empleado();
                    empleado.setId(res.getInt("id"));
                    empleado.setTpo_documento(res.getString("tpo_documento"));
                    empleado.setDocumento_cotizante(res.getString("documento_cotizante"));
                    empleado.setNombre_cotizante(res.getString("nombre_cotizante"));
                    empleado.setId_cargo(res.getInt("id_cargo"));
                    empleado.setSalario_basico(res.getString("salario_basico"));
                    empleado.setEstado(res.getBoolean("estado"));
                    // System.out.println("B"+empleado.getId());
                    busqueda.add(empleado);
                }
            }else if (columna.equals("Numero de documento")){
                PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM empleado  WHERE documento_cotizante="+valor);//UPDATE empleado SET tpo_documento ='"+emp.getTpo_documento()+"'" +" WHERE id="+emp.getId()
                ResultSet res2 = consulta.executeQuery();
                while (res2.next()) {
                    //System.out.println(res.getArray("id"));
                    Empleado empleado = new Empleado();
                    empleado.setId(res2.getInt("id"));
                    empleado.setTpo_documento(res2.getString("tpo_documento"));
                    empleado.setDocumento_cotizante(res2.getString("documento_cotizante"));
                    empleado.setNombre_cotizante(res2.getString("nombre_cotizante"));
                    empleado.setId_cargo(res2.getInt("id_cargo"));
                    empleado.setSalario_basico(res2.getString("salario_basico"));
                    empleado.setEstado(res2.getBoolean("estado"));
                    // System.out.println("B"+empleado.getId());
                    busqueda.add(empleado);
                }
            }else if (columna.equals("Nombre")){
                System.out.println(valor+"valor");
                PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM empleado  WHERE nombre_cotizante="+valor);//UPDATE empleado SET tpo_documento ='"+emp.getTpo_documento()+"'" +" WHERE id="+emp.getId()
                ResultSet res = consulta.executeQuery();
                while (res.next()) {
                    //System.out.println(res.getArray("id"));
                    Empleado empleado = new Empleado();
                    empleado.setId(res.getInt("id"));
                    empleado.setTpo_documento(res.getString("tpo_documento"));
                    empleado.setDocumento_cotizante(res.getString("documento_cotizante"));
                    empleado.setNombre_cotizante(res.getString("nombre_cotizante"));
                    empleado.setId_cargo(res.getInt("id_cargo"));
                    empleado.setSalario_basico(res.getString("salario_basico"));
                    empleado.setEstado(res.getBoolean("estado"));
                    // System.out.println("B"+empleado.getId());
                    busqueda.add(empleado);
                }
            }else if (columna.equals("Salario básico")){
                PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM empleado  WHERE salario_basico="+valor);//UPDATE empleado SET tpo_documento ='"+emp.getTpo_documento()+"'" +" WHERE id="+emp.getId()
                ResultSet res = consulta.executeQuery();
                while (res.next()) {
                    //System.out.println(res.getArray("id"));
                    Empleado empleado = new Empleado();
                    empleado.setId(res.getInt("id"));
                    empleado.setTpo_documento(res.getString("tpo_documento"));
                    empleado.setDocumento_cotizante(res.getString("documento_cotizante"));
                    empleado.setNombre_cotizante(res.getString("nombre_cotizante"));
                    empleado.setId_cargo(res.getInt("id_cargo"));
                    empleado.setSalario_basico(res.getString("salario_basico"));
                    empleado.setEstado(res.getBoolean("estado"));
                    // System.out.println("B"+empleado.getId());
                    busqueda.add(empleado);
                }
            }
            conex.desconectar();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return busqueda;
    }

    /* @Override
     public boolean actualizar(Empleado emp,String columna) {
         boolean registrar = false;
        try {
            Statement stmt = conex.getConnection().createStatement();
            if (columna.equals("Tipo de documento")){
                stmt.executeUpdate(
                        "UPDATE CLIENTE SET tpo_documento='"+emp.getTpo_documento()+"', nombres='"+cliente.getNombre()
                                +"', apellidos='"+cliente.getApellido()+"'" +" WHERE ID="+cliente.getId());

                registrar = true;
            }else if (columna.equals("Numero de documento")){
                stmt.executeUpdate(
                        "UPDATE CLIENTE SET cedula='"+cliente.getCedula()+"', nombres='"+cliente.getNombre()
                                +"', apellidos='"+cliente.getApellido()+"'" +" WHERE ID="+cliente.getId());

                registrar = true;
            }else if (columna.equals("Nombre")){
                stmt.executeUpdate(
                        "UPDATE CLIENTE SET cedula='"+cliente.getCedula()+"', nombres='"+cliente.getNombre()
                                +"', apellidos='"+cliente.getApellido()+"'" +" WHERE ID="+cliente.getId());

                registrar = true;
            }else if (columna.equals("Salario básico")){
                stmt.executeUpdate(
                        "UPDATE CLIENTE SET cedula='"+cliente.getCedula()+"', nombres='"+cliente.getNombre()
                                +"', apellidos='"+cliente.getApellido()+"'" +" WHERE ID="+cliente.getId());

                registrar = true;
            }
             stmt.close();
             conex.desconectar();

         } catch (SQLException e) {
             System.out.println(e.getMessage());
         }

         return registrar;

         boolean registrar = false;
         try {
             Statement stmt = conex.getConnection().createStatement();
             stmt.executeUpdate(
                     "INSERT INTO empleado (id,tpo_documento, documento_cotizante,nombre_cotizante,id_cargo,salario_basico,estado) " +
                             "VALUES ('" + emp.getId() + "','"+ emp.getTpo_documento() + "','"+ emp.getDocumento_cotizante() + "','"+ emp.getNombre_cotizante() + "','"+ emp.getId_cargo() + "','"
                             + emp.getSalario_basico() + "','"+emp.isEstado()+"')");

             registrar = true;
             stmt.close();
             conex.desconectar();
                   // String sql="UPDATE empleado SET cedula='"+cliente.getCedula()+"', nombres='"+cliente.getNombre()+"', apellidos='"+cliente.getApellido()+"'" +" WHERE id="+emp.getId();

     }*/
   @Override
   public boolean actualizar(Empleado emp,String columna) {
       boolean registrar = false;
       try {
           Statement stmt = conex.getConnection().createStatement();
           if (columna.equals("Tipo de documento")){
               stmt.executeUpdate("UPDATE empleado SET tpo_documento ='"+emp.getTpo_documento()+"'" +" WHERE id="+emp.getId());
               registrar = true;
           }else if (columna.equals("Numero de documento")){
               stmt.executeUpdate("UPDATE empleado SET documento_cotizante ='"+emp.getDocumento_cotizante()+"'" +" WHERE id="+emp.getId());
               registrar = true;
           }else if (columna.equals("Nombre")){
               stmt.executeUpdate("UPDATE empleado SET nombre_cotizante ='"+emp.getNombre_cotizante()+"'" +" WHERE id="+emp.getId());
               registrar = true;
           }else if (columna.equals("Salario básico")){
               stmt.executeUpdate("UPDATE empleado SET salario_basico ='"+emp.getSalario_basico()+"'" +" WHERE id="+emp.getId());
               registrar = true;
           }else if (columna.equals("Cargo")){
               ArrayList<cargo_empleado> car;
               cargo_empleado cargo = new cargo_empleado();
               Icargo_empleadoDao dao = new cargo_empleadoDao();
               car = dao.listaDeCargos();
               int temp = 0;
               for (int i = 0; i<car.size();i++){
                   if (car.get(i).getDescripcion().equals(emp.getNom_cargo())){
                       temp = car.get(i).getId();
                       break;
                   }
               }
               stmt.executeUpdate("UPDATE empleado SET id_cargo ='"+temp+"'" +" WHERE id="+emp.getId());
               registrar = true;
           }

           if (registrar) {
               JOptionPane.showMessageDialog(null, "Registro actualizado exitosamente", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
           } else {
               JOptionPane.showMessageDialog(null, "No se pudo actualizar el registro", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
           }
           registrar = true;
           stmt.close();
           conex.desconectar();
       } catch (SQLException e) {
           System.out.println(e.getMessage());
           //System.out.println("Error: Clase ClienteDaoImple, método actualizar");
           e.printStackTrace();
       }catch (Exception e){
           JOptionPane.showMessageDialog(null, "No se pudo actualizar el registro recuerde ingresar un id", "ERROR", JOptionPane.INFORMATION_MESSAGE);
           e.printStackTrace();

       }
       return registrar;
   }

    @Override
    public boolean eliminar(int emp) {
        boolean registrar = false;
        try {
            ArrayList<Empleado> emple;
            IempleadoDao dao = new EmpleadoDao();
            emple = dao.listaDeEmpleados();           // eliminar_deDetalle_nomina(emp);
            Statement stmt = conex.getConnection().createStatement();
            stmt.executeUpdate("DELETE FROM detalle_nomina WHERE id="+emp);
            stmt.executeUpdate("DELETE FROM empleado WHERE id="+emp);
            stmt.executeUpdate("DELETE FROM porcentaje_pension WHERE id="+emp);
            stmt.executeUpdate("DELETE FROM porcentaje_salud WHERE id="+emp);

            if (registrar) {
                JOptionPane.showMessageDialog(null, "Registro eliminado exitosamente", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro", "INFORMACION", JOptionPane.ERROR_MESSAGE);
            }
            registrar = true;
            stmt.close();
            conex.desconectar();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //System.out.println("Error: Clase ClienteDaoImple, método actualizar");
            e.printStackTrace();
        }
        return registrar;
    }

}
