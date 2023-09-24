package www.week2.www_lab02.connectDB;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.Connection;

public class ConnectDB {
    private static ConnectDB instance;
    private EntityManagerFactory emf;
    public ConnectDB() {
        emf = Persistence.createEntityManagerFactory("WWW_Lab02");
    }
    public static ConnectDB getInstance() {
        if(instance == null)
            instance = new ConnectDB();
        return instance;
    }
    public EntityManagerFactory getEmf() {
        return emf;
    }
//    public Connection getConnection(){
//        return connection;
//    }
}
