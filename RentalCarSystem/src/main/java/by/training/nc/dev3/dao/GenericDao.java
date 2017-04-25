package by.training.nc.dev3.dao;

import by.training.nc.dev3.exception.CustomGenericException;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;


public interface GenericDao<T extends Identified<PK>, PK extends Serializable>{


    List<T> getAllBYCondition(int key);

    /** Создает новую запись и соответствующий ей объект */
    boolean create(T object) throws SQLException;

    /** Возвращает объект соответствующий записи с первичным ключом key или null */
    T getByPK(int key) throws SQLException;

    /** Сохраняет состояние объекта group в базе данных */
    void update(T object) throws SQLException;

    /** Удаляет запись об объекте из базы данных */
    void delete(int key) throws SQLException;

    /** Возвращает список объектов соответствующих всем записям в базе данных */
    List<T> getAll() throws SQLException;
}