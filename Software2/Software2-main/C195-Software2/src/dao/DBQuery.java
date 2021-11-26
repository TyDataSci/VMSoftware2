package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBQuery
{
    private static PreparedStatement statement;


    public static void setPreparedStatement(Connection connection, String sqlStatement) throws SQLException {
        //Connection connection = DBConnection.getConnection();
        statement = connection.prepareStatement(sqlStatement);
    }

    public static PreparedStatement getPreparedStatement(){
        return statement;
    }
}
