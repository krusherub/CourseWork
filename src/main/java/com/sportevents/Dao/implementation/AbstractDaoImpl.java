package com.sportevents.Dao.implementation;


import com.sportevents.Dao.AbstractDao;

import java.util.Collection;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class AbstractDaoImpl<T> implements AbstractDao<T> {
    // For CRUD operations on entities of type <T> in this class
    protected Map<Integer, T> entities;
    protected Function<T, Integer> idGetter;
    protected BiConsumer<T, Integer> idSetter;

    // For relation operations in derived classes
    // Example: InMemoryCommentDao.getCommentsByMovieId()
    protected Database database;

    AbstractDaoImpl(Map<Integer, T> entities,
                        Function<T, Integer> idGetter,
                        BiConsumer<T, Integer> idSetter,
                        Database database) {
        this.entities = entities;
        this.idGetter = idGetter;
        this.idSetter = idSetter;
        this.database = database;
    }

    @Override
    public T get(Integer id) {
        return entities.get(id);
    }

    @Override
    public Collection<T> findAll() {
        return entities.values();
    }

    @Override
    public void insert(T entity) {
            int maxId = entities.keySet().stream()
                    .mapToInt(Integer::intValue)
                    .max()
                    .orElse(0);
            idSetter.accept(entity, maxId + 1);
        entities.put(idGetter.apply(entity), entity);
    }

    @Override
    public void delete(T entity) {
        entities.remove(idGetter.apply(entity));
    }

    @Override
    public void update(T entity) {
        entities.put(idGetter.apply(entity), entity);
    }
}
