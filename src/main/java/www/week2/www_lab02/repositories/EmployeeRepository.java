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
    public void updateStatus(Employee employee , EmployeeStatus status){
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            // Execute the named query "Employee.updateStatus"
            int updatedCount = session.createNamedQuery("Employee.updateStatus")
                    .setParameter("status", status)
                    .setParameter("id", employee.getId())
                    .executeUpdate();

            if (updatedCount == 1) {
                // The update was successful
                employee.setStatus(status); // Update the local employee object
                transaction.commit();
            } else {
                // Handle the case where the update didn't affect any rows (no employee with the specified ID)
                logger.error("Employee with ID " + employee.getId() + " not found.");
                transaction.rollback();
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        }
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
            List<Employee>  employees = session.createNamedQuery("Employee.findAll", Employee.class).getResultList();
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
    //delete
    public boolean deleteEmployeeById(int employeeId) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            // Retrieve the employee by ID
            Employee employee = session.get(Employee.class, employeeId);

            if (employee != null) {
                session.remove(employee);
                return true;
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error deleting employee: " + e.getMessage());
        }
        return false;
    }

}
