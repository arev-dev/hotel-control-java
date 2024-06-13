package BL;

import DAL.PayDAL;
import EN.Pay;

import java.sql.SQLException;
import java.util.ArrayList;

public class PayBL {
    public int createPay(Pay Pay) throws SQLException{
        return PayDAL.createPay(Pay);
    }

    public int updatePay(Pay Pay) throws SQLException{
        return PayDAL.updatePay(Pay);
    }

    public int deletePay(Pay Pay) throws SQLException{
        return PayDAL.deletePay(Pay);
    }

    public ArrayList<Pay> getAll() throws SQLException{
        return PayDAL.getAll();
    }

    public ArrayList<Pay> getFilterData(Pay Pay) throws SQLException{
        return PayDAL.getFilterData(Pay);
    }
}
