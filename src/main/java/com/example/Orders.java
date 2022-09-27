package com.example;

import com.example.util.DataTransferObject;

import java.util.Date;

public class Orders implements DataTransferObject {
    private long id;
    private Date creationDate;
    private double totalDue;
    private String status;
    private long customerId;

    @Override
    public String toString() {
        return "Orders {" +
                "id=" + id +
                ", creationDate=" + creationDate +
                ", totalDue=" + totalDue +
                ", status='" + status + '\'' +
                ", customerId=" + customerId +
                ", salesPersonId=" + salesPersonId +
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

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getSalesPersonId() {
        return salesPersonId;
    }

    public void setSalesPersonId(long salesPersonId) {
        this.salesPersonId = salesPersonId;
    }

    private long salesPersonId;

    @Override
    public long getId() {
        return id;
    }
}
