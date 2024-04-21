package seccsion07;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static seccsion07.MySQLConnectDB.getMySQLConnection;

public class MyApplication {
    private static  final String tableName = "customers";
    public static void main(String[] args) throws SQLException {
//        createCustomner();
        getAllcostomer();
        updateCustomer();
        getAllcostomer();

    }

    public static void updateCustomer() throws  SQLException{
        Connection connection = MySQLConnectDB.getMySQLConnection();
        Statement stm = connection.createStatement();
        String query = "UPDATE customers set fist_name = 'Tran' WHERE customers_id = 2";
        int count = stm.executeUpdate(query);

        System.out.println("Update thanh cong: "+count);
    }
    public static void createCustomner() throws SQLException{
        Connection connection = MySQLConnectDB.getMySQLConnection();
        Statement stm = connection.createStatement();
        String query = "INSERT INTO customers(customers_id,fist_name,last_name,email) " +
            "value(6,'Phan', 'Quan', 'quan@gmail.com')";

        int count = stm.executeUpdate(query);

        System.out.println("them ban ghi so: "+count);

    }

    public static void createCustomersFixed(int cus_id, String fname, String lname, String email) throws SQLException{
        Connection connection = MySQLConnectDB.getMySQLConnection();
        String query = "Insert into" + tableName + "value("+cus_id+","+fname+","+lname+","+email+")";

    }

    public static void getAllcostomer() throws SQLException{
        //        if(getMySQLConnection()!= null){
//            System.out.println("Ket noi thanh cong");
//        }
//        else
//            System.out.println("fail");
        //get connection : goi doi tuong Connection de su dung

        Connection connection = getMySQLConnection();
        //tao statement(thuc thi thao tac)
        Statement stm = connection.createStatement();
        //cau lenh truy van(sql engin
        String query = "select * from customers";
        //thuc thi cau lenh truy van tra ket qua tu DB
        ResultSet rs = stm.executeQuery(query);
        //doc ban ghi tren resunset
        while (rs.next()){
            int cusId = rs.getInt(1);
            //int cusID = rs.getInt("customer_id");
            String first_name = rs.getString(2);
            String last_name = rs.getString(3);
            String email = rs.getString(4);

            System.out.println("=====================");
            System.out.println("Customer ID:"+cusId);
            System.out.println("First Name:"+first_name);
            System.out.println("Last Name:"+last_name);
            System.out.println("Email:"+email);
        }
        connection.close();
    }
}
