package BL;

import DAL.ReservationDAL;
import EN.Reservation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReservationBL {
    public int createReservation(Reservation Reservation) throws SQLException{
        return ReservationDAL.createReservation(Reservation);
    }

    public int updateReservation(Reservation Reservation) throws SQLException{
        return ReservationDAL.updateReservation(Reservation);
    }

    public int deleteReservation(Reservation Reservation) throws SQLException{
        return ReservationDAL.deleteReservation(Reservation);
    }

    public ArrayList<Reservation> getAll() throws SQLException{
        return ReservationDAL.getAll();
    }

    public ArrayList<Reservation> getFilterData(Reservation Reservation) throws SQLException{
        return ReservationDAL.getFilterData(Reservation);
    }
}
