package UI;

import javax.swing.*;

public class HotelControl extends JFrame{
    private JPanel MainPanel;
    private JButton crearNuevoButton;
    private JButton editarButton;
    private JButton clientesButton;
    private JButton habitacionesButton;
    private JButton pagosButton;
    private JButton reservacionesButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JComboBox comboBox1;
    private JButton limpiarCamposButton;
    private JTable table1;

    public static void main(String[] args) {
        new HotelControl();
    }


    public HotelControl()
    {
        inicializar();
    }

    void inicializar(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(900, 700);
        setTitle("Control de Estudiantes");
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

        setContentPane(MainPanel);
        setVisible(true);
    }

}
