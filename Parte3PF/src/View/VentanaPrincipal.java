package View;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private PanelPrincipal principal;

    /*
     * Metodo Contructor de la clase VentanaPrincipal.
     */

    public VentanaPrincipal() {

        setTitle("Inicio");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.darkGray);

        inicializarComponentes();

        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /*
     * Metodo void que llama el panel correspondiente a el nombre de la ventana en
     * que se mostrara e inicializara los componentes de la misma.
     */
    public void inicializarComponentes() {

        principal = new PanelPrincipal();
        principal.setBounds(5, 5, 475, 350);
        principal.setOpaque(false);
        getContentPane().add(principal);

    }

    public PanelPrincipal getPrincipal() {
        return principal;
    }

    public void setPrincipal(PanelPrincipal principal) {
        this.principal = principal;
    }

}
