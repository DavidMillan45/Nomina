package View;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PanelCrud extends JPanel {

    private JLabel e_titulo,e_id,eliminar, buscar,añadir;
    private JButton b_eliminar, b_buscar,b_añadir,b_refresh,b_combo,b_iractualizar,b_volver;
    private JTextArea mostrar,a_id, a_buscar,a_añadir;
    private JScrollPane scroll;
    private JComboBox combo,tpo_doc,cargo,tpo_doc2,combo2;
    private TextPrompt textPrompt;


    public PanelCrud() {

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

        e_titulo = new JLabel("Operaciones crud");
        e_titulo.setForeground(Color.white);
        e_titulo.setFont(new Font("Algerian", 15, 40));
        e_titulo.setBounds(35, 25, 500, 60);
        add(e_titulo);

        e_id = new JLabel("Ingrese id:");
        e_id.setForeground(Color.white);
        e_id.setFont(new Font("Algerian", 15, 17));
        e_id.setBounds(540, 85, 500, 60);
        add(e_id);

        a_id = new JTextArea();
        a_id.setEditable(true);
        a_id.setBounds(644, 105, 70, 20);
        add(a_id);

        eliminar = new JLabel("Eliminar empleado con el id seleccionado ");
        eliminar.setForeground(Color.white);
        eliminar.setFont(new Font("Algerian", 15, 15));
        eliminar.setBounds(540, 150, 500, 60);
        add(eliminar);

        b_eliminar = new JButton("Eliminar");
        b_eliminar.setActionCommand("ELIMINAR");
        b_eliminar.setBounds(540, 200, 100, 35);
        add(b_eliminar);

        buscar = new JLabel("<html><body>Seleccione una de las siguientes opciones <br>para filtrar en el registro</body></html>");
        buscar.setForeground(Color.white);
        buscar.setFont(new Font("Algerian", 15, 15));
        buscar.setBounds(540, 265, 500, 60);
        add(buscar);

        combo = new JComboBox();
        combo.addItem("Seleccione criterio");
        combo.addItem("Nombre");
        combo.addItem("Detalle");
        combo.addItem("Cantidad");
        combo.addItem("Costo");
        combo.setActionCommand("COMBO");
        combo.setBounds(540, 320, 200, 25);
        add(combo);

        b_combo = new JButton("Ir");
        b_combo.setActionCommand("SELECCIONAR");
        b_combo.setBounds(750, 320, 45, 25);
        add(b_combo);

        tpo_doc = new JComboBox();
        tpo_doc.addItem("Seleccione documento");
        tpo_doc.addItem("CC");
        tpo_doc.addItem("CE");
        tpo_doc.addItem("NI");
        tpo_doc.setVisible(false);
        tpo_doc.setActionCommand("TIPO_ID");
        tpo_doc.setBounds(540, 355, 200, 25);
        add(tpo_doc);

        a_buscar = new JTextArea();
        textPrompt = new TextPrompt("Digite criterio",a_buscar);
        a_buscar.setEditable(true);
        a_buscar.setVisible(false);
        a_buscar.setBounds(540, 355, 200, 25);
        add(a_buscar);

        b_buscar = new JButton("Buscar");
        b_buscar.setActionCommand("BUSCAR");
        b_buscar.setBounds(540, 395, 100, 35);
        add(b_buscar);

        añadir = new JLabel("Actualizar empleado");
        añadir.setForeground(Color.white);
        añadir.setFont(new Font("Algerian", 15, 15));
        añadir.setBounds(540, 425, 500, 60);
        add(añadir);

        combo2 = new JComboBox();
        combo2.addItem("Tipo de documento");
        combo2.addItem("Numero de documento");
        combo2.addItem("Nombre");
        combo2.addItem("Cargo");
        combo2.addItem("Salario básico");
        combo2.setActionCommand("COMBO");
        combo2.setBounds(540, 470, 200, 25);
        add(combo2);

        b_iractualizar = new JButton("Ir");
        b_iractualizar.setActionCommand("IR");
        b_iractualizar.setBounds(750, 470, 45, 25);
        add(b_iractualizar);

        tpo_doc2 = new JComboBox();
        tpo_doc2.addItem("CC");
        tpo_doc2.addItem("CE");
        tpo_doc2.addItem("NI");
        tpo_doc2.setActionCommand("TIPO_ID");
        tpo_doc2.setVisible(false);
        tpo_doc2.setBounds(540, 505, 200, 25);//490
        add(tpo_doc2);

        cargo = new JComboBox();
        cargo.addItem("Seleccione cargo");
        cargo.setActionCommand("CARGO");
        cargo.setVisible(false);
        cargo.setBounds(540, 505, 200, 25);//490
        add(cargo);

        a_añadir = new JTextArea();
        textPrompt = new TextPrompt("Inserte dato para actualizar",a_añadir);
        a_añadir.setEditable(true);
        a_añadir.setVisible(false);
        a_añadir.setBounds(540, 505, 200, 25);
        add(a_añadir);

        b_añadir = new JButton("Actualizar");
        b_añadir.setActionCommand("ACTUALIZAR");
        b_añadir.setBounds(540, 545, 100, 35);
        add(b_añadir);

        b_refresh = new JButton("Recargar empleados");
        b_refresh.setActionCommand("REFRESH");
        b_refresh.setBounds(35, 610, 180, 35);
        add(b_refresh);

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


    public JComboBox getCombo() {
        return combo;
    }

    public void setCombo(JComboBox combo) {
        this.combo = combo;
    }

    public JComboBox getTpo_doc() {
        return tpo_doc;
    }

    public void setTpo_doc(JComboBox tpo_doc) {
        this.tpo_doc = tpo_doc;
    }

    public JButton getB_eliminar() {
        return b_eliminar;
    }

    public void setB_eliminar(JButton b_eliminar) {
        this.b_eliminar = b_eliminar;
    }

    public JButton getB_buscar() {
        return b_buscar;
    }

    public void setB_buscar(JButton b_buscar) {
        this.b_buscar = b_buscar;
    }

    public JButton getB_añadir() {
        return b_añadir;
    }

    public void setB_añadir(JButton b_añadir) {
        this.b_añadir = b_añadir;
    }

    public JButton getB_refresh() {
        return b_refresh;
    }

    public void setB_refresh(JButton b_refresh) {
        this.b_refresh = b_refresh;
    }

    public JTextArea getMostrar() {
        return mostrar;
    }

    public void setMostrar(JTextArea mostrar) {
        this.mostrar = mostrar;
    }

    public JTextArea getA_id() {
        return a_id;
    }

    public void setA_id(JTextArea a_id) {
        this.a_id = a_id;
    }

    public JTextArea getA_buscar() {
        return a_buscar;
    }

    public void setA_buscar(JTextArea a_buscar) {
        this.a_buscar = a_buscar;
    }

    public JLabel getAñadir() {
        return añadir;
    }

    public void setAñadir(JLabel añadir) {
        this.añadir = añadir;
    }

    public JButton getB_combo() {
        return b_combo;
    }

    public void setB_combo(JButton b_combo) {
        this.b_combo = b_combo;
    }

    public JComboBox getTpo_doc2() {
        return tpo_doc2;
    }

    public void setTpo_doc2(JComboBox tpo_doc2) {
        this.tpo_doc2 = tpo_doc2;
    }

    public JLabel getBuscar() {
        return buscar;
    }

    public void setBuscar(JLabel buscar) {
        this.buscar = buscar;
    }

    public JButton getB_volver() {
        return b_volver;
    }

    public void setB_volver(JButton b_volver) {
        this.b_volver = b_volver;
    }

    public JButton getB_iractualizar() {
        return b_iractualizar;
    }

    public void setB_iractualizar(JButton b_iractualizar) {
        this.b_iractualizar = b_iractualizar;
    }

    public JComboBox getCombo2() {
        return combo2;
    }

    public void setCombo2(JComboBox combo2) {
        this.combo2 = combo2;
    }

    public JTextArea getA_añadir() {
        return a_añadir;
    }

    public void setA_añadir(JTextArea a_añadir) {
        this.a_añadir = a_añadir;
    }

    public JComboBox getCargo() {
        return cargo;
    }

    public void setCargo(JComboBox cargo) {
        this.cargo = cargo;
    }
}

