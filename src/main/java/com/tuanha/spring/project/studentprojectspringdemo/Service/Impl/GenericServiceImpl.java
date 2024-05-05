package com.tuanha.spring.project.studentprojectspringdemo.Service.Impl;

import com.tuanha.spring.project.studentprojectspringdemo.Entity.Student;
import com.tuanha.spring.project.studentprojectspringdemo.Repo.GenericService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GenericServiceImpl<T> implements GenericService<T> {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<T> findAll(Class<T> entityClass) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);
        Root<T> root = criteriaQuery.from(entityClass);
        criteriaQuery.select(root);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public T findById(Class<T> entityClass, Integer id) {
        return entityManager.find(entityClass, id);
    }

    @Override
    @Transactional
    public T save(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public <T> void delete(Class<T> entityClass, Integer id) {
        T entity = entityManager.find(entityClass, id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }
}
