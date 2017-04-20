package by.training.nc.dev3.model;


import by.training.nc.dev3.dao.Identified;

public class User implements Identified<Integer> {
    private Integer idUser;
    private String login;
    private String password;
    private String numberOfPassport;
    private String role;
    private int balance;

    public User(String login, String password, String numberOfPassport, String role , int balance) {
        this.login = login;
        this.password = password;
        this.numberOfPassport = numberOfPassport;
        this.role = role;
        this.balance = balance;

    }



    public User(String login) {
        this.login = login;
    }

    public User() {
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumberOfPassport() {
        return numberOfPassport;
    }

    public void setNumberOfPassport(String numberOfPassport) {
        this.numberOfPassport = numberOfPassport;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return String
                .format("id : %5s login: %5s password: %5s numberPassport: %5s",idUser, login, password, numberOfPassport);
    }

    @Override
    public Integer getId() {
        return idUser;
    }
}
