package View;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PanelTablas extends JPanel {

    private JLabel e_titulo,e_ingresarDats;
    private TextPrompt textPrompt;
    private JButton b_agregar,b_volver,b_nomina;
    private JComboBox cargo, tpo_documento;
    private JScrollPane scroll;
    private JTextArea a_documento_cotizante,a_nombre_cotizante,a_salario_basico,resul;

    /*
     * Metodo Contructor de la clase PanelPrincipal.
     */
    public PanelTablas() {

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

        e_titulo = new JLabel("Agregar empleado");
        e_titulo.setForeground(Color.white);
        e_titulo.setFont(new Font("Algerian", 15, 25));
        e_titulo.setBounds(106, 10, 350, 45);
        add(e_titulo);

        e_ingresarDats = new JLabel("Ingresar datos del nuevo empleado");
        e_ingresarDats.setForeground(Color.white);
        e_ingresarDats.setFont(new Font("Algerian", 15, 15));
        e_ingresarDats.setBounds(5, 40, 400, 45);
        add(e_ingresarDats);

        cargo = new JComboBox();
        cargo.addItem("Seleccione cargo");
        cargo.setActionCommand("CARGO");
        cargo.setBounds(5, 75, 200, 25);//490
        add(cargo);

        tpo_documento = new JComboBox();
        tpo_documento.addItem("Seleccione documento");
        tpo_documento.addItem("CC");
        tpo_documento.addItem("CE");
        tpo_documento.addItem("NI");
        tpo_documento.setBounds(5, 110, 200, 25);
        add(tpo_documento);

        a_documento_cotizante = new JTextArea();
        textPrompt = new TextPrompt("Numero documento",a_documento_cotizante);
        a_documento_cotizante.setEditable(true);
        a_documento_cotizante.setBounds(5, 145, 200, 25);
        add(a_documento_cotizante);

        a_nombre_cotizante = new JTextArea();
        textPrompt = new TextPrompt("Nombre",a_nombre_cotizante);
        a_nombre_cotizante.setBounds(5, 180, 200, 25);
        add(a_nombre_cotizante);

        a_salario_basico = new JTextArea();
        textPrompt = new TextPrompt("salario_básico",a_salario_basico);
        a_salario_basico.setEditable(true);
        a_salario_basico.setBounds(5, 215, 200, 25);
        add(a_salario_basico);

        b_agregar = new JButton("Agregar");
        b_agregar.setActionCommand("AGREGARTABLAS");
        b_agregar.setBounds(5, 250, 100, 35);
        add(b_agregar);

        resul = new JTextArea();
        resul.setEditable(false);
        resul.setBounds(240, 75, 200, 220);
        scroll = new JScrollPane(resul);
        scroll.setBounds(240, 75, 200, 220);
        add(scroll);

        b_volver = new JButton("Regresar");
        b_volver.setActionCommand("VOLVERTABLAS");
        b_volver.setBounds(360, 305, 100, 35);
        add(b_volver);

        b_nomina = new JButton("Agregar a nomina");
        b_nomina.setActionCommand("NOMINA");
        b_nomina.setBounds(5, 305, 170, 35);
        add(b_nomina);


    }

    public JButton getB_agregar() {
        return b_agregar;
    }

    public void setB_agregar(JButton b_agregar) {
        this.b_agregar = b_agregar;
    }

    public JComboBox getCargo() {
        return cargo;
    }

    public void setCargo(JComboBox cargo) {
        this.cargo = cargo;
    }

    public JButton getB_volver() {
        return b_volver;
    }

    public void setB_volver(JButton b_volver) {
        this.b_volver = b_volver;
    }

    public JComboBox getTpo_documento() {
        return tpo_documento;
    }

    public void setTpo_documento(JComboBox tpo_documento) {
        this.tpo_documento = tpo_documento;
    }

    public JTextArea getA_documento_cotizante() {
        return a_documento_cotizante;
    }

    public JTextArea getA_nombre_cotizante() {
        return a_nombre_cotizante;
    }

    public JTextArea getA_salario_basico() {
        return a_salario_basico;
    }

    public JTextArea getResul() {
        return resul;
    }

    public JButton getB_nomina() {
        return b_nomina;
    }
}

