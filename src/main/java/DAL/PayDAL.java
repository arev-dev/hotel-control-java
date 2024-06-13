package DAL;

import EN.Pay;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;


public class PayDAL {
    public static ArrayList<Pay>  getAll() throws SQLException {
        ArrayList<Pay> lista = new ArrayList<>();
        Pay pay;
        try{
            String sql = "SELECT * FROM PAY";
            Connection conexion = ComunDB.getConnection();
            PreparedStatement ps = ComunDB.createPS(conexion, sql);
            ResultSet rs = ComunDB.getRS(ps);
            while (rs.next()){
                pay = new Pay(

                        rs.getInt(1),
                        rs.getDouble(2),
                        rs.getString(3),
                        rs.getInt(4)
                );
                lista.add(pay);
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

    public static int createPay (Pay pay) throws SQLException {
        int result = 0;
        try {
            String sql = "INSERT INTO  Pay (Mount, PaymentMethod, idReservation) VALUES(?,?,?)";
            Connection conexion = ComunDB.getConnection();
            PreparedStatement ps = ComunDB.createPS(conexion, sql);
            ps.setDouble(1, pay.getMount());
            ps.setString(2,pay.getPaymentMethod());
            ps.setInt(3, pay.getIdReservation());
            result = ps.executeUpdate();
            conexion.close();
            ps.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    public static int updatePay (Pay pay) throws SQLException {
        int result = 0;
        try {
            String sql = "UPDATE Pay SET Mount = ?, PaymentMethod = ? WHERE id = ?";
            Connection conexion = ComunDB.getConnection();
            PreparedStatement ps = ComunDB.createPS(conexion, sql);
            ps.setDouble(1, pay.getMount());
            ps.setString(2, pay.getPaymentMethod());
            ps.setInt(3, pay.getId());
            result = ps.executeUpdate();
            conexion.close();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public static int deletePay (Pay pay) throws SQLException {
        int result = 0;
        try {
            String sql = "DELETE FROM Pay WHERE Id = ?";
            Connection connection = ComunDB.getConnection();
            PreparedStatement ps = ComunDB.createPS(connection, sql);
            ps.setInt(1, pay.getId());
            result = ps.executeUpdate();
            connection.close();
            ps.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }


    public static ArrayList<Pay> getFilterData(Pay pay) throws SQLException {
        ArrayList<Pay> list = new ArrayList<>();
        Pay payResult;

        try {
            String sql = "SELECT * FROM Pay WHERE Id = ? OR Mount = ? OR PaymentMethod LIKE ? OR IdReservation = ?";
            Connection connection = ComunDB.getConnection();
            PreparedStatement ps = ComunDB.createPS(connection, sql);

            // Set the parameters for the prepared statement
            ps.setInt(1, pay.getId());
            ps.setDouble(2, pay.getMount());
            ps.setString(3, "%" + pay.getPaymentMethod() + "%");
            ps.setInt(4, pay.getIdReservation());

            ResultSet rs = ComunDB.getRS(ps);
            while (rs.next()) {
                payResult = new Pay(
                        rs.getInt("Id"),
                        rs.getDouble("Mount"),
                        rs.getString("PaymentMethod"),
                        rs.getInt("IdReservation")
                );
                list.add(payResult);
            }

            rs.close();
            ps.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }




}
