package Daos;


import Entidad.Empleado;
import Entidad.cargo_empleado;

import java.util.ArrayList;

public interface Icargo_empleadoDao {

    public boolean registrarCargo_empleado(cargo_empleado Cargo_empleado);
    public ArrayList<cargo_empleado> listaDeCargos();

}
