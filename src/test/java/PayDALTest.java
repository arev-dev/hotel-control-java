import DAL.PayDAL;
import EN.Pay;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class PayDALTest {
    @Test
    public void saveTest() throws SQLException {
        Pay Pay = new Pay();
        Pay.setMount(200.0);
        Pay.setPaymentMethod("Efectivo");
        Pay.setIdReservation(1);

        int esperado = 1;
        int actual = PayDAL.createPay(Pay);
        Assertions.assertEquals(esperado, actual);
    }

    @Test
    public void getAllTests() throws SQLException {
        int esperado = 2;
        int actual = PayDAL.getAll().size();
        Assertions.assertEquals(esperado, actual);
    }

    @Test
    public void modifyTest() throws SQLException{
        Pay Pay = new Pay();
        Pay.setMount(100.0);
        Pay.setPaymentMethod("Transferencia");
        Pay.setIdReservation(2);

        int esperado = 1;
        int actual = PayDAL.updatePay(Pay);
        Assertions.assertEquals(esperado, actual);
    }

    @Test
    public void deleteTest() throws SQLException{
        Pay Pay = new Pay();
        Pay.setId(1);

        int esperado = 1;
        int actual = PayDAL.deletePay(Pay);
        Assertions.assertEquals(esperado, actual);
    }

    @Test
    public void getFilterData() throws SQLException{
        Pay Pay = new Pay();
        Pay.setMount(99);
        Pay.setId(0);
        Pay.setPaymentMethod("");

        int actual = PayDAL.getFilterData(Pay).size();
        Assertions.assertNotEquals(0, actual);
    }
}
