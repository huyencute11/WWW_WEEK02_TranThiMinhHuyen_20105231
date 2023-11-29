package www.week2.www_lab02.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import www.week2.www_lab02.connectDB.MySessionFactory;
import www.week2.www_lab02.enums.ProductStatus;
import www.week2.www_lab02.models.Product;

import java.util.List;

public class ProductReponsitory {
    private SessionFactory sessionFactory;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    public ProductReponsitory() {
        this.sessionFactory = MySessionFactory.getInstance().getSessionFactory();
    }
    public void insertProduct(Product product) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.persist(product);
            transaction.commit();
        }catch (Exception e){
            logger.error(e.getMessage());
            transaction.rollback();
        }
    }
    public List<Product> getAllProduct(){
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            List<Product> products = session.createQuery("from Product ",Product.class).getResultList();
            transaction.commit();
            return products;
        }catch (Exception e){
            logger.error(e.getMessage());
            transaction.rollback();
        }
        return null;
    }

    public Product getProductById(int productId) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Product product = session.get(Product.class, productId);
            transaction.commit();
            return product;
        } catch (Exception e) {
            logger.error(e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return null;
    }
    //find price last update for each product



    public void setStatus(Product product , ProductStatus status){
        product.setProductStatus(status);
    }
}

