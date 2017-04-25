package by.training.nc.dev3.model;


import by.training.nc.dev3.dao.Identified;

import java.util.Date;
import java.util.Objects;

public class Order implements Identified<Integer> {
    private int id;
    private OrderStatus status;
    private Car car;
    private User user;
    private Date beginDate;
    private Date refundDate;
    private String clarification;
    private int price;
    private int repairPrice;

    public Order(int id, OrderStatus status, Car car, User user, Date beginDate, Date refundDate, String clarification, int price, int repairPrice) {
        this.id = id;
        this.status = status;
        this.car = car;
        this.user = user;
        this.beginDate = beginDate;
        this.refundDate = refundDate;
        this.clarification = clarification;
        this.price = price;
        this.repairPrice = repairPrice;
    }

    public Order() {
    }


    public void setId(int id) {
        this.id = id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getRefundDate() {
        return refundDate;
    }

    public void setRefundDate(Date refundDate) {
        this.refundDate = refundDate;
    }

    public String getClarification() {
        return clarification;
    }

    public void setClarification(String clarification) {
        this.clarification = clarification;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRepairPrice() {
        return repairPrice;
    }

    public void setRepairPrice(int repairPrice) {
        this.repairPrice = repairPrice;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        if(this.getClass() != other.getClass()) return false;
        Order otherObj = (Order) other;
        if (!Objects.equals(this.getId(), otherObj.getId())) return false;
        return true;
    }

    @Override
    public Integer getId() {
        return id;
    }
}
