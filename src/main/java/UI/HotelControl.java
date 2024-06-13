package UI;

import BL.ClientBL;
import EN.Client;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class HotelControl extends JFrame{
    private JPanel MainPanel;
    private JButton BtnCreate;
    private JButton BtnEdit;
    private JButton BtnClients;
    private JButton BtnRooms;
    private JButton BtnPays;
    private JButton BtnReservations;
    private JTextField txt1;
    private JTextField txt2;
    private JTextField txt3;
    private JTextField txt4;
    private JTextField txt5;
    private JTextField txt6;
    private JComboBox CbSearchBy;
    private JButton BtnClean;
    private JTable table1;
    private JPanel TitlePanel;
    private JPanel ToolsPanel;
    private JPanel BodyPanel;
    private JPanel FieldsPanel;
    private JPanel TabsPanel;
    private JScrollPane TablePanel;
    private JLabel lbl1;
    private JLabel lbl2;
    private JLabel lbl3;
    private JLabel lbl4;
    private JLabel lbl5;
    private JLabel lbl6;
    private JButton BtnDelete;
    private JButton BtnSearch;
    private JButton BtnExit;


    // instancias propias (creadas por nosotros)
    ArrayList<Client> clientList;
    Client client;
    ClientBL estudianteBL = new ClientBL();

    public static void main(String[] args) throws SQLException {
        new HotelControl();
    }


    public HotelControl() throws SQLException {
        inicializar();
        updateForm();
    }

    void inicializar(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(900, 700);
        setTitle("Control de Hotel");
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

        setContentPane(MainPanel);
        setVisible(true);
    }

    void updateForm() throws SQLException {
        txt1.setText("");
        txt2.setText("");
        txt3.setText("");
        txt4.setText("");
        txt5.setText("");
        txt6.setText("");
        CbSearchBy.setSelectedItem(0);

        txt1.setEnabled(false);
        txt2.setEnabled(false);
        txt3.setEnabled(false);
        txt4.setEnabled(false);
        txt5.setEnabled(false);


        BtnCreate.setEnabled(false);
        BtnEdit.setEnabled(false);
        BtnDelete.setEnabled(false);

       // llenarTabla(estudianteBL.obtenerTodos());
    }

}
