package Entidad;

public class detalle_nomina {

    private int id;
    private int id_tpo_cotizante;
    private int id_subtpo_cotizante;
    private int id_empleado;
    private String periodo;
    private String periodo_salario;
    private int id_novedad;
    private String num_dias_trabajados;
    private String num_dias_incapacidad ;
    private String num_dias_licencia;
    private String num_dias_permisos_remunerados;
    private String num_dias_permisos_no_remunerados;
    private String num_dias_vacaciones;
    private String num_dias_huelga;
    private int id_porcentaje_salud;
    private int id_porcentaje_pension;

    public detalle_nomina(){

    }

    public detalle_nomina(int id, int id_tpo_cotizante, int id_subtpo_cotizante, int id_empleado, String periodo, String periodo_salario, int id_novedad, String num_dias_trabajados, String num_dias_incapacidad, String num_dias_licencia, String num_dias_permisos_remunerados, String num_dias_permisos_no_remunerados, String num_dias_vacaciones, String num_dias_huelga, int id_porcentaje_salud, int id_porcentaje_pension) {
        this.id = id;
        this.id_tpo_cotizante = id_tpo_cotizante;
        this.id_subtpo_cotizante = id_subtpo_cotizante;
        this.id_empleado = id_empleado;
        this.periodo = periodo;
        this.periodo_salario = periodo_salario;
        this.id_novedad = id_novedad;
        this.num_dias_trabajados = num_dias_trabajados;
        this.num_dias_incapacidad = num_dias_incapacidad;
        this.num_dias_licencia = num_dias_licencia;
        this.num_dias_permisos_remunerados = num_dias_permisos_remunerados;
        this.num_dias_permisos_no_remunerados = num_dias_permisos_no_remunerados;
        this.num_dias_vacaciones = num_dias_vacaciones;
        this.num_dias_huelga = num_dias_huelga;
        this.id_porcentaje_salud = id_porcentaje_salud;
        this.id_porcentaje_pension = id_porcentaje_pension;
    }

    public int getId_tpo_cotizante() {
        return id_tpo_cotizante;
    }

    public void setId_tpo_cotizante(int id_tpo_cotizante) {
        this.id_tpo_cotizante = id_tpo_cotizante;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getPeriodo_salario() {
        return periodo_salario;
    }

    public void setPeriodo_salario(String periodo_salario) {
        this.periodo_salario = periodo_salario;
    }

    public int getId_novedad() {
        return id_novedad;
    }

    public void setId_novedad(int id_novedad) {
        this.id_novedad = id_novedad;
    }

    public String getNum_dias_trabajados() {
        return num_dias_trabajados;
    }

    public void setNum_dias_trabajados(String num_dias_trabajados) {
        this.num_dias_trabajados = num_dias_trabajados;
    }

    public String getNum_dias_incapacidad() {
        return num_dias_incapacidad;
    }

    public void setNum_dias_incapacidad(String num_dias_incapacidad) {
        this.num_dias_incapacidad = num_dias_incapacidad;
    }

    public String getNum_dias_licencia() {
        return num_dias_licencia;
    }

    public void setNum_dias_licencia(String num_dias_licencia) {
        this.num_dias_licencia = num_dias_licencia;
    }

    public String getNum_dias_permisos_remunerados() {
        return num_dias_permisos_remunerados;
    }

    public void setNum_dias_permisos_remunerados(String num_dias_permisos_remunerados) {
        this.num_dias_permisos_remunerados = num_dias_permisos_remunerados;
    }

    public String getNum_dias_permisos_no_remunerados() {
        return num_dias_permisos_no_remunerados;
    }

    public void setNum_dias_permisos_no_remunerados(String num_dias_permisos_no_remunerados) {
        this.num_dias_permisos_no_remunerados = num_dias_permisos_no_remunerados;
    }

    public String getNum_dias_vacaciones() {
        return num_dias_vacaciones;
    }

    public void setNum_dias_vacaciones(String num_dias_vacaciones) {
        this.num_dias_vacaciones = num_dias_vacaciones;
    }

    public String getNum_dias_huelga() {
        return num_dias_huelga;
    }

    public void setNum_dias_huelga(String num_dias_huelga) {
        this.num_dias_huelga = num_dias_huelga;
    }

    public int getId_porcentaje_salud() {
        return id_porcentaje_salud;
    }

    public void setId_porcentaje_salud(int id_porcentaje_salud) {
        this.id_porcentaje_salud = id_porcentaje_salud;
    }

    public int getId_porcentaje_pension() {
        return id_porcentaje_pension;
    }

    public void setId_porcentaje_pension(int id_porcentaje_pension) {
        this.id_porcentaje_pension = id_porcentaje_pension;
    }

    public int getId_subtpo_cotizante() {
        return id_subtpo_cotizante;
    }

    public void setId_subtpo_cotizante(int id_subtpo_cotizante) {
        this.id_subtpo_cotizante = id_subtpo_cotizante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
