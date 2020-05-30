package com.saeid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {

    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/Test";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "saeid";

    public static void main(String[] args){

        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD);
            statement = connection.createStatement();
            String  sql;
            sql = "SELECT * FROM customer";
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");

                System.out.printf(String.format("%d::%s::%s",id,name,address));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
