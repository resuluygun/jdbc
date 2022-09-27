package com.example;

import com.example.util.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrdersDAO extends DataAccessObject<Orders> {
    private static String GET_ONE = "select order_id, creation_date, total_due, status, customer_id, salesperson_id " +
                                    "from orders where order_id= ?;";

    public OrdersDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Orders findById(long id) {
        Orders order = new Orders();
        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE)){
            statement.setLong(1,id);
            ResultSet result = statement.executeQuery();
            while (result.next()){
                order.setId(result.getInt("order_id"));
                order.setCreationDate(result.getDate("creation_date"));
                order.setTotalDue(result.getDouble("total_due"));
                order.setStatus(result.getString("status"));
                order.setCustomerId(result.getInt("customer_id"));
                order.setSalesPersonId(result.getInt("salesperson_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return order;
    }

    @Override
    public List<Orders> findAll() {
        return null;
    }

    @Override
    public Orders update(Orders dto) {
        return null;
    }

    @Override
    public Orders create(Orders dto) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
