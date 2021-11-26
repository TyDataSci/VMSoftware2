package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryDAO {
    private static final String tableName = "countries";
    public static ObservableList<Country> getAllCountries() throws SQLException {
        ObservableList<Country> allCountries = FXCollections.observableArrayList();
        String fetchStatement = "SELECT * FROM " + tableName;
        Connection connection = DBConnection.getConnection();
        DBQuery.setPreparedStatement(connection, fetchStatement);
        PreparedStatement statement = DBQuery.getPreparedStatement();
        statement.execute();
        ResultSet results  = statement.getResultSet();
        while (results.next()){
            Country country = new Country(
                    results.getInt("Country_ID"),
                    results.getString("Country"),
                    results.getString("Create_Date"),
                    results.getString("Created_By"),
                    results.getString("Last_Update"),
                    results.getString("Last_Updated_By"));
            allCountries.add(country);
        }
        return allCountries;
    }
    public static Country getCountry(String selectCountryName) throws SQLException {
        Country country = null;
        String fetchStatement = "SELECT * FROM " + tableName + " WHERE Country = ?";
        System.out.println(fetchStatement);
        Connection connection = DBConnection.getConnection();
        DBQuery.setPreparedStatement(connection, fetchStatement);
        PreparedStatement statement = DBQuery.getPreparedStatement();
        statement.setString(1,selectCountryName);
        statement.execute();
        ResultSet results  = statement.getResultSet();
        while (results.next()) {
            country = new Country(
                    results.getInt("Country_ID"),
                    results.getString("Country"),
                    results.getString("Create_Date"),
                    results.getString("Created_By"),
                    results.getString("Last_Update"),
                    results.getString("Last_Updated_By"));
        }

            return country;
        }
    public static Country getCountry(int selectCountryId) throws SQLException {
        Country country = null;
        String fetchStatement = "SELECT * FROM " + tableName + " WHERE Country_ID = ?" ;
        System.out.println(fetchStatement);
        Connection connection = DBConnection.getConnection();
        DBQuery.setPreparedStatement(connection, fetchStatement);
        PreparedStatement statement = DBQuery.getPreparedStatement();
        statement.setInt(1,selectCountryId);
        statement.execute();
        ResultSet results  = statement.getResultSet();
        while (results.next()) {
            country = new Country(
                    results.getInt("Country_ID"),
                    results.getString("Country"),
                    results.getString("Create_Date"),
                    results.getString("Created_By"),
                    results.getString("Last_Update"),
                    results.getString("Last_Updated_By"));
        }

        return country;
    }
}
