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

            Customer customer= customerDAO.findById(10000);
            System.out.println("before update: ");
            System.out.println(customer.getFirstName() + " " + customer.getLastName() + " " +customer.getEmail());

            customer.setEmail("res@gmail.com");
            customerDAO.update(customer);
            System.out.println("after update: ");
            System.out.println(customer.getFirstName() + " " + customer.getLastName() + " " +customer.getEmail());

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
