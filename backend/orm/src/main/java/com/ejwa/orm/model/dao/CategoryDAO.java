package com.ejwa.orm.model.dao;

import com.ejwa.orm.model.entity.Category;
import com.ejwa.orm.model.entity.QCategory_;
import easycriteria.JPAQuery;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;

@Stateless
public class CategoryDAO extends AbstractDAO<Category, Long> {

    @Getter
    @PersistenceContext(unitName = "webshopDB")
    private EntityManager entityManager;

    public CategoryDAO() {
        super(Category.class);
    }

    /*
    public void remove(Category entity) {
        Category entityToRemove = entityManager.find(Category.class, entity.getCategory_id());
        entityManager.remove(entityToRemove);
    }
    */

    public Category findCategoryMatchingID(Long id) {
        QCategory_ cat = new QCategory_();
        Category p = new JPAQuery(getEntityManager()).select(Category.class)
                .where(
                        cat.category_id.eq(id)
                ).getSingleResult();
        return p;
    }

    public List<Category> findCategoriesMatchingCategoryName(String name) {
        QCategory_ cat = new QCategory_();
        List<Category> cat_List = new JPAQuery(getEntityManager()).select(Category.class)
                .where(
                        cat.name.eq(name)
                ).getResultList();
        return cat_List;
    }
    
     public void removeAllCategories() {
        QCategory_ cat = new QCategory_();
        List<Category> cat_List = new JPAQuery(getEntityManager()).select(Category.class).getResultList();
        for (Category c : cat_List) {
            remove(c);
        }
    }
}
