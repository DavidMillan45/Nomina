package View;

import javax.swing.*;
import java.awt.*;

public class VentanaTablas extends JFrame {

    private PanelTablas tablas;
    private PanelNomina nomina;


    /*
     * Metodo Contructor de la clase VentanaPrincipal.
     */

    public VentanaTablas() {

        setTitle("Tablas");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.darkGray);

        inicializarComponentes();

        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(false);
    }

    public PanelTablas getTablas() {
        return tablas;
    }

    public void setTablas(PanelTablas tablas) {
        this.tablas = tablas;
    }

    public PanelNomina getNomina() {
        return nomina;
    }

    public void inicializarComponentes() {

        tablas = new PanelTablas();
        tablas.setBounds(5, 5, 475, 350);
        tablas.setOpaque(false);
        getContentPane().add(tablas);

        nomina = new PanelNomina();
        nomina.setBounds(5, 5, 475, 350);
        nomina.setOpaque(false);
        nomina.setVisible(false);
        getContentPane().add(nomina);



    }



}
