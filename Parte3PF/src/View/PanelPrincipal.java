package View;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PanelPrincipal extends JPanel {

    private JLabel e_titulo;
    private JButton b_añadir, b_crud, b_excel;

    /*
     * Metodo Contructor de la clase PanelPrincipal.
     */
    public PanelPrincipal() {

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

        e_titulo = new JLabel("Seleccione una opcion");
        e_titulo.setForeground(Color.white);
        e_titulo.setFont(new Font("Algerian", 15, 25));
        e_titulo.setBounds(100, 40, 350, 45);
        add(e_titulo);

        b_añadir = new JButton("Añadir");
        b_añadir.setActionCommand("AÑADIR");
        b_añadir.setBounds(160, 100, 155, 30);
        b_añadir.setBackground(Color.white);
        add(b_añadir);

        b_crud = new JButton("Crud");
        b_crud.setActionCommand("CRUD");
        b_crud.setBounds(160, 160, 155, 30);
        b_crud.setBackground(Color.white);
        add(b_crud);

        b_excel = new JButton("Excel");
        b_excel.setActionCommand("EXCEL");
        b_excel.setBounds(160, 220, 155, 30);
        b_excel.setBackground(Color.white);
        add(b_excel);



    }

    public JLabel getE_titulo() {
        return e_titulo;
    }

    public void setE_titulo(JLabel e_titulo) {
        this.e_titulo = e_titulo;
    }

    public JButton getB_añadir() {
        return b_añadir;
    }

    public void setB_añadir(JButton b_añadir) {
        this.b_añadir = b_añadir;
    }

    public JButton getB_crud() {
        return b_crud;
    }

    public JButton getB_excel() {
        return b_excel;
    }
}

