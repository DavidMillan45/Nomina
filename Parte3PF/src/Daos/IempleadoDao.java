package Daos;

import Entidad.Empleado;
import Entidad.detalle_nomina;

import java.util.ArrayList;

public interface IempleadoDao {

    public boolean registrarEmpleado(Empleado emp) throws Throwable;
    public ArrayList<Empleado> listaDeEmpleados();
    public ArrayList<Empleado> listaDeBusqueda(String a, String b);
    public boolean actualizar(Empleado emp,String columna);
    public boolean eliminar(int id);


}
