package www.week2.www_lab02;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import www.week2.www_lab02.connectDB.ConnectDB;
import www.week2.www_lab02.connectDB.MySessionFactory;
import www.week2.www_lab02.models.Order;
import www.week2.www_lab02.repositories.OrderDetailReponsitory;
import www.week2.www_lab02.repositories.OrderReponsitory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MySessionFactory.getInstance();
//        OrderDetailReponsitory ord = new OrderDetailReponsitory();
//        List<Object[]> as = ord.reportRevenueDayly();
        OrderReponsitory od  = new OrderReponsitory();
        List<Order> ads = od.getAllOrdersByEmAndDate(new Date(2023 - 1900, 8, 14), new Date(2023-1900, 9,14), 3L);
        for (Order result : ads) {
//            LocalDate orderDay = (LocalDate) result[0];
//            BigDecimal dailyRevenue = (BigDecimal) result[1];
            System.out.println("Order Day: " +result);
        }
    }
}
