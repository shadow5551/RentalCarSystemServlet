package by.training.nc.dev3.validation;


import by.training.nc.dev3.dao.UserDaoImpl;
import by.training.nc.dev3.model.User;

import java.util.List;

public class ValidationLoginService {
    public static int id;
    private static UserDaoImpl dao;

    public static boolean validate(String login,String password)  {
        dao = new UserDaoImpl();
        List<User> list = dao.getAll();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getLogin().equals(login) && list.get(i).getPassword().equals(password)){
                id = list.get(i).getId();
                return true;
            }
        }
        return false;
    }
}
