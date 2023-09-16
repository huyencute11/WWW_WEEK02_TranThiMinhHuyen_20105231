package www.week2.www_lab02.models;

import jakarta.persistence.*;
import www.week2.www_lab02.enums.EmployeeStatus;

import java.sql.Date;
import java.util.List;

@Entity
@Table (name="employee")
@NamedQueries(@NamedQuery(name = "Employee.findAll", query = "select e from employee e"))
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private long id;
    @Column(name = "full_name", length = 150, nullable = false)
    private String fullName;
    @Column(nullable = false)
    private Date dob;

    @Column(unique = true, length = 150, nullable = false)
    private String email;
    @Column(length = 15, nullable = false)
    private String phone;

    @Column(length = 250, nullable = false)
    private String address;
    @Column(nullable = false)
    private EmployeeStatus status;

    @OneToMany(mappedBy = "employee")
    private List<Order> listOrder;

    public Employee() {
    }

    public Employee(long id) {
        this.id = id;
    }

    public Employee(long id, String fullName, Date dob, String email, String phone, String address, EmployeeStatus status) {
        this.id = id;
        this.fullName = fullName;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = status;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public List<Order> getListOrder() {
        return listOrder;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", listOrder=" + listOrder +
                '}';
    }
}
