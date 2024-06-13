package DAL;

import EN.Client;
import EN.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoomDAL {
    public static ArrayList<Room> getAll() throws SQLException {
        ArrayList<Room> lista = new ArrayList<>();
        Room room;
        try {
            String sql = "SELECT * FROM Room";
            Connection conexion = ComunDB.getConnection();
            PreparedStatement ps = ComunDB.createPS(conexion, sql);
            ResultSet rs = ComunDB.getRS(ps);
            while (rs.next()) {
                room = new Room(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                );
                lista.add(room);
            }
            conexion.close();
            ps.close();
            rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }


    public static int createRoom(Room room) throws SQLException {
        int result = 0;
        try {
            String sql = "INSERT INTO Room(roomNumber, roomType, nightCost, state) VALUES(?, ?, ?, ?)";
            Connection conexion = ComunDB.getConnection();
            PreparedStatement ps = ComunDB.createPS(conexion, sql);
            ps.setString(1, room.getRoomNumber());
            ps.setString(2, room.getRoomType());
            ps.setString(3, room.getNightCost());
            ps.setString(4, room.getState());

            result = ps.executeUpdate();
            conexion.close();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public static int updateRoom(Room room) throws SQLException{
        int result = 0;
        try {
            String sql = "UPDATE Room SET  roomNumber = ?, roomType = ?, nightCost = ?, state = ? WHERE Id = ?";
            Connection conexion = ComunDB.getConnection();
            PreparedStatement ps = ComunDB.createPS(conexion, sql);
            ps.setString(1, room.getRoomNumber());
            ps.setString(2, room.getRoomType());
            ps.setString(3, room.getNightCost());
            ps.setString(4, room.getState());
            result = ps.executeUpdate();
            conexion.close();
            ps.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    public static int deleteRoom(Room room) throws SQLException{
        int result = 0;
        try {
            String sql = "DELETE FROM Room WHERE Id = ?";
            Connection connection = ComunDB.getConnection();
            PreparedStatement ps = ComunDB.createPS(connection, sql);
            ps.setInt(1, room.getId());
            result = ps.executeUpdate();
            connection.close();
            ps.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    public static ArrayList<Room> getFilterData(Room room) throws SQLException{
        ArrayList<Room> list = new ArrayList<>();
        Room roomResult;
        try{

            String sql = "SELECT * FROM Room WHERE id = ? OR RoomNumber LIKE ? OR RoomType LIKE ? OR NightCost LIKE ? OR State LIKE ?";
            Connection connection = ComunDB.getConnection();
            PreparedStatement ps = ComunDB.createPS(connection, sql);
            ps.setInt(1, room.getId());
            ps.setString(2, "%" +  room.getRoomNumber() + "%");
            ps.setString(3, "%" + room.getRoomType() + "%");
            ps.setString(4, "%" + room.getNightCost() + "%");
            ps.setString(5, "%" + room.getState() + "%");
            ResultSet rs = ComunDB.getRS(ps);
            while (rs.next()){
                roomResult = new Room(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));


                list.add(roomResult);
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
