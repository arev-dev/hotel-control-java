package DAL;

import EN.Reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class ReservationDAL {
    public static ArrayList<Reservation> getAll() throws SQLException {
        ArrayList<Reservation> lista = new ArrayList<>();
        Reservation reservation;
        try{
            String sql = "SELECT * FROM Reservation";
            Connection conexion = ComunDB.getConnection();
            PreparedStatement ps = ComunDB.createPS(conexion, sql);
            ResultSet rs = ComunDB.getRS(ps);
            while (rs.next()){
                reservation = new Reservation(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4)
                );
                lista.add(reservation);
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

    public static int createReservation (Reservation reservation) throws SQLException {
        int result = 0;
        try {
            String sql = "INSERT INTO  Reservation (State, IdClient, IdRoom) VALUES(?,?,?)";
            Connection conexion = ComunDB.getConnection();
            PreparedStatement ps = ComunDB.createPS(conexion, sql);
            ps.setString(1,reservation.getState());
            ps.setInt(2,reservation.getIdClient());
            ps.setInt(3,reservation.getIdRoom());
            result = ps.executeUpdate();
            conexion.close();
            ps.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    public static int updateReservation (Reservation reservation) throws SQLException {
        int result = 0;
        try {
            String sql = "UPDATE Reservation SET State = ? WHERE id = ?";
            Connection conexion = ComunDB.getConnection();
            PreparedStatement ps = ComunDB.createPS(conexion, sql);
            ps.setString(1, reservation.getState());
            ps.setInt(2, reservation.getId());
            result = ps.executeUpdate();
            conexion.close();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public static int deleteReservation (Reservation reservation) throws SQLException {
        int result = 0;
        try {
            String sql = "DELETE FROM Reservation WHERE Id = ?";
            Connection connection = ComunDB.getConnection();
            PreparedStatement ps = ComunDB.createPS(connection, sql);
            ps.setInt(1, reservation.getId());
            result = ps.executeUpdate();
            connection.close();
            ps.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }


    public static ArrayList<Reservation> getFilterData(Reservation reservation) throws SQLException {
        ArrayList<Reservation> list = new ArrayList<>();
        Reservation ReservationResult;

        try {
            String sql = "SELECT * FROM Reservation WHERE Id = ? OR State LIKE ? OR IdClient = ? OR IdRoom = ?";
            Connection connection = ComunDB.getConnection();
            PreparedStatement ps = ComunDB.createPS(connection, sql);

            // Set the parameters for the prepared statement
            ps.setInt(1, reservation.getId());
            ps.setString(2, "%" + reservation.getState() + "%");
            ps.setInt(3, reservation.getIdClient());
            ps.setInt(4, reservation.getIdRoom());

            ResultSet rs = ComunDB.getRS(ps);
            while (rs.next()) {
                ReservationResult = new Reservation(
                        rs.getInt("Id"),
                        rs.getString("State"),
                        rs.getInt("IdClient"),
                        rs.getInt("IdRoom")
                );
                list.add(ReservationResult);
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
