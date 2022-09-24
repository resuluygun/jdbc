package com.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExecutor {
    public static void main(String[] args) {

        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost",
                    "hplussport",
                    "postgres",
                    "password");
        try {
            Connection connection = dcm.getConnection();
            CustomerDAO customerDAO = new CustomerDAO(connection);
            Customer customer = new Customer();
            customer.setFirstName("Resul");
            customer.setLastName("Uygun");
            customer.setCity("Ankara");
            customer.setAddress("Aytmatov Caddesi");
            customer.setEmail("res@gmail.com");
            customer.setState("Yenimahall");
            customer.setZipCode("06100");
            customer.setPhone("02223237723");

            customerDAO.create(customer);


        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
