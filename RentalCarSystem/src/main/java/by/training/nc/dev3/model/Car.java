package by.training.nc.dev3.model;


import by.training.nc.dev3.dao.Identified;


public class Car implements Identified<Integer> {
    private int id;
    private String brand;
    private String model;
    private int countOfCars;
    private int pricePerDay;


    public Car(int id, String brand, String model, int countOfCars, int pricePerDay) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.countOfCars = countOfCars;
        this.pricePerDay = pricePerDay;
    }

    public Car() {
    }

    public Car(String brand, String model, int pricePerDay) {
        this.brand = brand;
        this.model = model;
        this.pricePerDay = pricePerDay;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCountOfCars() {
        return countOfCars;
    }

    public void setCountOfCars(int countOfCars) {
        this.countOfCars = countOfCars;
    }

    @Override
    public int hashCode() {
        return 76+13*id;
    }

    @Override
    public String toString() {
        return String
                .format("brand: %5s model: %5s count:%5s price: %5s", brand, model, countOfCars,pricePerDay);
    }

    @Override
    public Integer getId() {
        return id;
    }
}
