package UI;

import BL.ClientBL;
import BL.PayBL;
import BL.ReservationBL;
import BL.RoomBL;
import EN.Client;
import EN.Pay;
import EN.Reservation;
import EN.Room;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

public class HotelControl extends JFrame{
    private JPanel MainPanel;
    private JButton BtnNew;
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
    private JTable TablePanel;
    private JPanel TitlePanel;
    private JPanel ToolsPanel;
    private JPanel BodyPanel;
    private JPanel FieldsPanel;
    private JPanel TabsPanel;
    private JScrollPane ScrollTablePanel;
    private JLabel lbl1;
    private JLabel lbl6;
    private JLabel lbl5;
    private JLabel lbl4;
    private JLabel lbl3;
    private JLabel lbl2;
    private JButton BtnDelete;
    private JButton BtnSearch;
    private JButton BtnExit;
    private JLabel lblSearch;
    private JTextField txtSearch;
    private JButton BtnSave;
    private JButton BtnCancel;


    String currentTab = "Clients";
    Color customButtonTabColor = Color.decode("#6AA3FF");
    Color defaultBgColor = UIManager.getColor("Button.background");
    ArrayList<Client> clientList;
    ArrayList<Room> roomList;
    ArrayList<Pay> payList;
    ArrayList<Reservation> reservationList;
    Client client;
    Room room;
    Pay pay;
    Reservation reservation;
    ClientBL clientBL = new ClientBL();
    RoomBL roomBL = new RoomBL();
    PayBL payBL = new PayBL();
    ReservationBL reservationBL = new ReservationBL();

    public static void main(String[] args) throws SQLException {
        new HotelControl();
    }


    public HotelControl() throws SQLException {
        inicializar();
        updateForm();


        //-------------------------------------------
        //-----------------TABS----------------------
        BtnClients.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                currentTab = "Clients";
                BtnClients.setBackground(customButtonTabColor);
                BtnRooms.setBackground(defaultBgColor);
                BtnPays.setBackground(defaultBgColor);
                BtnReservations.setBackground(defaultBgColor);

                try {
                    changeTab(currentTab);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        BtnRooms.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                currentTab = "Rooms";
                BtnRooms.setBackground(customButtonTabColor);
                BtnClients.setBackground(defaultBgColor);
                BtnPays.setBackground(defaultBgColor);
                BtnReservations.setBackground(defaultBgColor);

                try {
                    changeTab(currentTab);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        BtnPays.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                currentTab = "Pays";
                BtnPays.setBackground(customButtonTabColor);
                BtnRooms.setBackground(defaultBgColor);
                BtnClients.setBackground(defaultBgColor);
                BtnReservations.setBackground(defaultBgColor);

                try {
                    changeTab(currentTab);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        BtnReservations.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                currentTab = "Reservations";
                BtnReservations.setBackground(customButtonTabColor);
                BtnRooms.setBackground(defaultBgColor);
                BtnPays.setBackground(defaultBgColor);
                BtnClients.setBackground(defaultBgColor);

                try {
                    changeTab(currentTab);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        //-----------------TABS----------------------
        //-------------------------------------------


        BtnNew.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!BtnNew.isEnabled()){return;}
                super.mouseClicked(e);
                txt2.setEnabled(true);
                txt3.setEnabled(txt3.isVisible());
                txt4.setEnabled(txt4.isVisible());
                txt5.setEnabled(txt5.isVisible());
                txt6.setEnabled(txt6.isVisible());
                txt2.grabFocus();
                BtnSave.setEnabled(true);
                BtnNew.setEnabled(false);
                BtnCancel.setEnabled(true);

            }
        });

        BtnSave.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);


