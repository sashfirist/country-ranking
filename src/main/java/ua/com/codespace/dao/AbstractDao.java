package ua.com.codespace.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;

import java.io.Serializable;

public class AbstractDao<K extends Serializable, T> {

    private final Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public AbstractDao(){
        this.persistentClass = (Class<T>) GenericTypeResolver.resolveTypeArguments(getClass(), AbstractDao.class)[1];
    }

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public T getByKey(K key){
        return (T) getSession().get(persistentClass,key);
    }

    public void persist(T entity){
        getSession().persist(entity);
    }

    public void delete(T entity){
        getSession().delete(entity);
    }

    protected Criteria createCriteria(){
        return getSession().createCriteria(persistentClass);
    }
}
