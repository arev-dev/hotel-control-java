import DAL.ClientDAL;
import EN.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class ClientDALTest {
    @Test
    public void saveTest() throws SQLException {
        Client client = new Client();
        client.setName("Alan Brito");
        client.setLastName("Delgado");
        client.setCountry("El Salvador");
        client.setPhone("12345678");
        client.setEmail("alan@gmail.com");

        int esperado = 1;
        int actual = ClientDAL.createClient(client);
        Assertions.assertEquals(esperado, actual);
    }

    @Test
    public void getAllTests() throws SQLException {
        int esperado = 2;
        int actual = ClientDAL.getAll().size();
        Assertions.assertEquals(esperado, actual);
    }

    @Test
    public void modifyTest() throws SQLException{
        Client client = new Client();
        client.setName("Armando Esteban");
        client.setLastName("Quito");
        client.setCountry("El Salvador");
        client.setPhone("87654321");
        client.setEmail("armando@gmail.com");

        int esperado = 1;
        int actual = ClientDAL.updateClient(client);
        Assertions.assertEquals(esperado, actual);
    }

    @Test
    public void deleteTest() throws SQLException{
        Client Client = new Client();
        Client.setId(1);

        int esperado = 1;
        int actual = ClientDAL.deleteClient(Client);
        Assertions.assertEquals(esperado, actual);
    }

    @Test
    public void getFilterData() throws SQLException{
        Client Client = new Client();
        Client.setName("Vinicius");
        Client.setId(0);
        Client.setPhone("");

        int actual = ClientDAL.getFilterData(Client).size();
        Assertions.assertNotEquals(0, actual);
    }
}
