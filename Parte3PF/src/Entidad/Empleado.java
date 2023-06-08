package Entidad;

public class Empleado {

    private int id;
    private String tpo_documento;
    private String documento_cotizante;
    private String nombre_cotizante;
    private int id_cargo;
    private String nom_cargo;
    private String salario_basico;
    private boolean estado;

    public Empleado(){

    }

    public Empleado(int id, String tpo_documento, String documento_cotizante, String nombre_cotizante, int id_cargo, String salario_basico, boolean estado) {
        this.id = id;
        this.tpo_documento = tpo_documento;
        this.documento_cotizante = documento_cotizante;
        this.nombre_cotizante = nombre_cotizante;
        this.id_cargo = id_cargo;
        this.salario_basico = salario_basico;
        this.estado = estado;
    }

    public Empleado(int id, String tpo_documento, String documento_cotizante, String nombre_cotizante, String nom_cargo, String salario_basico, boolean estado) {
        this.id = id;
        this.tpo_documento = tpo_documento;
        this.documento_cotizante = documento_cotizante;
        this.nombre_cotizante = nombre_cotizante;
        this.nom_cargo = nom_cargo;
        this.salario_basico = salario_basico;
        this.estado = estado;
    }

    public String getTpo_documento() {
        return tpo_documento;
    }

    public void setTpo_documento(String tpo_documento) {
        this.tpo_documento = tpo_documento;
    }

    public String getDocumento_cotizante() {
        return documento_cotizante;
    }

    public void setDocumento_cotizante(String documento_cotizante) {
        this.documento_cotizante = documento_cotizante;
    }

    public String getNombre_cotizante() {
        return nombre_cotizante;
    }

    public void setNombre_cotizante(String nombre_cotizante) {
        this.nombre_cotizante = nombre_cotizante;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public String getSalario_basico() {
        return salario_basico;
    }

    public void setSalario_basico(String salario_basico) {
        this.salario_basico = salario_basico;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_cargo() {
        return nom_cargo;
    }
}
