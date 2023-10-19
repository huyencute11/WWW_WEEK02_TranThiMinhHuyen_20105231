package www.week2.www_lab02.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import www.week2.www_lab02.connectDB.MySessionFactory;
import www.week2.www_lab02.enums.EmployeeStatus;
import www.week2.www_lab02.models.Employee;

import java.util.List;
import java.util.Optional;

public class EmployeeRepository {
    private SessionFactory sessionFactory;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    public EmployeeRepository() {
        this.sessionFactory = MySessionFactory.getInstance().getSessionFactory();
    }
    public void insertEmp(Employee employee){
        System.out.println(employee);
       Transaction transaction = null;
       try(Session session = sessionFactory.openSession()){
           transaction = session.beginTransaction();
            session.persist(employee);
            transaction.commit();
       }catch (Exception e){
           logger.error(e.getMessage());
            transaction.rollback();
        }
    }
    public void setStatus(Employee employee , EmployeeStatus status){
        employee.setStatus(status);
    }
    public void updateEmp(Employee employee){
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.merge(employee);
            transaction.commit();
        }catch (Exception e){
            logger.error(e.getMessage());
            transaction.rollback();
        }
    }

    public Optional<Employee> findById(long id){
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            transaction.commit();
            return Optional.ofNullable(employee);
        }catch (Exception e){
            logger.error(e.getMessage());
            transaction.rollback();
        }
        return Optional.empty();
    }
    public List<Employee> getAllEmp(){
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            List<Employee> employees = session.createQuery("from Employee",Employee.class).getResultList();
            employees.forEach(e->{
                System.out.println(e.getStatus());
            });
            transaction.commit();
            return employees;
        }catch (Exception e){
            logger.error(e.getMessage());
            transaction.rollback();
        }
        return null;
    }

    public Employee getEmpById(int employeeId) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Employee employee = session.get(Employee.class, employeeId);
            transaction.commit();
            return employee;
        } catch (Exception e) {
            logger.error(e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return null;
    }
}
