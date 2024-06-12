package EN;

import java.util.Date;

public class Pay {
    private int id;
    private double mount;
    private Date paymentDate;
    private String paymentMethod;
    private int idReservation;

    public Pay() {}

    public Pay(int id, double mount, Date paymentDate, String paymentMethod, int idReservation) {
        this.id = id;
        this.mount = mount;
        this.paymentDate = paymentDate;
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

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
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
