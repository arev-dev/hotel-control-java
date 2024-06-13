import DAL.ReservationDAL;
import EN.Reservation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class ReservationDALTest {
    @Test
    public void saveTest() throws SQLException {
        Reservation Reservation = new Reservation();
        Reservation.setState("Pendiente");
        Reservation.setIdRoom(1);
        Reservation.setIdClient(1);

        int esperado = 1;
        int actual = ReservationDAL.createReservation(Reservation);
        Assertions.assertEquals(esperado, actual);
    }

    @Test
    public void getAllTests() throws SQLException {
        int esperado = 2;
        int actual = ReservationDAL.getAll().size();
        Assertions.assertEquals(esperado, actual);
    }

    @Test
    public void modifyTest() throws SQLException{
        Reservation Reservation = new Reservation();
        Reservation.setState("Confirmada");
        Reservation.setIdRoom(2);
        Reservation.setIdClient(3);

        int esperado = 1;
        int actual = ReservationDAL.updateReservation(Reservation);
        Assertions.assertEquals(esperado, actual);
    }

    @Test
    public void deleteTest() throws SQLException{
        Reservation Reservation = new Reservation();
        Reservation.setId(1);

        int esperado = 1;
        int actual = ReservationDAL.deleteReservation(Reservation);
        Assertions.assertEquals(esperado, actual);
    }

    @Test
    public void getFilterData() throws SQLException{
        Reservation Reservation = new Reservation();
        Reservation.setState("");
        Reservation.setId(0);
        Reservation.setIdClient(0);

        int actual = ReservationDAL.getFilterData(Reservation).size();
        Assertions.assertNotEquals(0, actual);
    }
}
