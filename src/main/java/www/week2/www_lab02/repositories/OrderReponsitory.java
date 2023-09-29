package www.week2.www_lab02.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import www.week2.www_lab02.connectDB.MySessionFactory;
import www.week2.www_lab02.models.Order;
import www.week2.www_lab02.models.ProductImage;

import java.util.List;

public class OrderReponsitory {
    private SessionFactory sessionFactory;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    public OrderReponsitory() {
        this.sessionFactory = MySessionFactory.getInstance().getSessionFactory();
    }
    public void insertOrder(Order order) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.persist(order);
            transaction.commit();
        }catch (Exception e){
            logger.error(e.getMessage());
            transaction.rollback();
        }
    }
    public List<Order> getAllOrder(){
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            List<Order> orders = session.createQuery("from Order ",Order.class).getResultList();
            transaction.commit();
            return orders;
        }catch (Exception e){
            logger.error(e.getMessage());
            transaction.rollback();
        }
        return null;
    }

    public Order getOrderById(int orderId) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Order orders = session.get(Order.class, orderId);
            transaction.commit();
            return orders;
        } catch (Exception e) {
            logger.error(e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return null;
    }
}
