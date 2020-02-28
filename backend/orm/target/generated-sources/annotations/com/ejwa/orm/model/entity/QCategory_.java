package com.ejwa.orm.model.entity;

import easycriteria.meta.*;

public class QCategory_ extends ObjectAttribute<Category>{
    public QCategory_() {
        this(null, null);
    }
    public NumberPropertyAttribute<Category, java.lang.Long> category_id = new NumberPropertyAttribute<>("category_id", this, java.lang.Long.class);
    public StringPropertyAttribute<Category, java.lang.String> name = new StringPropertyAttribute<>("name", this, java.lang.String.class);
    public CollectionAttribute<Category, com.ejwa.orm.model.entity.Product> productList = new CollectionAttribute<>("productList", this, com.ejwa.orm.model.entity.Product.class);
    private static InstancesInits inits = InstancesInits.DIRECT2;
    public QCategory_(String attribute, EntityPathNode parent) {
        this(attribute, parent, inits);
    }
    public QCategory_(String attribute, EntityPathNode parent, InstancesInits inits) {
        super(attribute, parent, Category.class);
    }
}
