package com.tuanha.spring.project.studentprojectspringdemo.Repo;


import java.util.List;

public interface GenericService<T> {
     List<T> findAll(Class<T> entityClass);
    T findById(Class<T> entityClass ,Integer id);
    T save(T entity);
    <T> void delete(Class<T> entityClass,Integer id);
    default T update(T entity, Integer id){
        T en = this.findById((Class<T>) entity, id);
        return en;
    };
}
