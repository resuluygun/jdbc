package com.example;

import com.example.util.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO extends DataAccessObject<Order> {

    private final static String GET_BY_ID = "SELECT c.first_name, c.last_name, c.email, o.order_id, o.creation_date, " +
            "o.total_due, o.status, s.first_name, s.last_name, s.email, ol.quantity, p.code, p.name, p.size, " +
            "p.variety, p.price FROM orders o JOIN customer c on o.customer_id = c.customer_id JOIN salesperson s " +
            "on o.salesperson_id = s.salesperson_id JOIN order_item ol on ol.order_id = o.order_id JOIN product p " +
            "on ol.product_id = p.product_id where o.order_id = ?";
    private static final String GET_FOR_CUST = "select * from get_orders_by_customer(?)";

    public OrderDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Order findById(long id) {
        Order order = new Order();
        try(PreparedStatement statement = this.connection.prepareStatement(GET_BY_ID)){
            statement.setLong(1,id);
            ResultSet result = statement.executeQuery();
            long orderId= 0;
            List<OrderLine> orderLines = new ArrayList<>();
            while (result.next()){
                if (orderId == 0){
                    order.setCustomerFirstName(result.getString(1));
                    order.setCustomerLastName(result.getString(2));
                    order.setCustomerEmail(result.getString(3));
                    order.setId(result.getInt(4));
                    orderId = order.getId();   // set for prevent over-writing
                    order.setCreationDate(result.getDate(5));
                    order.setTotalDue(result.getDouble(6));
                    order.setStatus(result.getString(7));
                    order.setSalesPersonEmail(result.getString(8));
                    order.setSalesPersonLastName(result.getString(9));
                    order.setSalesPersonFirstName(result.getString(10));
                }
                OrderLine orderLine = new OrderLine();
                orderLine.setQuantity(result.getInt(11));
                orderLine.setProductCode(result.getString(12));
                orderLine.setProductName(result.getString(13));
                orderLine.setProductSize(result.getInt(14));
                orderLine.setProductVariety(result.getString(15));
                orderLine.setProductPrice(result.getDouble(16));
                orderLines.add(orderLine);
            }
            order.setOrderLines(orderLines);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return order;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public Order update(Order dto) {
        return null;
    }

    @Override
    public Order create(Order dto) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
    public List<Order> getOrdersForCustomer(long customerId){
        List<Order> orders = new ArrayList<>();
        try(PreparedStatement statement = this.connection.prepareStatement(GET_FOR_CUST)){
            statement.setLong(1, customerId);
            ResultSet result = statement.executeQuery();
            long orderId = 0;
            Order order = null;
            while (result.next()){
                long currentOrderId = result.getLong(4);
                if(currentOrderId != orderId){
                    order = new Order();
                    orders.add(order); // even if you add order to list, it doesnt matter. bcs you can access still with Reference
                    order.setCustomerFirstName(result.getString(1));
                    order.setCustomerLastName(result.getString(2));
                    order.setCustomerEmail(result.getString(3));
                    order.setId(result.getLong(4));
                    orderId = order.getId();
                    order.setCreationDate(result.getDate(5));
                    order.setTotalDue(result.getInt(6));
                    order.setStatus(result.getString(7));
                    order.setSalesPersonFirstName(result.getString(8));
                    order.setSalesPersonLastName(result.getString(9));
                    order.setSalesPersonEmail(result.getString(10));

                    List<OrderLine> listOl = new ArrayList<>();
                    order.setOrderLines(listOl);
                }
                OrderLine singleOl = new OrderLine();
                singleOl.setQuantity(result.getInt(11));
                singleOl.setProductCode(result.getString(12));
                singleOl.setProductName(result.getString(13));
                singleOl.setProductSize(result.getInt(14));
                singleOl.setProductVariety(result.getString(15));
                singleOl.setProductPrice(result.getDouble(16));

                order.getOrderLines().add(singleOl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        finally {
            return orders;
        }
    }
}
