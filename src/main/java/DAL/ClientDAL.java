package DAL;

import EN.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientDAL {
    public static ArrayList<Client> getAll() throws SQLException {
        ArrayList<Client> lista = new ArrayList<>();
        Client client;
        try{
            String sql = "SELECT * FROM Client";
            Connection conexion = ComunDB.getConnection();
            PreparedStatement ps = ComunDB.createPS(conexion, sql);
            ResultSet rs = ComunDB.getRS(ps);
            while (rs.next()){
                client = new Client(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
                );
                lista.add(client);
            }
            conexion.close();
            ps.close();
            rs.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return lista;
    }

    public static int createClient(Client Client) throws SQLException{
        int result = 0;
        try {
            String sql = "INSERT INTO Client(Name, LastName, Country, Phone, Email) VALUES( ?, ?, ?, ?, ?)";
            Connection conexion = ComunDB.getConnection();
            PreparedStatement ps = ComunDB.createPS(conexion, sql);
            ps.setString(1, Client.getName());
            ps.setString(2, Client.getLastName());
            ps.setString(3, Client.getCountry());
            ps.setString(4, Client.getPhone());
            ps.setString(5, Client.getEmail());
            result = ps.executeUpdate();
            conexion.close();
            ps.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    public static int updateClient(Client client) throws SQLException{
        int result = 0;
        try {
            String sql = "UPDATE Client SET Name = ?, LastName = ?, Country = ?, Phone = ?, Email = ? WHERE Id = ?";
            Connection connection = ComunDB.getConnection();
            PreparedStatement ps = ComunDB.createPS(connection, sql);
            ps.setString(1, client.getName());
            ps.setString(2, client.getLastName());
            ps.setString(3, client.getCountry());
            ps.setString(4, client.getPhone());
            ps.setString(5, client.getEmail());
            ps.setInt(6, client.getId());
            result = ps.executeUpdate();
            connection.close();
            ps.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    public static int deleteClient(Client Client) throws SQLException{
        int result = 0;
        try {
            String sql = "DELETE FROM Client WHERE Id = ?";
            Connection connection = ComunDB.getConnection();
            PreparedStatement ps = ComunDB.createPS(connection, sql);
            ps.setInt(1, Client.getId());
            result = ps.executeUpdate();
            connection.close();
            ps.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    public static ArrayList<Client> getFilterData(Client client) throws SQLException{
        ArrayList<Client> list = new ArrayList<>();
        Client clientResult;
        try{

            String sql = "SELECT * FROM Client WHERE id = ? OR name LIKE ? OR lastName LIKE ? OR country LIKE ?";
            Connection connection = ComunDB.getConnection();
            PreparedStatement ps = ComunDB.createPS(connection, sql);
            ps.setInt(1, client.getId());
            ps.setString(2, "%" + client.getName() + "%");
            ps.setString(3, "%" + client.getLastName() + "%");
            ps.setString(4, "%" + client.getCountry() + "%");
            ResultSet rs = ComunDB.getRS(ps);
            while (rs.next()){
                clientResult = new Client(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6));
                list.add(clientResult);
            }
            connection.close();
            ps.close();
            rs.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}