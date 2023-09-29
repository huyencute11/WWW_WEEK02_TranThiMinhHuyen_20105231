package www.week2.www_lab02.repositories;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import www.week2.www_lab02.connectDB.MySessionFactory;
import www.week2.www_lab02.models.OrderDetail;

import java.util.List;

public class OrderDetailReponsitory {
    private SessionFactory sessionFactory;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    public OrderDetailReponsitory() {
        this.sessionFactory = MySessionFactory.getInstance().getSessionFactory();
    }
    public void insertOrderDetail(OrderDetail orderDetail) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.persist(orderDetail);
            transaction.commit();
        }catch (Exception e){
            logger.error(e.getMessage());
            transaction.rollback();
        }
    }
    public List<OrderDetail> getAllOrderDetail(){
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            List<OrderDetail> orderDetails = session.createQuery("from OrderDetail ",OrderDetail.class).getResultList();
            transaction.commit();
            return orderDetails;
        }catch (Exception e){
            logger.error(e.getMessage());
            transaction.rollback();
        }
        return null;
    }

    public List<OrderDetail> getListOrderDetailByOrderId(int orderId) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            TypedQuery<OrderDetail> query = session.createNamedQuery(
                    "OrderDetail.findOrderDetailByOrderId",
                    OrderDetail.class
            );
            query.setParameter("orderId", orderId);

            List<OrderDetail> orderDetails = query.getResultList();

            transaction.commit();
            return orderDetails;
        } catch (Exception e) {
            logger.error("Error fetching order details by orderId: " + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return null;
    }


}