                if(currentTab.equals("Clients"))
                {
                    client = new Client();
                    client.setName(txt2.getText());
                    client.setLastName(txt3.getText());
                    client.setCountry(txt4.getText());
                    client.setPhone(txt5.getText());
                    client.setEmail(txt6.getText());

                    try{
                        clientBL.createClient(client);
                        JOptionPane.showMessageDialog(null, "Se guardó correctamente");
                        updateForm();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else if(currentTab.equals("Rooms"))
                {
                    room = new Room();
                    room.setRoomNumber(txt2.getText());
                    room.setRoomType(txt3.getText());
                    room.setNightCost(txt4.getText());
                    room.setState(txt5.getText());
                    try{
                        roomBL.createRoom(room);
                        JOptionPane.showMessageDialog(null, "Se guardó correctamente");
                        updateForm();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else if(currentTab.equals("Pays"))
                {
                    pay = new Pay();
                    pay.setMount(Double.parseDouble(txt2.getText()));
                    pay.setPaymentMethod(txt3.getText());
                    pay.setIdReservation(Integer.parseInt(txt4.getText()));
                    try{
                        payBL.createPay(pay);
                        JOptionPane.showMessageDialog(null, "Se guardó correctamente");
                        updateForm();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else if(currentTab.equals("Reservations"))
                {
                    reservation = new Reservation();
                    reservation.setState(txt2.getText());
                    reservation.setIdClient(Integer.parseInt(txt3.getText()));
                    reservation.setIdRoom(Integer.parseInt(txt4.getText()));
                    try{
                        reservationBL.createReservation(reservation);
                        JOptionPane.showMessageDialog(null, "Se guardó correctamente");
                        updateForm();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }



            }
        });

        BtnEdit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                if(currentTab.equals("Clients"))
                {
                    client = new Client();
                    client.setId(Integer.parseInt(txt1.getText()));
                    client.setName(txt2.getText());
                    client.setLastName(txt3.getText());
                    client.setCountry(txt4.getText());
                    client.setPhone(txt5.getText());
                    client.setEmail(txt6.getText());
                    try {
                        clientBL.updateClient(client);
                        JOptionPane.showMessageDialog(null, "Se modificó con éxito");
                        updateForm();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else if(currentTab.equals("Rooms"))
                {
                    room = new Room();
                    room.setId(Integer.parseInt(txt1.getText()));
                    room.setRoomNumber(txt2.getText());
                    room.setRoomType(txt3.getText());
                    room.setNightCost(txt4.getText());
                    room.setState(txt5.getText());
                    try {
                        roomBL.updateRoom(room);
                        JOptionPane.showMessageDialog(null, "Se modificó con éxito");
                        updateForm();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else if(currentTab.equals("Pays"))
                {
                    pay = new Pay();
                    pay.setId(Integer.parseInt(txt1.getText()));
                    pay.setMount(Double.parseDouble(txt2.getText()));
                    pay.setPaymentMethod(txt3.getText());
                    pay.setIdReservation(Integer.parseInt(txt4.getText()));
                    try {
                        payBL.updatePay(pay);
                        JOptionPane.showMessageDialog(null, "Se modificó con éxito");
                        updateForm();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else if(currentTab.equals("Reservations"))
                {
                    reservation = new Reservation();
                    reservation.setId(Integer.parseInt(txt1.getText()));
                    reservation.setState(txt2.getText());
                    reservation.setIdClient(Integer.parseInt(txt3.getText()));
                    reservation.setIdRoom(Integer.parseInt(txt4.getText()));
                    try {
                        reservationBL.updateReservation(reservation);
                        JOptionPane.showMessageDialog(null, "Se modificó con éxito");
                        updateForm();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        BtnDelete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                if(currentTab.equals("Clients"))
                {
                    client = new Client();
                    client.setId(Integer.parseInt(txt1.getText()));
                    try{
                        clientBL.deleteClient(client);
                        JOptionPane.showMessageDialog(null, "Se eliminó correctamente");
                        updateForm();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else if(currentTab.equals("Rooms"))
                {
                    room = new Room();
                    room.setId(Integer.parseInt(txt1.getText()));
                    try{
                        roomBL.deleteRoom(room);
                        JOptionPane.showMessageDialog(null, "Se eliminó correctamente");
                        updateForm();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else if(currentTab.equals("Pays"))
                {
                    pay = new Pay();
                    pay.setId(Integer.parseInt(txt1.getText()));
                    try{
                        payBL.deletePay(pay);
                        JOptionPane.showMessageDialog(null, "Se eliminó correctamente");
                        updateForm();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else if(currentTab.equals("Reservations"))
                {
                    reservation = new Reservation();
                    reservation.setId(Integer.parseInt(txt1.getText()));
                    try{
                        reservationBL.deleteReservation(reservation);
                        JOptionPane.showMessageDialog(null, "Se eliminó correctamente");
                        updateForm();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        BtnSearch.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(txtSearch.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Debe ingresar el valor a buscar");
                    return;
                }

                if(currentTab.equals("Clients"))
                {
                    client = new Client();
                    int cbIdx = CbSearchBy.getSelectedIndex();

                    if(cbIdx == 0) //ID
                    {
                        client.setId(Integer.parseInt(txtSearch.getText()));
                        try{
                            fillClientTable(clientBL.getFilterData(client));
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    else if(cbIdx == 1) //Name
                    {
                        client.setName(txtSearch.getText());
                        try{
                            fillClientTable(clientBL.getFilterData(client));
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    else if(cbIdx == 2) //Lastname
                    {
                        client.setLastName(txtSearch.getText());
                        try{
                            fillClientTable(clientBL.getFilterData(client));
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    else if(cbIdx == 3) //Country
                    {
                        client.setCountry(txtSearch.getText());
                        try{
                            fillClientTable(clientBL.getFilterData(client));
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
                else if(currentTab.equals("Rooms"))
                {
                    room = new Room();
                    int cbIdx = CbSearchBy.getSelectedIndex();

                    if(cbIdx == 0) //ID
                    {
                        room.setId(Integer.parseInt(txtSearch.getText()));
                        try{
                            fillRoomTable(roomBL.getFilterData(room));
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    if(cbIdx == 1) //Numero
                    {
                        room.setRoomNumber(txtSearch.getText());
                        try{
                            fillRoomTable(roomBL.getFilterData(room));
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    if(cbIdx == 2) //Tipo
                    {
                        room.setRoomType(txtSearch.getText());
                        try{
                            fillRoomTable(roomBL.getFilterData(room));
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    if(cbIdx == 3) //Costo
                    {
                        room.setNightCost(txtSearch.getText());
                        try{
                            fillRoomTable(roomBL.getFilterData(room));
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    if(cbIdx == 4) //Estado
                    {
                        room.setState(txtSearch.getText());
                        try{
                            fillRoomTable(roomBL.getFilterData(room));
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
                else if(currentTab.equals("Pays"))
                {
                    pay = new Pay();
                    int cbIdx = CbSearchBy.getSelectedIndex();

                    if(cbIdx == 0) //ID
                    {
                        pay.setId(Integer.parseInt(txtSearch.getText()));
                        try{
                            fillPayTable(payBL.getFilterData(pay));
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    if(cbIdx == 1) //Monto
                    {
                        pay.setMount(Double.parseDouble(txtSearch.getText()));
                        try{
                            fillPayTable(payBL.getFilterData(pay));
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    if(cbIdx == 2) //Metodo pago
                    {
                        pay.setPaymentMethod(txtSearch.getText());
                        try{
                            fillPayTable(payBL.getFilterData(pay));
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    if(cbIdx == 3) // reservation
                    {
                        pay.setIdReservation(Integer.parseInt(txtSearch.getText()));
                        try{
                            fillPayTable(payBL.getFilterData(pay));
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
                else if(currentTab.equals("Reservations"))
                {
                    reservation = new Reservation();
                    int cbIdx = CbSearchBy.getSelectedIndex();

                    if(cbIdx == 0) //ID
                    {
                        reservation.setId(Integer.parseInt(txtSearch.getText()));
                        try{
                            fillReservationsTable(reservationBL.getFilterData(reservation));
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    if(cbIdx == 1) //state
                    {
                        reservation.setState(txtSearch.getText());
                        try{
                            fillReservationsTable(reservationBL.getFilterData(reservation));
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    if(cbIdx == 2) //id client
                    {
                        reservation.setIdClient(Integer.parseInt(txtSearch.getText()));
                        try{
                            fillReservationsTable(reservationBL.getFilterData(reservation));
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    if(cbIdx == 3) //id room
                    {
                        reservation.setIdRoom(Integer.parseInt(txtSearch.getText()));
                        try{
                            fillReservationsTable(reservationBL.getFilterData(reservation));
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }

                }



            }
        });

        TablePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = TablePanel.getSelectedRow();
                txt1.setText(TablePanel.getValueAt(row, 0).toString());
                txt2.setText(TablePanel.getValueAt(row, 1).toString());
                if(txt3.isVisible())
                {
                    txt3.setText(TablePanel.getValueAt(row, 2).toString());
                }
                if(txt4.isVisible())
                {
                    txt4.setText(TablePanel.getValueAt(row, 3).toString());
                }
                if(txt5.isVisible())
                {
                    txt5.setText(TablePanel.getValueAt(row, 4).toString());
                }
                if(txt6.isVisible())
                {
                    txt6.setText(TablePanel.getValueAt(row, 5).toString());
                }


                txt2.setEnabled(true);
                txt3.setEnabled(txt3.isVisible());
                txt4.setEnabled(txt4.isVisible());
                txt5.setEnabled(txt5.isVisible());
                txt6.setEnabled(txt6.isVisible());
                txt2.grabFocus();
                BtnNew.setEnabled(false);
                BtnEdit.setEnabled(true);
                BtnDelete.setEnabled(true);
                BtnCancel.setEnabled(true);
            }
        });

        BtnExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.exit(0);
            }
        });


        BtnCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    updateForm();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


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
        txt6.setEnabled(false);


        BtnNew.setEnabled(true);
        BtnSave.setEnabled(false);
        BtnEdit.setEnabled(false);
        BtnDelete.setEnabled(false);
        BtnCancel.setEnabled(false);

       if(currentTab.equals("Clients"))
       {
           fillClientTable(clientBL.getAll());
           CbSearchBy.removeAllItems();
           DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
           model.addElement("ID");
           model.addElement("Nombre");
           model.addElement("Apellidos");
           model.addElement("País");
           CbSearchBy.setModel(model);


       }
       else if(currentTab.equals("Rooms"))
       {
           fillRoomTable(roomBL.getAll());
           CbSearchBy.removeAllItems();
           DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
           model.addElement("ID");
           model.addElement("Numero");
           model.addElement("Tipo");
           model.addElement("Costo");
           model.addElement("Estado");
           CbSearchBy.setModel(model);
       }
       else if(currentTab.equals("Pays"))
       {
           fillPayTable(payBL.getAll());
           CbSearchBy.removeAllItems();
           DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
           model.addElement("ID");
           model.addElement("Monto");
           model.addElement("Metodo de Pago");
           model.addElement("Id Reservacion");
           CbSearchBy.setModel(model);
       }
       else if(currentTab.equals("Reservations"))
       {
           fillReservationsTable(reservationBL.getAll());
           CbSearchBy.removeAllItems();
           DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
           model.addElement("ID");
           model.addElement("Estado");
           model.addElement("Id Cliente");
           model.addElement("Id Habitacion");
           CbSearchBy.setModel(model);
       }
    }

    void fillClientTable(ArrayList<Client> clients){
        Object[] obj = new Object[6];
        clientList = new ArrayList<>();
        String[] header = {"ID", "NOMBRE", "APELLIDO", "PAIS", "NUMERO", "EMAIL"};
        DefaultTableModel tm = new DefaultTableModel(null, header);
        clientList.addAll(clients);
        for(Client i : clientList){
            obj[0] = i.getId();
            obj[1] = i.getName();
            obj[2] = i.getLastName();
            obj[3] = i.getCountry();
            obj[4] = i.getPhone();
            obj[5] = i.getEmail();

            tm.addRow(obj);
        }
        TablePanel.setModel(tm);
    }

    void fillRoomTable(ArrayList<Room> rooms){
        Object[] obj = new Object[5];
        roomList = new ArrayList<>();
        String[] header = {"ID", "NUMERO", "TIPO", "COSTO", "ESTADO"};
        DefaultTableModel tm = new DefaultTableModel(null, header);
        roomList.addAll(rooms);
        for(Room i : roomList){
            obj[0] = i.getId();
            obj[1] = i.getRoomNumber();
            obj[2] = i.getRoomType();
            obj[3] = i.getNightCost();
            obj[4] = i.getState();

            tm.addRow(obj);
        }
        TablePanel.setModel(tm);
    }

    void fillPayTable(ArrayList<Pay> pays){
        Object[] obj = new Object[4];
        payList = new ArrayList<>();
        String[] header = {"ID", "MONTO TOTAL", "METODO DE PAGO", "ID RESERVACION"};
        DefaultTableModel tm = new DefaultTableModel(null, header);
        payList.addAll(pays);
        for(Pay i : payList){
            obj[0] = i.getId();
            obj[1] = i.getMount();
            obj[2] = i.getPaymentMethod();
            obj[3] = i.getIdReservation();

            tm.addRow(obj);
        }
        TablePanel.setModel(tm);
    }

    void fillReservationsTable(ArrayList<Reservation> reservations){
        Object[] obj = new Object[4];
        reservationList = new ArrayList<>();
        String[] header = {"ID", "ESTADO", "ID Cliente", "ID Habitacion"};
        DefaultTableModel tm = new DefaultTableModel(null, header);
        reservationList.addAll(reservations);
        for(Reservation i : reservations){
            obj[0] = i.getId();
            obj[1] = i.getState();
            obj[2] = i.getIdClient();
            obj[3] = i.getIdRoom();

            tm.addRow(obj);
        }
        TablePanel.setModel(tm);
    }


    void changeTab(String tab) throws SQLException {
        if(tab.equals("Clients"))
        {
            lbl2.setText("Nombre");
            lbl3.setText("Apellidos");
            lbl4.setText("Pais");
            lbl5.setText("Numero");
            lbl6.setText("Correo");

            lbl3.setVisible(true);
            lbl4.setVisible(true);
            lbl5.setVisible(true);
            lbl6.setVisible(true);

            txt3.setVisible(true);
            txt4.setVisible(true);
            txt5.setVisible(true);
            txt6.setVisible(true);

            fillClientTable(clientBL.getAll());
        }
        else if(tab.equals("Rooms"))
        {
            lbl2.setText("Numero Hab.");
            lbl3.setText("Tipo Hab.");
            lbl4.setText("Costo Noche");
            lbl5.setText("Estado");
            lbl3.setVisible(true);
            lbl4.setVisible(true);
            lbl5.setVisible(true);
            lbl6.setVisible(false);
            txt3.setVisible(true);
            txt4.setVisible(true);
            txt5.setVisible(true);
            txt6.setVisible(false);

            fillRoomTable(roomBL.getAll());
        }
        else if(tab.equals("Pays"))
        {
            lbl2.setText("Monto");
            lbl3.setText("Metodo de Pago");
            lbl4.setText("ID Reservacion");

            lbl3.setVisible(true);
            lbl4.setVisible(true);
            lbl5.setVisible(false);
            lbl6.setVisible(false);

            txt3.setVisible(true);
            txt4.setVisible(true);
            txt5.setVisible(false);
            txt6.setVisible(false);

            fillPayTable(payBL.getAll());
        }
        else if(tab.equals("Reservations"))
        {
            lbl2.setText("Estado");
            lbl3.setText("ID Cliente");
            lbl4.setText("ID Habitacion");

            lbl3.setVisible(true);
            lbl4.setVisible(true);
            lbl5.setVisible(false);
            lbl6.setVisible(false);

            txt3.setVisible(true);
            txt4.setVisible(true);
            txt5.setVisible(false);
            txt6.setVisible(false);

            fillReservationsTable(reservationBL.getAll());
        }

        updateForm();
    }

}
