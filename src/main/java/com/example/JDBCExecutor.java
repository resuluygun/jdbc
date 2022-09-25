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

            Customer customer= customerDAO.findById(10001);
            System.out.println("before update: ");
            System.out.println(customer);

            customer.setLastName("Coskun");
            customer.setState("Kecioren");

            customerDAO.update(customer);
            System.out.println("after update: ");
            System.out.println(customer);

            customerDAO.delete(customer.getId());

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
