package com.ejwa.orm.model.entity;

import easycriteria.meta.*;

public class QCustomerOrder_ extends ObjectAttribute<CustomerOrder>{
    public QCustomerOrder_() {
        this(null, null);
    }
    public NumberPropertyAttribute<CustomerOrder, Long> customerorder_id = new NumberPropertyAttribute<>("customerorder_id", this, Long.class);
    public DatePropertyAttribute<CustomerOrder, java.time.LocalDateTime> date = new DatePropertyAttribute<>("date", this, java.time.LocalDateTime.class);
    public com.ejwa.orm.model.entity.QPayment_ payment;
    public com.ejwa.orm.model.entity.QCustomer_ customer;
    public CollectionAttribute<CustomerOrder, com.ejwa.orm.model.entity.Product> productList = new CollectionAttribute<>("productList", this, com.ejwa.orm.model.entity.Product.class);
    private static InstancesInits inits = InstancesInits.DIRECT2;
    public QCustomerOrder_(String attribute, EntityPathNode parent) {
        this(attribute, parent, inits);
    }
    public QCustomerOrder_(String attribute, EntityPathNode parent, InstancesInits inits) {
        super(attribute, parent, CustomerOrder.class);
        this.payment = inits.isInitialized("payment") ? new com.ejwa.orm.model.entity.QPayment_("payment", this, inits.get("payment")) : null;
        this.customer = inits.isInitialized("customer") ? new com.ejwa.orm.model.entity.QCustomer_("customer", this, inits.get("customer")) : null;
    }
}
