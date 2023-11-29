package www.week2.www_lab02.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import www.week2.www_lab02.connectDB.MySessionFactory;
import www.week2.www_lab02.models.ProductImage;

import java.util.List;

public class ProductImageReponsitory {
    private SessionFactory sessionFactory;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    public ProductImageReponsitory() {
        this.sessionFactory = MySessionFactory.getInstance().getSessionFactory();
    }
    public void insertProductImage(ProductImage productImage) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.persist(productImage);
            transaction.commit();
        }catch (Exception e){
            logger.error(e.getMessage());
            transaction.rollback();
        }
    }
    public List<ProductImage> getAllProductImage(){
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            List<ProductImage> productImages = session.createQuery("from ProductImage ",ProductImage.class).getResultList();
            transaction.commit();
            return productImages;
        }catch (Exception e){
            logger.error(e.getMessage());
            transaction.rollback();
        }
        return null;
    }

    public List<ProductImage> getProductImageById(long productImageId) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            List<ProductImage> productImages = session.createNamedQuery("ProductImage.findImagesByIdProduct", ProductImage.class)
                    .setParameter("productId", productImageId) // Set the parameter for the named query
                    .getResultList();
            transaction.commit();
            return productImages;
        } catch (Exception e) {
            logger.error(e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return null;
    }
}
