package BL;

import DAL.ClientDAL;
import EN.Client;

import java.sql.SQLException;
import java.util.ArrayList;

public class ClientBL {

    public int createClient(Client Client) throws SQLException {
        return ClientDAL.createClient(Client);
    }
    public int updateClient(Client Client) throws SQLException{
        return ClientDAL.updateClient(Client);
    }
    public int deleteClient(Client Client) throws SQLException{
        return ClientDAL.deleteClient(Client);
    }
    public ArrayList<Client> getAll() throws SQLException{
        return ClientDAL.getAll();
    }
    public ArrayList<Client> getFilterData(Client client) throws SQLException{
        return ClientDAL.getFilterData(client);
    }
}