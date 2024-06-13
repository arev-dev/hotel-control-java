package BL;

import DAL.RoomDAL;
import EN.Room;

import java.sql.SQLException;
import java.util.ArrayList;

public class RoomBL {
    public int createRoom(Room Room) throws SQLException{
        return RoomDAL.createRoom(Room);
    }

    public int updateRoom(Room Room) throws SQLException{
        return RoomDAL.updateRoom(Room);
    }

    public int deleteRoom(Room Room) throws SQLException{
        return RoomDAL.deleteRoom(Room);
    }

    public ArrayList<Room> getAll() throws SQLException{
        return RoomDAL.getAll();
    }

    public ArrayList<Room> getFilterData(Room Room) throws SQLException{
        return RoomDAL.getFilterData(Room);
    }
}
