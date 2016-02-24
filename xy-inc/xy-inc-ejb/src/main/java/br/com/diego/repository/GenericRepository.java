/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diego.repository;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Diego NOTE
 */
public class GenericRepository <T> {
    
    @PersistenceContext(unitName = "xy-inc")
    protected EntityManager entityManager;
    
    public T findById(Long id) {
        return (T) entityManager.find(getTypeClass(), id);
    }
 
    public T update(T entity) {
        return entityManager.merge(entity);
    }
    
    public T save(T entity) {
        entityManager.persist(entity);
        return entity;
    }
 
    public void delete(T entity) {
        entityManager.remove(entity);
    }
 
    public List<T> findAll() {
        return entityManager.createQuery(("SELECT c FROM " + getTypeClass().getName() + " c "))
                .getResultList();
    }
 
    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
        return clazz;
    }
}
