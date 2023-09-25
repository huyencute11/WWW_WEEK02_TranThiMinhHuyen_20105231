package www.week2.www_lab02.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import www.week2.www_lab02.models.Customer;

public class CustomerReponsitory {
    private EntityManager em;
    private EntityTransaction trans;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    public CustomerReponsitory() {
        em = Persistence.createEntityManagerFactory("lab_week_2")
                .createEntityManager();
        trans = em.getTransaction();
    }
    public void insertCust(Customer customer){
        try {
            trans.begin();
            em.persist(customer);
            trans.commit();
        } catch (Exception e) {
            if (trans.isActive()) {
                trans.rollback();
            }
            logger.error("Error inserting customer: " + e.getMessage());
        }
    }
}
