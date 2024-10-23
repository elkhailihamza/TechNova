package org.project.repository;

import java.util.List;

public interface GenericRepository<T, Long> {
    T fetchById(Long ID);
    List<T> fetchAll();
    T save(T entity);
    T update(T entity);
    T delete(T entity);
}
