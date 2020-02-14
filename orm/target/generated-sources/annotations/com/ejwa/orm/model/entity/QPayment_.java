package com.ejwa.orm.model.entity;

import easycriteria.meta.*;

public class QPayment_ extends ObjectAttribute<Payment>{
    public QPayment_() {
        this(null, null);
    }
    public NumberPropertyAttribute<Payment, java.lang.Long> payment_id = new NumberPropertyAttribute<>("payment_id", this, java.lang.Long.class);
    public StringPropertyAttribute<Payment, java.lang.String> paymentType = new StringPropertyAttribute<>("paymentType", this, java.lang.String.class);
    public com.ejwa.orm.model.entity.QCustomerOrder_ customerOrder;
    private static InstancesInits inits = InstancesInits.DIRECT2;
    public QPayment_(String attribute, EntityPathNode parent) {
        this(attribute, parent, inits);
    }
    public QPayment_(String attribute, EntityPathNode parent, InstancesInits inits) {
        super(attribute, parent, Payment.class);
        this.customerOrder = inits.isInitialized("customerOrder") ? new com.ejwa.orm.model.entity.QCustomerOrder_("customerOrder", this, inits.get("customerOrder")) : null;
    }
}
