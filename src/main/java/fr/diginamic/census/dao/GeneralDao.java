package fr.diginamic.census.dao;

import java.util.List;

public interface GeneralDao<T> {
    List<T> extract();

    T insert(T obj);

    int update(T obj);

    Boolean delete(T obj);
}
