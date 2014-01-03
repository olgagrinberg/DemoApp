package org.jboss.as.quickstarts.ejb;


import org.jboss.as.quickstarts.model.*;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

@Stateless
public class CustomerManagerEJB {

    @PersistenceContext
    private EntityManager entityManager;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void createCustomer(String name, String email, boolean pending) throws RemoteException, JMSException {
        Customer c1 = new Customer();
        c1.setName(name);
        c1.setEmail(email);
        c1.setPending(pending);
        entityManager.persist(c1);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void createSchedule(int customerId, Date reminderDate)  throws RemoteException, JMSException {
        Schedule s1 = new Schedule();
        s1.setCustomerId(customerId);
        s1.setReminderDate(reminderDate);
        entityManager.persist(s1);
    }

    /**
     * List all the customers.
     * 
     * @return
     * @throws javax.naming.NamingException
     * @throws javax.transaction.NotSupportedException
     * @throws javax.transaction.SystemException
     * @throws SecurityException
     * @throws IllegalStateException
     * @throws javax.transaction.RollbackException
     * @throws javax.transaction.HeuristicMixedException
     * @throws javax.transaction.HeuristicRollbackException
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @SuppressWarnings("unchecked")
    public List<Customer> listCustomers() {
        Metamodel m = entityManager.getMetamodel();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
        Root<Customer> customer = cq.from(Customer.class);
        cq.where(cb.and(cb.equal(customer.get(Customer_.pending), (Boolean.TRUE)),
                        cb.isNotEmpty(customer.get(Customer_.scheduleList))));

        cq.select(customer);
        TypedQuery<Customer> q = entityManager.createQuery(cq);
        return q.getResultList();
    }

}
