package com.ejwa.orm.model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractDAO<T,K> {

    private final Class<T> entityType;

    protected abstract EntityManager getEntityManager();

    public long count() {
        final CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        final CriteriaQuery cq = builder.createQuery();
        final Root<T> rt = cq.from(entityType);

        cq.select(builder.count(rt));

        final Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult());
    }
    
     public void edit(T entity) {
        getEntityManager().merge(entity);
    }


    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public T find(K key) {
        return getEntityManager().find(entityType, key);
    }
    
    public List<T> findAll() {
        final CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityType));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public void remove(T entity) {
        getEntityManager().remove(entity);
    }

    public void refresh(T entity){
        getEntityManager().refresh(entity);
    }

    public T merge(T entity) {
        return getEntityManager().merge(entity);
    }
 
    public void flush() {
        getEntityManager().flush();
    }

    public EntityTransaction getTransaction() {
        return getEntityManager().getTransaction();
    }
}
