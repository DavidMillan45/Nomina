package View;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PanelNomina extends JPanel {

    private JLabel e_titulo,e_ingresarDats;
    private TextPrompt textPrompt;
    private JButton b_agregar,b_volver;
    private JComboBox tpo_cotizante, sub_tpo_cotizante,periodo,periodo_salario_minh,tpo_novedad,num_dias_trabajados,num_dias_incapacidad,num_dias_licencia,num_dias_permisosR,num_dias_permisosNoR,num_dias_vacacciones,num_dias_huelga;

    public PanelNomina() {

        setLayout(null);
        textPrompt = new TextPrompt();
        inicializarComponentes();
    }

    /*
     * Metodo void que inicializa los componentes y/o atributos que se utilizaran y
     * visualizarán en el panel.
     */
    public void inicializarComponentes() {

        setBackground(new Color(222, 222, 222));
        setBorder(new LineBorder(new Color(200, 213, 210)));

        e_titulo = new JLabel("Agregar empleado a nomina");
        e_titulo.setForeground(Color.white);
        e_titulo.setFont(new Font("Algerian", 15, 25));
        e_titulo.setBounds(35, 10, 400, 45);
        add(e_titulo);

        e_ingresarDats = new JLabel("Ingresar datos para añadir a nomina");
        e_ingresarDats.setForeground(Color.white);
        e_ingresarDats.setFont(new Font("Algerian", 15, 15));
        e_ingresarDats.setBounds(5, 40, 400, 45);
        add(e_ingresarDats);

        tpo_cotizante = new JComboBox();
        tpo_cotizante.addItem("Seleccione tpo cotizante");
        tpo_cotizante.addItem("1.Dependiente Pensionado");
        tpo_cotizante.addItem("2.Independiente Pensionado");
        tpo_cotizante.addItem("3.Cotizante no obligado a pagar pensión");
        tpo_cotizante.addItem("4.Cotizante");
        tpo_cotizante.addItem("5.Independiente");
        tpo_cotizante.addItem("6.Contratista");
        tpo_cotizante.setBounds(5, 75, 200, 25);//490
        add(tpo_cotizante);

        sub_tpo_cotizante = new JComboBox();
        sub_tpo_cotizante.addItem("Seleccione subtpocotizante");
        sub_tpo_cotizante.addItem("1.Dependiente Pensionado");
        sub_tpo_cotizante.addItem("2.Independiente Pensionado");
        sub_tpo_cotizante.addItem("3.Cotizante no obligado a pagar pensión");
        sub_tpo_cotizante.addItem("4.Cotizante");
        sub_tpo_cotizante.addItem("5.Independiente");
        sub_tpo_cotizante.addItem("6.Contratista");
        sub_tpo_cotizante.addItem("9.Cotizante pensionado mesada");
        sub_tpo_cotizante.addItem("10.Residente en el exterior");
        sub_tpo_cotizante.addItem("11.Conductores");
        sub_tpo_cotizante.addItem("12.Conductores no obligados");
        sub_tpo_cotizante.setBounds(5, 110, 200, 25);
        add(sub_tpo_cotizante);

        periodo = new JComboBox();
        periodo.addItem("Seleccione periodo");
        periodo.addItem("2018");
        periodo.addItem("2018");
        periodo.addItem("2019");
        periodo.addItem("2020");
        periodo.addItem("2021");
        periodo.setBounds(5, 145, 200, 25);
        add(periodo);

        periodo_salario_minh = new JComboBox();
        periodo_salario_minh.addItem("Seleccione Periodo SMMLV");
        periodo_salario_minh.addItem("2018");
        periodo_salario_minh.addItem("2019");
        periodo_salario_minh.addItem("2020");
        periodo_salario_minh.addItem("2021");
        periodo_salario_minh.setBounds(5, 180, 200, 25);
        add(periodo_salario_minh);

        tpo_novedad = new JComboBox();
        tpo_novedad.addItem("Seleccione tpo novedad");
        tpo_novedad.addItem("0.Sin novedad");
        tpo_novedad.addItem("1.VACACIONES");
        tpo_novedad.addItem("2.INCAPACIDAD");
        tpo_novedad.addItem("3.Licencia remunerada");
        tpo_novedad.addItem("4.Licencia de Maternidad");
        tpo_novedad.addItem("5.Enfermedad");
        tpo_novedad.setBounds(5, 215, 200, 25);
        add(tpo_novedad);

        num_dias_trabajados = new JComboBox();
        num_dias_trabajados.addItem("Num_dias_trabajados");
        num_dias_trabajados.setBounds(5, 250, 200, 25);
        add(num_dias_trabajados);

        num_dias_incapacidad = new JComboBox();
        num_dias_incapacidad.addItem("Num_dias_incapacidad");
        num_dias_incapacidad.setBounds(5, 285, 200, 25);
        add(num_dias_incapacidad);
//,,,,
        num_dias_licencia = new JComboBox();
        num_dias_licencia.addItem("Num_dias_licencia");
        num_dias_licencia.setBounds(250, 75, 200, 25);
        add(num_dias_licencia);

        num_dias_permisosR = new JComboBox();
        num_dias_permisosR.addItem("Num_dias_permisosR");
        num_dias_permisosR.setBounds(250, 110, 200, 25);
        add(num_dias_permisosR);

        num_dias_permisosNoR = new JComboBox();
        num_dias_permisosNoR.addItem("Num_dias_permisosNoR");
        num_dias_permisosNoR.setBounds(250, 145, 200, 25);
        add(num_dias_permisosNoR);

        num_dias_vacacciones = new JComboBox();
        num_dias_vacacciones.addItem("Num_dias_vacacciones");
        num_dias_vacacciones.setBounds(250, 180, 200, 25);
        add(num_dias_vacacciones);

        num_dias_huelga = new JComboBox();
        num_dias_huelga.addItem("Num_dias_huelga");
        num_dias_huelga.setBounds(250, 215, 200, 25);
        add(num_dias_huelga);

        b_agregar = new JButton("Agregar");
        b_agregar.setActionCommand("AGREGARNOMINA");
        b_agregar.setBounds(250, 250, 100, 30);
        add(b_agregar);


        b_volver = new JButton("Regresar");
        b_volver.setActionCommand("VOLVERTABLAS");
        b_volver.setBounds(360, 305, 100, 35);
        add(b_volver);


    }

    public JButton getB_agregar() {
        return b_agregar;
    }

    public void setB_agregar(JButton b_agregar) {
        this.b_agregar = b_agregar;
    }

    public JComboBox getTpo_cotizante() {
        return tpo_cotizante;
    }

    public void setTpo_cotizante(JComboBox tpo_cotizante) {
        this.tpo_cotizante = tpo_cotizante;
    }

    public JButton getB_volver() {
        return b_volver;
    }

    public void setB_volver(JButton b_volver) {
        this.b_volver = b_volver;
    }

    public JComboBox getSub_tpo_cotizante() {
        return sub_tpo_cotizante;
    }

    public JComboBox getPeriodo() {
        return periodo;
    }

    public JComboBox getNum_dias_trabajados() {
        return num_dias_trabajados;
    }

    public JComboBox getNum_dias_incapacidad() {
        return num_dias_incapacidad;
    }

    public JComboBox getNum_dias_licencia() {
        return num_dias_licencia;
    }

    public JComboBox getNum_dias_permisosR() {
        return num_dias_permisosR;
    }

    public JComboBox getNum_dias_permisosNoR() {
        return num_dias_permisosNoR;
    }

    public JComboBox getNum_dias_vacacciones() {
        return num_dias_vacacciones;
    }

    public JComboBox getNum_dias_huelga() {
        return num_dias_huelga;
    }

    public JComboBox getPeriodo_salario_minh() {
        return periodo_salario_minh;
    }
}

