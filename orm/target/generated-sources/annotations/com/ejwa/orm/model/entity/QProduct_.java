package com.ejwa.orm.model.entity;

import easycriteria.meta.*;

public class QProduct_ extends ObjectAttribute<Product>{
    public QProduct_() {
        this(null, null);
    }
    public NumberPropertyAttribute<Product, java.lang.Long> product_id = new NumberPropertyAttribute<>("product_id", this, java.lang.Long.class);
    public StringPropertyAttribute<Product, java.lang.String> name = new StringPropertyAttribute<>("name", this, java.lang.String.class);
    public NumberPropertyAttribute<Product, java.lang.Double> price = new NumberPropertyAttribute<>("price", this, java.lang.Double.class);
    public StringPropertyAttribute<Product, java.lang.String> discription = new StringPropertyAttribute<>("discription", this, java.lang.String.class);
    public com.ejwa.orm.model.entity.QCategory_ category;
    public com.ejwa.orm.model.entity.QCustomerOrder_ customerOrder;
    private static InstancesInits inits = InstancesInits.DIRECT2;
    public QProduct_(String attribute, EntityPathNode parent) {
        this(attribute, parent, inits);
    }
    public QProduct_(String attribute, EntityPathNode parent, InstancesInits inits) {
        super(attribute, parent, Product.class);
        this.customerOrder = inits.isInitialized("customerOrder") ? new com.ejwa.orm.model.entity.QCustomerOrder_("customerOrder", this, inits.get("customerOrder")) : null;
        this.category = inits.isInitialized("category") ? new com.ejwa.orm.model.entity.QCategory_("category", this, inits.get("category")) : null;
    }
}
