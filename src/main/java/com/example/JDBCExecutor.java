package com.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class JDBCExecutor {
    public static void main(String[] args) {

        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost",
                    "hplussport",
                    "postgres",
                    "password");
        try {
            Connection connection = dcm.getConnection();
            CustomerDAO customerDAO = new CustomerDAO(connection);
            OrderDAO orderDAO = new OrderDAO(connection);

            List<Order> orderList = orderDAO.getOrdersForCustomer(789);

            orderList.forEach(System.out::println);


        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
