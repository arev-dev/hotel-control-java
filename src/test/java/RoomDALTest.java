import DAL.RoomDAL;
import EN.Room;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class RoomDALTest {
    @Test
    public void saveTest() throws SQLException {
        Room Room = new Room();
        Room.setRoomNumber("0001");
        Room.setRoomType("Suite");
        Room.setState("Disponible");
        Room.setNightCost("2000");

        int esperado = 1;
        int actual = RoomDAL.createRoom(Room);
        Assertions.assertEquals(esperado, actual);
    }

    @Test
    public void getAllTests() throws SQLException {
        int esperado = 2;
        int actual = RoomDAL.getAll().size();
        Assertions.assertEquals(esperado, actual);
    }

    @Test
    public void modifyTest() throws SQLException{
        Room Room = new Room();
        Room.setRoomNumber("0002");
        Room.setRoomType("Individual");
        Room.setState("Ocupada");
        Room.setNightCost("1200");

        int esperado = 1;
        int actual = RoomDAL.updateRoom(Room);
        Assertions.assertEquals(esperado, actual);
    }

    @Test
    public void deleteTest() throws SQLException{
        Room Room = new Room();
        Room.setId(1);

        int esperado = 1;
        int actual = RoomDAL.deleteRoom(Room);
        Assertions.assertEquals(esperado, actual);
    }

    @Test
    public void getFilterData() throws SQLException{
        Room Room = new Room();
        Room.setRoomType("Doble");
        Room.setId(0);
        Room.setRoomNumber("");

        int actual = RoomDAL.getFilterData(Room).size();
        Assertions.assertNotEquals(0, actual);
    }
}
