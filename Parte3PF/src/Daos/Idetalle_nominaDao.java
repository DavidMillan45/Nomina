package Daos;

import Entidad.Empleado;
import Entidad.detalle_nomina;

import java.util.ArrayList;

public interface Idetalle_nominaDao {

    public boolean registrarDetalle_nomina(detalle_nomina detalle_nomina);
    public ArrayList<detalle_nomina> listaNomina();

}
