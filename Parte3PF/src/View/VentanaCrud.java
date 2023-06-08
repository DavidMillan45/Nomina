package View;

import javax.swing.*;
import java.awt.*;

public class VentanaCrud extends JFrame {

    private PanelCrud crud;
    private PanelExcel panelExcel;

    public VentanaCrud() {

        setTitle("Crud");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.darkGray);

        inicializarComponentes();

        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(false);
    }

    public void inicializarComponentes() {

        crud = new PanelCrud();
        crud.setBounds(5, 5, 875, 650);
        crud.setOpaque(false);
        getContentPane().add(crud);

        panelExcel = new PanelExcel();
        panelExcel.setBounds(5, 5, 875, 650);
        panelExcel.setOpaque(false);
        setVisible(false);
        getContentPane().add(panelExcel);

    }

    public PanelCrud getCrud() {
        return crud;
    }

    public PanelExcel getPanelExcel() {
        return panelExcel;
    }
}
