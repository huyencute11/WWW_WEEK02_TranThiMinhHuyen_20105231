package www.week2.www_lab02;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import www.week2.www_lab02.connectDB.ConnectDB;
import www.week2.www_lab02.connectDB.MySessionFactory;

public class Main {
    public static void main(String[] args) {
        MySessionFactory.getInstance();
    }
}
