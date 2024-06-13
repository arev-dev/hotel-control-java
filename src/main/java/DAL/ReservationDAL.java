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
                        rs.getDate(2),
                        rs.getDate(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6)
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
            String sql = "INSERT INTO  Reservation (CheckInDate, CheckOutDate, State, IdClient, IdRoom) VALUES(?,?,?,?,?,?)";
            Connection conexion = ComunDB.getConnection();
            PreparedStatement ps = ComunDB.createPS(conexion, sql);

            Date checkInDate = reservation.getCheckInDate();
            if (checkInDate != null) {
                ps.setDate(1, new java.sql.Date(checkInDate.getTime()));
            } else {
                ps.setDate(1, null);
            }

            Date checkOutDate = reservation.getCheckOutDate();
            if (checkOutDate != null) {
                ps.setDate(2, new java.sql.Date(checkOutDate.getTime()));
            } else {
                ps.setDate(2, null);
            }
            ps.setString(3,reservation.getState());
            ps.setInt(4,reservation.getIdClient());
            ps.setInt(5,reservation.getIdRoom());
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
            String sql = "UPDATE Reservation SET CheckInDate = ?, CheckOutDate = ?, State = ?, WHERE id = ?";
            Connection conexion = ComunDB.getConnection();
            PreparedStatement ps = ComunDB.createPS(conexion, sql);

            Date checkInDate = reservation.getCheckInDate();
            if (checkInDate != null) {
                ps.setDate(1, new java.sql.Date(checkInDate.getTime()));
            } else {
                ps.setDate(1, null);
            }

            Date checkOutDate = reservation.getCheckOutDate();
            if (checkOutDate != null) {
                ps.setDate(2, new java.sql.Date(checkOutDate.getTime()));
            } else {
                ps.setDate(2, null);
            }
            ps.setString(3, reservation.getState());
            ps.setInt(4, reservation.getId());
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
            String sql = "SELECT * FROM Reservation WHERE Id = ? OR CheckInDate = ? OR CheckOutDate = ? OR State LIKE ? OR IdClient = ? OR IdRoom = ?";
            Connection connection = ComunDB.getConnection();
            PreparedStatement ps = ComunDB.createPS(connection, sql);

            // Set the parameters for the prepared statement
            ps.setInt(1, reservation.getId());

            // Convert java.util.Date to java.sql.Date
            Date checkInDate = reservation.getCheckInDate();
            if (checkInDate != null) {
                ps.setDate(2, new java.sql.Date(checkInDate.getTime()));
            } else {
                ps.setDate(2, null);
            }

            // Convert java.util.Date to java.sql.Date
            Date checkOutDate = reservation.getCheckInDate();
            if (checkOutDate != null) {
                ps.setDate(3, new java.sql.Date(checkOutDate.getTime()));
            } else {
                ps.setDate(3, null);
            }

            ps.setString(4, "%" + reservation.getState() + "%");
            ps.setInt(5, reservation.getIdClient());
            ps.setInt(6, reservation.getIdRoom());

            ResultSet rs = ComunDB.getRS(ps);
            while (rs.next()) {
                ReservationResult = new Reservation(
                        rs.getInt("Id"),
                        rs.getDate("CheckInDate"),
                        rs.getDate("CheckOutDate"),
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
