package Controller;

import Daos.*;
import Entidad.*;
import Excel.ReadPostgresandExcel;
import View.VentanaCrud;
import View.VentanaPrincipal;
import View.VentanaTablas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Controller implements ActionListener {

    private VentanaPrincipal vPrincial;
    private VentanaCrud vCrud;
    private VentanaTablas vTablas;


    public Controller(){
        vPrincial  = new VentanaPrincipal();
        vCrud = new VentanaCrud();
        vTablas = new VentanaTablas();
        asignarOyentes();
    }


    public void asignarOyentes() {
        vPrincial.getPrincipal().getB_crud().addActionListener(this);
        vPrincial.getPrincipal().getB_añadir().addActionListener(this);
        vPrincial.getPrincipal().getB_excel().addActionListener(this);

        vCrud.getCrud().getB_buscar().addActionListener(this);
        vCrud.getCrud().getB_eliminar().addActionListener(this);
        vCrud.getCrud().getB_añadir().addActionListener(this);
        vCrud.getCrud().getB_refresh().addActionListener(this);
        vCrud.getCrud().getB_combo().addActionListener(this);
        vCrud.getCrud().getB_volver().addActionListener(this);
        vCrud.getCrud().getB_iractualizar().addActionListener(this);

        vTablas.getTablas().getB_agregar().addActionListener(this);
        vTablas.getTablas().getB_volver().addActionListener(this);
        vTablas.getTablas().getB_nomina().addActionListener(this);

        vTablas.getNomina().getB_volver().addActionListener(this);
        vTablas.getNomina().getB_agregar().addActionListener(this);

        vCrud.getPanelExcel().getB_convertir_excel().addActionListener(this);
        vCrud.getPanelExcel().getB_volver().addActionListener(this);
        vCrud.getPanelExcel().getB_mostrar_tabla().addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        int id = 0;
        double salario = 0;
        if (e.getActionCommand().equals("CRUD") || e.getActionCommand().equals("REFRESH")) {
            vPrincial.setVisible(false);
            vTablas.setVisible(false);
            vCrud.setVisible(true);
            vCrud.getCrud().setVisible(true);
            vCrud.getPanelExcel().setVisible(false);
            String resul = "";
            ArrayList<Empleado> emps = new ArrayList<>();
            IempleadoDao dao = new EmpleadoDao();
            emps = dao.listaDeEmpleados();
            Collections.sort(emps, new Comparator<Empleado>() {
                @Override
                public int compare(Empleado p1, Empleado p2) {
                    return new Integer(p1.getId()).compareTo(new Integer(p2.getId()));
                }
            });
            for (int i = 0; i<emps.size();i++){
               //System.out.println("A "+emps.get(-1).getId());
              resul = resul +(emps.get(i).getId()+"|"+emps.get(i).getTpo_documento()+"|"+emps.get(i).getDocumento_cotizante()+"|"+emps.get(i).getNombre_cotizante()+"|"+emps.get(i).getId_cargo()+"|"+emps.get(i).getSalario_basico()+"|"+emps.get(i).isEstado()+"\n");
            }
            vCrud.getCrud().getMostrar().setText(resul);
        } else if (e.getActionCommand().equals("AÑADIR")) {
            vPrincial.setVisible(false);
            vTablas.getTablas().setVisible(true);
            vTablas.setVisible(true);
            vTablas.getNomina().setVisible(false);
            vCrud.setVisible(false);

            ArrayList<cargo_empleado> car;
            Icargo_empleadoDao dao = new cargo_empleadoDao();
            car = dao.listaDeCargos();

            for (int j = 0; j<car.size();j++){
                vTablas.getTablas().getCargo().addItem(car.get(j).getDescripcion());
            }

        } else if (e.getActionCommand().equals("SELECCIONAR")) {
            if (vCrud.getCrud().getCombo().getSelectedItem().toString().equals("Tipo de documento")){
                vCrud.getCrud().getTpo_doc().setVisible(true);
                vCrud.getCrud().getA_buscar().setVisible(false);
            }else {
                vCrud.getCrud().getA_buscar().setVisible(true);
                vCrud.getCrud().getTpo_doc().setVisible(false);
            }

        }else if (e.getActionCommand().equals("ACTUALIZAR")){
            try {
                System.out.println(vCrud.getCrud().getA_añadir().getText());
                Empleado empleadoAux = new Empleado(Integer.parseInt(vCrud.getCrud().getA_id().getText()),vCrud.getCrud().getTpo_doc2().getSelectedItem().toString(),vCrud.getCrud().getA_añadir().getText(),vCrud.getCrud().getA_añadir().getText(),vCrud.getCrud().getCargo().getSelectedItem().toString(),vCrud.getCrud().getA_añadir().getText(),true);
                IempleadoDao dao = new EmpleadoDao();
                dao.actualizar(empleadoAux,(vCrud.getCrud().getCombo2().getSelectedItem().toString()));
            }catch (Exception h){
                JOptionPane.showMessageDialog(null, "No se pudo actualizar el registro recuerde ingresar un id", "ERROR", JOptionPane.ERROR_MESSAGE);
                //h.printStackTrace();
            }

        }else if(e.getActionCommand().equals("VOLVER") || e.getActionCommand().equals("VOLVERTABLAS") ){
            vPrincial.setVisible(true);
            vTablas.setVisible(false);
            vCrud.setVisible(false);
        }else if(e.getActionCommand().equals("IR")){
            if (vCrud.getCrud().getCombo2().getSelectedItem().toString().equals("Tipo de documento")){
                vCrud.getCrud().getTpo_doc2().setVisible(true);
                vCrud.getCrud().getA_añadir().setVisible(false);
            }else if (vCrud.getCrud().getCombo2().getSelectedItem().toString().equals("Numero de documento")){
                vCrud.getCrud().getA_añadir().setVisible(true);
                vCrud.getCrud().getTpo_doc2().setVisible(false);
            }else if (vCrud.getCrud().getCombo2().getSelectedItem().toString().equals("Cargo")){
                vCrud.getCrud().getCargo().setVisible(true);
                vCrud.getCrud().getA_añadir().setVisible(false);
                vCrud.getCrud().getTpo_doc2().setVisible(false);
                ArrayList<cargo_empleado> car;
                Icargo_empleadoDao dao = new cargo_empleadoDao();
                car = dao.listaDeCargos();
                for (int j = 0; j<car.size();j++){
                    vCrud.getCrud().getCargo().addItem(car.get(j).getDescripcion());
                }
            }else if (vCrud.getCrud().getCombo2().getSelectedItem().toString().equals("Salario básico")){
                vCrud.getCrud().getA_añadir().setVisible(true);
                vCrud.getCrud().getTpo_doc2().setVisible(false);
            }else if (vCrud.getCrud().getCombo2().getSelectedItem().toString().equals("Nombre")){
                vCrud.getCrud().getA_añadir().setVisible(true);
                vCrud.getCrud().getCargo().setVisible(false);
                vCrud.getCrud().getTpo_doc2().setVisible(false);
            }
        }else if(e.getActionCommand().equals("ELIMINAR")){
            IempleadoDao dao = new EmpleadoDao();
            try {
                dao.eliminar(Integer.parseInt(vCrud.getCrud().getA_id().getText()));

            }catch (Exception c){
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro recuerde ingresar un id", "ERROR", JOptionPane.ERROR_MESSAGE);

            }


        }else if(e.getActionCommand().equals("BUSCAR")){
            String aux = "";
            IempleadoDao dao = new EmpleadoDao();
            ArrayList<Empleado> filtro;
            System.out.println(vCrud.getCrud().getCombo().getSelectedItem().toString());
            if (vCrud.getCrud().getTpo_doc().getSelectedItem().toString().equals("Seleccione documento")){
                System.out.println("entro al if");
               filtro = dao.listaDeBusqueda(vCrud.getCrud().getCombo().getSelectedItem().toString(),vCrud.getCrud().getA_buscar().getText());
                for (int i = 0; i<filtro.size();i++){
                    //System.out.println("A "+emps.get(-1).getId());
                    aux = aux +(filtro.get(i).getId()+"|"+filtro.get(i).getTpo_documento()+"|"+filtro.get(i).getDocumento_cotizante()+"|"+filtro.get(i).getNombre_cotizante()+"|"+filtro.get(i).getId_cargo()+"|"+filtro.get(i).getSalario_basico()+"|"+filtro.get(i).isEstado()+"\n");
                }
                vCrud.getCrud().getMostrar().setText(aux);
            }else {
                //dao.listaDeBusqueda(vCrud.getCrud().getCombo().getSelectedItem().toString(),vCrud.getCrud().getTpo_doc().getSelectedItem().toString());
                filtro = dao.listaDeBusqueda(vCrud.getCrud().getCombo().getSelectedItem().toString(),vCrud.getCrud().getTpo_doc().getSelectedItem().toString());
                Collections.sort(filtro, new Comparator<Empleado>() {
                    @Override
                    public int compare(Empleado p1, Empleado p2) {
                        return new Integer(p1.getId()).compareTo(new Integer(p2.getId()));
                    }
                });
                for (int i = 0; i<filtro.size();i++){
                    //System.out.println("A "+emps.get(-1).getId());
                    aux = aux +(filtro.get(i).getId()+"|"+filtro.get(i).getTpo_documento()+"|"+filtro.get(i).getDocumento_cotizante()+"|"+filtro.get(i).getNombre_cotizante()+"|"+filtro.get(i).getId_cargo()+"|"+filtro.get(i).getSalario_basico()+"|"+filtro.get(i).isEstado()+"\n");
                }
                vCrud.getCrud().getMostrar().setText(aux);
            }
        }else if (e.getActionCommand().equals("AGREGARTABLAS")){
            //Terminar de configurar el obejrto empleado tomando los valores de los jtext area de verdad osea de la clase tablas para terminar de completar el objeto que solo esta e lprimer campo que es el id.
            ArrayList<Empleado> emps;
            ArrayList<cargo_empleado> car;
            String res = "El empleado añadido fue: \n ";
            IempleadoDao dao = new EmpleadoDao();
            emps = dao.listaDeEmpleados();
            Collections.sort(emps, new Comparator<Empleado>() {
                @Override
                public int compare(Empleado p1, Empleado p2) {
                    return new Integer(p1.getId()).compareTo(new Integer(p2.getId()));
                }
            });
            Icargo_empleadoDao daoC = new cargo_empleadoDao();
            car = daoC.listaDeCargos();
            int temp = 0;
            for (int i = 0; i<car.size();i++){
                if (car.get(i).getDescripcion().equals(vTablas.getTablas().getCargo().getSelectedItem().toString())){
                    temp = car.get(i).getId();
                    break;
                }
            }
            Empleado empleadoAgregar = new Empleado((emps.get(emps.size()-1).getId()+1),vTablas.getTablas().getTpo_documento().getSelectedItem().toString(),vTablas.getTablas().getA_documento_cotizante().getText(),vTablas.getTablas().getA_nombre_cotizante().getText(),temp,vTablas.getTablas().getA_salario_basico().getText(),true);
            //id,id_tpo_cotizante, id_subtpo_cotizante,id_empleado,periodo,periodo_salario,id_novedad,num_dias_trabajados,num_dias_incapacidad,num_dias_licencia,num_dias_permisos_remunerados,num_dias_permisos_no_remunerados,num_dias_vacaciones,num_dias_huelga,id_porcentaje_salud,id_porcentaje_pension
            try {
                obtenerId(empleadoAgregar.getId());
                obtenerSalario(Double.parseDouble(empleadoAgregar.getSalario_basico()));
                IempleadoDao dao2 = new EmpleadoDao();
                dao2.registrarEmpleado(empleadoAgregar);
                //System.out.println("A "+emps.get(-1).getId());
                res = res +(empleadoAgregar.getId()+"|"+empleadoAgregar.getTpo_documento()+"|"+empleadoAgregar.getDocumento_cotizante()+"|"+empleadoAgregar.getNombre_cotizante()+"|"+empleadoAgregar.getId_cargo()+"|"+empleadoAgregar.getSalario_basico()+"|"+empleadoAgregar.isEstado()+"\n");
                vTablas.getTablas().getResul().setText(res);
               } catch (Throwable ex) {
                JOptionPane.showMessageDialog(null, "No se pudo agregar el empleado recuerde ingresar un id", "ERROR", JOptionPane.ERROR_MESSAGE);
                //ex.printStackTrace();
            }
        }else if (e.getActionCommand().equals("NOMINA")){
            vTablas.getTablas().setVisible(false);
            vTablas.getNomina().setVisible(true);
            for (int i = 0; i<30;i++){
                vTablas.getNomina().getNum_dias_trabajados().addItem((i+1));
            }
            for (int j = 0;j<31;j++){
                vTablas.getNomina().getNum_dias_incapacidad().addItem(j);
                vTablas.getNomina().getNum_dias_licencia().addItem(j);
                vTablas.getNomina().getNum_dias_permisosR().addItem(j);
                vTablas.getNomina().getNum_dias_permisosNoR().addItem(j);
                vTablas.getNomina().getNum_dias_vacacciones().addItem(j);
                vTablas.getNomina().getNum_dias_huelga().addItem(j);
            }


        }else if(e.getActionCommand().equals("AGREGARNOMINA")){
            System.out.println("entroa a agregar");
            Idetalle_nominaDao daoNomina = new detalle_nominaDao();
            Iporcentaje_pensionDao daoPension = new porcentaje_pensionDao();
            Iporcentaje_saludDao daoSalud = new porcentaje_saludDao();
            int porcentaje = (int)((((int)salario)*4) / 100);

            String[] tpo_cotiz =vTablas.getNomina().getTpo_cotizante().getSelectedItem().toString().split("\\.");
            String[] subtpo =vTablas.getNomina().getSub_tpo_cotizante().getSelectedItem().toString().split("\\.");
            String[] novedad = vTablas.getNomina().getTpo_cotizante().getSelectedItem().toString().split("\\.");


            try {
                porcentaje_pension pPension = new porcentaje_pension(id,String.valueOf(porcentaje),true);
                porcentaje_salud pSalud = new porcentaje_salud(id,String.valueOf(porcentaje),true);
                detalle_nomina empNomina = new detalle_nomina(id,Integer.parseInt(tpo_cotiz[0]),Integer.parseInt(subtpo[0]),id,vTablas.getNomina().getPeriodo().getSelectedItem().toString(),vTablas.getNomina().getPeriodo_salario_minh().getSelectedItem().toString(),Integer.parseInt(novedad[0]),vTablas.getNomina().getNum_dias_trabajados().getSelectedItem().toString(),vTablas.getNomina().getNum_dias_incapacidad().getSelectedItem().toString(),vTablas.getNomina().getNum_dias_licencia().getSelectedItem().toString(),vTablas.getNomina().getNum_dias_permisosR().getSelectedItem().toString(),vTablas.getNomina().getNum_dias_permisosNoR().getSelectedItem().toString(),vTablas.getNomina().getNum_dias_vacacciones().getSelectedItem().toString(),vTablas.getNomina().getNum_dias_huelga().getSelectedItem().toString(),id,id);
                id = obtenerId(0);
                salario = obtenerSalario(0);
                daoPension.registrarPorcentaje_pension(pPension);
                daoSalud.registrarPorcentaje_salud(pSalud);
                daoNomina.registrarDetalle_nomina(empNomina);
            }catch (Exception k){

                JOptionPane.showMessageDialog(null, "No se pudo añadir el registro recuerde que debe primero registrar un empleado", "ERROR", JOptionPane.ERROR_MESSAGE);

            }

        }else if(e.getActionCommand().equals("EXCEL")){
            vPrincial.setVisible(false);
            vTablas.setVisible(false);
            vCrud.setVisible(true);
            vCrud.getCrud().setVisible(false);
            vCrud.getPanelExcel().setVisible(true);
        }else if (e.getActionCommand().equals("EXPORTAR")){
            ReadPostgresandExcel rExcel = new ReadPostgresandExcel();
           // rExcel.readPostgres(vCrud.getPanelExcel().getTablas().getSelectedItem().toString());
            if(vCrud.getPanelExcel().getTablas().getSelectedItem().toString().equals("empleado")){
                IempleadoDao daoEmpAux = new EmpleadoDao();
                ArrayList<Empleado> temp;
                temp = daoEmpAux.listaDeEmpleados();
                Collections.sort(temp, new Comparator<Empleado>() {
                    @Override
                    public int compare(Empleado p1, Empleado p2) {
                        return new Integer(p1.getId()).compareTo(new Integer(p2.getId()));
                    }
                });
                rExcel.escribirEmp(temp);
            }else if(vCrud.getPanelExcel().getTablas().getSelectedItem().toString().equals("detalle_nomina")){
                Idetalle_nominaDao nomDao = new detalle_nominaDao();
                ArrayList<detalle_nomina> auxnom;
                auxnom = nomDao.listaNomina();
                rExcel.escribirNom(auxnom);
            }else {
                JOptionPane.showMessageDialog(null, "Por favor seleccione una opción", "ERROR", JOptionPane.INFORMATION_MESSAGE);

            }
        }else if(e.getActionCommand().equals("MOSTRAREXPORTAR")){

            if (vCrud.getPanelExcel().getTablas().getSelectedItem().toString().equals("empleado")){
                IempleadoDao daoEmpAux = new EmpleadoDao();
                ArrayList<Empleado> temp;
                temp = daoEmpAux.listaDeEmpleados();
                String aux = "";
                for (int i = 0;i<temp.size();i++){
                    aux = aux +(temp.get(i).getId()+"|"+temp.get(i).getTpo_documento()+"|"+temp.get(i).getDocumento_cotizante()+"|"+temp.get(i).getNombre_cotizante()+"|"+temp.get(i).getId_cargo()+"|"+temp.get(i).getSalario_basico()+"|"+temp.get(i).isEstado()+"\n");
                }
                vCrud.getPanelExcel().getMostrar().setText(aux);
            }else if(vCrud.getPanelExcel().getTablas().getSelectedItem().toString().equals("detalle_nomina")){
                Idetalle_nominaDao dNominaDao = new detalle_nominaDao();
                ArrayList<detalle_nomina> dNom;
                dNom = dNominaDao.listaNomina();
                String t2 = "";
                for (int i = 0;i<dNom.size();i++){
                    t2 = t2 +(dNom.get(i).getId()+"|"+dNom.get(i).getId_tpo_cotizante()+"|"+dNom.get(i).getId_subtpo_cotizante()+"|"+dNom.get(i).getId_empleado()+"|"+dNom.get(i).getPeriodo()+"|"+dNom.get(i).getPeriodo_salario()+"|"+dNom.get(i).getId_novedad()
                            +"|"+dNom.get(i).getNum_dias_trabajados()+"|"+dNom.get(i).getNum_dias_incapacidad()+"|"+dNom.get(i).getNum_dias_licencia()+"|"+dNom.get(i).getNum_dias_permisos_remunerados()+"|"+dNom.get(i).getNum_dias_permisos_no_remunerados()+"|"+dNom.get(i).getNum_dias_vacaciones()+"|"+dNom.get(i).getNum_dias_huelga()
                            +"|"+dNom.get(i).getId_porcentaje_salud()+"|"+dNom.get(i).getId_porcentaje_pension()+"\n");
                }
                vCrud.getPanelExcel().getMostrar().setText(t2);

            }else {
                JOptionPane.showMessageDialog(null, "Por favor seleccione una opción", "ERROR", JOptionPane.INFORMATION_MESSAGE);

            }

        }
    }
    ArrayList<Integer> ids = new ArrayList<>();
    public int obtenerId(int id){
      if (id == 0){
         // System.out.println("es cero id "+id);
      }else {
          //System.out.println("no es cero int");
          ids.add(id);
      }
        return ids.get((ids.size()-1));
    }

    ArrayList<Double> salarios = new ArrayList<>();
    public Double obtenerSalario(double salario){
        if (salario == 0){
            //System.out.println("es cero double "+salario);
        }else {
            //System.out.println("no es cero double");
            salarios.add(salario);

        }

        return salarios.get((salarios.size()-1));
    }

}
