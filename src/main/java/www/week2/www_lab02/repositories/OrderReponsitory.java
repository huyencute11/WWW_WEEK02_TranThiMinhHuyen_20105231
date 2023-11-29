package www.week2.www_lab02.repositories;

import com.mysql.cj.Query;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import www.week2.www_lab02.connectDB.MySessionFactory;
import www.week2.www_lab02.models.Employee;
import www.week2.www_lab02.models.Order;
import www.week2.www_lab02.models.OrderDetail;
import www.week2.www_lab02.models.ProductImage;

import java.time.LocalDate;
import java.util.Date;
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
    public List<Order> getAllOrderDaily(Date date) {
        System.out.println(date);
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            TypedQuery<Order> query = session.createQuery(
                    "from Order where orderDate = :targetDate",
                    Order.class
            ).setParameter("targetDate", date);
            List<Order> orders = query.getResultList();
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
    public List<Order> getAllOrdersInDateRange(Date startDate, Date endDate) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            TypedQuery<Order> query = session.createQuery(
                    "from Order where orderDate >= :startDate and orderDate <= :endDate",
                    Order.class
            );
            query.setParameter("startDate", startDate);
            query.setParameter("endDate", endDate);
            List<Order> orders = query.getResultList();
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
    //Thong ke order theo nhan vien ban hang trong mot khoang thoi gian
    public List<Order> getAllOrdersByEmAndDate(Date startDate, Date endDate, Long idEmployee) {
        Employee ee = new Employee(3);
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            TypedQuery<Order> query = session.createNamedQuery("Order.getAllOrdersByEmAndDate", Order.class);
            query.setParameter("employee", ee); // Provide the Employee entity
            query.setParameter("startDate", startDate);
            query.setParameter("endDate", endDate);
            List<Order> orders = query.getResultList();
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
