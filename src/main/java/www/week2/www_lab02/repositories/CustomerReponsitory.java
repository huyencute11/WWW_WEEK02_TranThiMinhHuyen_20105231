package www.week2.www_lab02.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import www.week2.www_lab02.connectDB.MySessionFactory;
import www.week2.www_lab02.models.Customer;
import www.week2.www_lab02.models.Employee;

import java.util.List;

public class CustomerReponsitory {
    private SessionFactory sessionFactory;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    public CustomerReponsitory() {
        this.sessionFactory = MySessionFactory.getInstance().getSessionFactory();
    }
    public void insertCust(Customer customer) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.persist(customer);
            transaction.commit();
        }catch (Exception e){
            logger.error(e.getMessage());
            transaction.rollback();
        }
    }
    public List<Customer> getAllEmp(){
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            List<Customer> customers = session.createQuery("from Customer ",Customer.class).getResultList();
            transaction.commit();
            return customers;
        }catch (Exception e){
            logger.error(e.getMessage());
            transaction.rollback();
        }
        return null;
    }
    public Customer getCusById(int customerId) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Customer cus = session.get(Customer.class, customerId);
            transaction.commit();
            return cus;
        } catch (Exception e) {
            logger.error(e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return null;
    }
    public void updateCus(Customer customer){
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.merge(customer);
            transaction.commit();
        }catch (Exception e){
            logger.error(e.getMessage());
            transaction.rollback();
        }
    }
}
