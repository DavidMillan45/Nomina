package View;

import javax.swing.*;

public class Menu extends JFrame {

    private JButton[] botones = new JButton[6];

    public Menu() {
        setTitle("MENU");
        setSize(350,400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicializarComponentes();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void inicializarComponentes() {
        /*botones[0] = new JButton("Lanzar datos a MySql");
        botones[0].setBounds(90, 30, 160, 27);
        botones[0].addActionListener(evt -> Controller.opcionesMenu(1, 0));
        getContentPane().add(botones[0]);

        botones[1] = new JButton("Crear Csv's normalizados extraídos de MySql");
        botones[1].setBounds(20, 80, 291, 27);
        botones[1].addActionListener(evt -> Controller.opcionesMenu(2, 0));
        getContentPane().add(botones[1]);

        botones[2] = new JButton("Lanzar datos al PostgresQl");
        botones[2].setBounds(70, 130, 200, 27);
        botones[2].addActionListener(evt -> Controller.opcionesMenu(3, 0));
        getContentPane().add(botones[2]);

        botones[3] = new JButton("CRUD");
        botones[3].setBounds(115, 180, 122, 27);
        botones[3].addActionListener(evt -> Controller.opcionesMenu(4,0));
        getContentPane().add(botones[3]);

        botones[4] = new JButton("Consulta general");
        botones[4].setBounds(105, 230, 140, 27);
        botones[4].addActionListener(evt -> Controller.opcionesMenu(5, 0));
        getContentPane().add(botones[4]);

        botones[5] = new JButton("Salir");
        botones[5].setBounds(115, 280, 122, 27);
        botones[5].addActionListener(evt -> Controller.opcionesMenu(6, 0));
        getContentPane().add(botones[5]);*/
    }
}