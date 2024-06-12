package EN;

public class Room {
    private int id;
    private String roomNumber;
    private String roomType;
    private String nightCost;
    private String state;

    public Room() {}

    public Room(int id, String roomNumber, String roomType, String nightCost, String state) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.nightCost = nightCost;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getNightCost() {
        return nightCost;
    }

    public void setNightCost(String nightCost) {
        this.nightCost = nightCost;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
