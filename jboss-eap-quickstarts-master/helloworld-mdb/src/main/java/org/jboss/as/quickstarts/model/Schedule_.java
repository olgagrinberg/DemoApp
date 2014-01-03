package org.jboss.as.quickstarts.model;

import javax.persistence.*;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(Schedule.class)
public class Schedule_ {
    public static volatile SingularAttribute<Schedule, Long> scheduleId;
    public static volatile SingularAttribute<Schedule, Long> customerId;
    public static volatile SingularAttribute<Schedule, Date> reminderDate;
}
