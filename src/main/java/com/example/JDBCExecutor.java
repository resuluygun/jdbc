package com.example;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCExecutor {
    public static void main(String[] args) {

        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost",
                    "hplussport",
                    "postgres",
                    "password");
        try {
            Connection connection = dcm.getConnection();
            CustomerDAO customerDAO = new CustomerDAO(connection);
            OrdersDAO ordersDAO = new OrdersDAO(connection);

            Orders order = ordersDAO.findById(1000);
            System.out.println(order);



        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
