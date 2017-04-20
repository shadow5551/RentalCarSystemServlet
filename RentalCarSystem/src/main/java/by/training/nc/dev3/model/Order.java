package by.training.nc.dev3.model;


import by.training.nc.dev3.dao.Identified;

import java.util.Date;
import java.util.Objects;

public class Order implements Identified<Integer> {
    private int id;
    private int idCar;
    private int idStatus;
    private int idUser;
    private Date beginDate;
    private Date refundDate;
    private String clarification;
    private int price;
    private int repairPrice;

    public Order(int id, int idCar, int idStatus, int idUser, Date beginDate, Date refundDate, int price, int repairPrice) {
        this.id = id;
        this.idCar = idCar;
        this.idStatus = idStatus;
        this.idUser = idUser;
        this.beginDate = beginDate;
        this.refundDate = refundDate;
        this.price = price;
        this.repairPrice = repairPrice;
    }

    public Order() {
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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
