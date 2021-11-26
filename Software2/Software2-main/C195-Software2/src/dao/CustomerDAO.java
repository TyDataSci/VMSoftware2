package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {
    private static final String tableName ="customers";

    public static ObservableList<Customer> getAllCustomers() throws SQLException {
        ObservableList<Customer> allCustomers = FXCollections.observableArrayList();
        String fetchStatement = "SELECT * FROM " + tableName;
        Connection connection = DBConnection.getConnection();
        DBQuery.setPreparedStatement(connection, fetchStatement);
        PreparedStatement statement = DBQuery.getPreparedStatement();
        statement.execute();
        ResultSet results  = statement.getResultSet();
        while (results.next()){
            Customer customer = new Customer(
                    results.getInt("Customer_ID"),
                    results.getString("Customer_Name"),
                    results.getString("Address"),
                    results.getString("Postal_Code"),
                    results.getString("Phone"),
                    results.getString("Create_Date"),
                    results.getString("Created_By"),
                    results.getString("Last_Update"),
                    results.getString("Last_Updated_By"),
                    results.getInt("Division_ID"));
            allCustomers.add(customer);
        }
        return allCustomers;
    }
    public static Customer getCustomer(int selectId) throws SQLException {
        Customer customer = null;
        String fetchStatement = "SELECT * FROM " + tableName + " WHERE Customer_ID = ?";
        Connection connection = DBConnection.getConnection();
        DBQuery.setPreparedStatement(connection, fetchStatement);
        PreparedStatement statement = DBQuery.getPreparedStatement();
        statement.setInt(1,selectId);
        statement.execute();
        ResultSet results  = statement.getResultSet();
        while (results.next()){
                customer = new Customer(
                    results.getInt("Customer_ID"),
                    results.getString("Customer_Name"),
                    results.getString("Address"),
                    results.getString("Postal_Code"),
                    results.getString("Phone"),
                    results.getString("Create_Date"),
                    results.getString("Created_By"),
                    results.getString("Last_Update"),
                    results.getString("Last_Updated_By"),
                    results.getInt("Division_ID"));}

        return customer;
    }

}
