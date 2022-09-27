package com.example;

import com.example.util.DataTransferObject;

import java.util.Date;
import java.util.List;

public class Order implements DataTransferObject {
    private long id;
    private Date creationDate;
    private double totalDue;
    private String status;
    private String customerFirstName;
    private String customerLastName;
    private String customerEmail;

    private String salesPersonFirstName;
    private String salesPersonLastName;
    private String salesPersonEmail;
    private List<OrderLine> orderLines;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                ", totalDue=" + totalDue +
                ", status='" + status + '\'' +
                ", customerFirstName='" + customerFirstName + '\'' +
                ", customerLastName='" + customerLastName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", salesPersonFirstName='" + salesPersonFirstName + '\'' +
                ", salesPersonLastName='" + salesPersonLastName + '\'' +
                ", salesPersonEmail='" + salesPersonEmail + '\'' +
                ", orderLines=" + orderLines +
                '}';
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public double getTotalDue() {
        return totalDue;
    }

    public void setTotalDue(double totalDue) {
        this.totalDue = totalDue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getSalesPersonFirstName() {
        return salesPersonFirstName;
    }

    public void setSalesPersonFirstName(String salesPersonFirstName) {
        this.salesPersonFirstName = salesPersonFirstName;
    }

    public String getSalesPersonLastName() {
        return salesPersonLastName;
    }

    public void setSalesPersonLastName(String salesPersonLastName) {
        this.salesPersonLastName = salesPersonLastName;
    }

    public String getSalesPersonEmail() {
        return salesPersonEmail;
    }

    public void setSalesPersonEmail(String salesPersonEmail) {
        this.salesPersonEmail = salesPersonEmail;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    @Override
    public long getId() {
        return id;
    }
}
