package EN;

import java.util.Date;

public class Pay {
    private int id;
    private double mount;
    private String paymentMethod;
    private int idReservation;

    public Pay() {}

    public Pay(int id, double mount, String paymentMethod, int idReservation) {
        this.id = id;
        this.mount = mount;
        this.paymentMethod = paymentMethod;
        this.idReservation = idReservation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMount() {
        return mount;
    }

    public void setMount(double mount) {
        this.mount = mount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }
}
