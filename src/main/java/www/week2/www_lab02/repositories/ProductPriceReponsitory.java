package www.week2.www_lab02.repositories;

import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import www.week2.www_lab02.connectDB.MySessionFactory;
import www.week2.www_lab02.models.ProductPrice;

import java.util.List;

public class ProductPriceReponsitory {
    private SessionFactory sessionFactory;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    public ProductPriceReponsitory() {
        this.sessionFactory = MySessionFactory.getInstance().getSessionFactory();
    }
    public void insertProductPrice(ProductPrice productPrice) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.persist(productPrice);
            transaction.commit();
        }catch (Exception e){
            logger.error(e.getMessage());
            transaction.rollback();
        }
    }
    public List<ProductPrice> getAllProductPrice(){
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            List<ProductPrice> productPrices = session.createQuery("from ProductPrice ",ProductPrice.class).getResultList();
            transaction.commit();
            return productPrices;
        }catch (Exception e){
            logger.error(e.getMessage());
            transaction.rollback();
        }
        return null;
    }

//    public ProductPrice getProductPriceById(int productId) {
//        Transaction transaction = null;
//        try (Session session = sessionFactory.openSession()) {
//            transaction = session.beginTransaction();
//            ProductPrice productPrices = session.get(ProductPrice.class, productId);
//            transaction.commit();
//            return productPrices;
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        }
//        return null;
//    }
    public List<ProductPrice> findAllPriceByProductId(int productId) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            Query<ProductPrice> query = session.createNamedQuery(
                    "product_price.findAllPriceByProductId",
                    ProductPrice.class
            );
            query.setParameter("productId", productId);
            List<ProductPrice> productPrices = query.getResultList();

            transaction.commit();
            return productPrices;
        } catch (Exception e) {
            logger.error("Error fetching product prices by productId: " + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return null;
    }
    public ProductPrice findMostRecentPriceByProductId(int productId) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            Query<ProductPrice> query = session.createNamedQuery(
                    "ProductPrice.findOldestPriceByProductId",
                    ProductPrice.class
            );
            query.setParameter("productId", productId);
            query.setMaxResults(1); // Limit the result to one record

            ProductPrice mostRecentPrice = query.getSingleResult();

            transaction.commit();
            return mostRecentPrice;
        } catch (NoResultException e) {
            // Handle if no price records found for the product
            logger.info("No price records found for product with ID: " + productId);
        } catch (Exception e) {
            logger.error("Error fetching most recent product price: " + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return null;
    }



}
