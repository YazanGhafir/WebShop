package com.ejwa.orm.model.entity;

import easycriteria.meta.*;

public class QCustomer_ extends ObjectAttribute<Customer>{
    public QCustomer_() {
        this(null, null);
    }
    public NumberPropertyAttribute<Customer, java.lang.Long> customer_id = new NumberPropertyAttribute<>("customer_id", this, java.lang.Long.class);
    public StringPropertyAttribute<Customer, java.lang.String> email = new StringPropertyAttribute<>("email", this, java.lang.String.class);
    public StringPropertyAttribute<Customer, java.lang.String> password = new StringPropertyAttribute<>("password", this, java.lang.String.class);
    public StringPropertyAttribute<Customer, java.lang.String> shippingAdress = new StringPropertyAttribute<>("shippingAdress", this, java.lang.String.class);
    public StringPropertyAttribute<Customer, java.lang.String> homeAdress = new StringPropertyAttribute<>("homeAdress", this, java.lang.String.class);
    public StringPropertyAttribute<Customer, java.lang.String> firstName = new StringPropertyAttribute<>("firstName", this, java.lang.String.class);
    public StringPropertyAttribute<Customer, java.lang.String> lastName = new StringPropertyAttribute<>("lastName", this, java.lang.String.class);
    public com.ejwa.orm.model.entity.QCustomerOrder_ customerOrder;
    private static InstancesInits inits = InstancesInits.DIRECT2;
    public QCustomer_(String attribute, EntityPathNode parent) {
        this(attribute, parent, inits);
    }
    public QCustomer_(String attribute, EntityPathNode parent, InstancesInits inits) {
        super(attribute, parent, Customer.class);
        this.customerOrder = inits.isInitialized("customerOrder") ? new com.ejwa.orm.model.entity.QCustomerOrder_("customerOrder", this, inits.get("customerOrder")) : null;
    }
}
