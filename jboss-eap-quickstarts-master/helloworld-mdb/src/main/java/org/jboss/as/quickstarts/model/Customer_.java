package org.jboss.as.quickstarts.model;

import javax.persistence.*;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import javax.persistence.metamodel.ListAttribute;

@StaticMetamodel(Customer.class)
public class Customer_ {
    public static volatile SingularAttribute<Customer, Long> customerId;
    public static volatile SingularAttribute<Customer, String> name;
    public static volatile SingularAttribute<Customer, String> email;
    public static volatile SingularAttribute<Customer, Boolean> pending;
    public static volatile ListAttribute<Customer, Schedule> scheduleList;
}
