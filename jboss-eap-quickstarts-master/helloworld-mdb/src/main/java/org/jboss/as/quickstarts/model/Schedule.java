package org.jboss.as.quickstarts.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "Schedule")
public class Schedule {

    @Id
    @GeneratedValue
    private int scheduleId;

    @Column(nullable = false)
    private int customerId;

    @Column(nullable = false)
    private Date reminderDate;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Customer.class, fetch = FetchType.EAGER)
    @JoinColumn(name="customerId" ,insertable=false, updatable=false)
    private Customer customer;

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Date getReminderDate() {
        return reminderDate;
    }

    public void setReminderDate(Date reminderDate) {
        this.reminderDate = reminderDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Schedule schedule = (Schedule) o;

        if (customerId != schedule.customerId) return false;
        if (scheduleId != schedule.scheduleId) return false;
        if (reminderDate != null ? !reminderDate.equals(schedule.reminderDate) : schedule.reminderDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = scheduleId;
        result = 31 * result + customerId;
        result = 31 * result + (reminderDate != null ? reminderDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "scheduleId=" + scheduleId +
                ", customerId=" + customerId +
                ", reminderDate=" + reminderDate +
                '}';
    }
}
