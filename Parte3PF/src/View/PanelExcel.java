package View;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PanelExcel extends JPanel {

    private JLabel e_titulo, e_info;
    private JButton b_convertir_excel, b_volver, b_mostrar_tabla;
    private JTextArea mostrar;
    private JScrollPane scroll;
    private JComboBox tablas;


    public PanelExcel() {

        setLayout(null);
        inicializarComponentes();
    }

    /*
     * Metodo void que inicializa los componentes y/o atributos que se utilizaran y
     * visualizarán en el panel.
     */
    public void inicializarComponentes() {

        setBackground(new Color(222, 222, 222));
        setBorder(new LineBorder(new Color(200, 213, 210)));

        e_titulo = new JLabel("Tabla que desee visualizar en excel");
        e_titulo.setForeground(Color.white);
        e_titulo.setFont(new Font("Algerian", 15, 30));
        e_titulo.setBounds(35, 25, 700, 60);
        add(e_titulo);

        e_info = new JLabel("Seleccione tabla exportar");
        e_info.setForeground(Color.white);
        e_info.setFont(new Font("Algerian", 15, 15));
        e_info.setBounds(560, 200, 300, 35);
        add(e_info);

        tablas = new JComboBox();
        tablas.addItem("Seleccione tabla");
        tablas.addItem("empleado");
        tablas.addItem("detalle_nomina");
        tablas.setBounds(600, 250, 200, 25);
        add(tablas);

        b_mostrar_tabla = new JButton("Mostrar tabla");
        b_mostrar_tabla.setActionCommand("MOSTRAREXPORTAR");
        b_mostrar_tabla.setBounds(600, 290, 180, 35);
        add(b_mostrar_tabla);

        b_convertir_excel = new JButton("Exportar");
        b_convertir_excel.setActionCommand("EXPORTAR");
        b_convertir_excel.setBounds(600, 350, 180, 35);
        add(b_convertir_excel);

        mostrar = new JTextArea();
        mostrar.setEditable(false);
        mostrar.setBounds(35, 100, 500, 500);
        scroll = new JScrollPane(mostrar);
        scroll.setBounds(35, 100, 500, 500);
        add(scroll);

        b_volver = new JButton("Regresar");
        b_volver.setActionCommand("VOLVER");
        b_volver.setBounds(761, 610, 100, 35);
        add(b_volver);

    }

    public JLabel getE_titulo() {
        return e_titulo;
    }

    public void setE_titulo(JLabel e_titulo) {
        this.e_titulo = e_titulo;
    }

    public JTextArea getMostrar() {
        return mostrar;
    }

    public void setMostrar(JTextArea mostrar) {
        this.mostrar = mostrar;
    }

    public JButton getB_volver() {
        return b_volver;
    }

    public void setB_volver(JButton b_volver) {
        this.b_volver = b_volver;
    }

    public JButton getB_convertir_excel() {
        return b_convertir_excel;
    }

    public JComboBox getTablas() {
        return tablas;
    }

    public JButton getB_mostrar_tabla() {
        return b_mostrar_tabla;
    }
}

