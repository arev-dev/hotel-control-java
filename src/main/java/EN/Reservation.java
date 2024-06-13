package EN;

import java.util.Date;

public class Reservation {
    private int id;
    private String state;
    private int idClient;
    private int idRoom;

    public Reservation() {}

    public Reservation(int id, String state, int idClient, int idRoom) {
        this.id = id;
        this.state = state;
        this.idClient = idClient;
        this.idRoom = idRoom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }
}
