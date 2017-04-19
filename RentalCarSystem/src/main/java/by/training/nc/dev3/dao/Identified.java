package by.training.nc.dev3.dao;

import java.io.Serializable;


public interface Identified<PK extends Serializable> {

    /** Возвращает идентификатор объекта */
    PK getId();
}
