package www.week2.www_lab02.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "order_date")
    private Date orderDate;

    @ManyToOne
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "cust_id", referencedColumnName = "cust_id")
    private Customer customer;
    @OneToMany(mappedBy = "orderDetailPK.order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<OrderDetail> orderDetails;

    public Order() {
        // Default constructor
    }

    public Order(Long orderId) {
        this.orderId = orderId;
    }

    public Order(Long orderId, Date orderDate, Employee employee, Customer customer) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.employee = employee;
        this.customer = customer;
    }
    public Order(Date orderDate, Employee employee, Customer customer) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.employee = employee;
        this.customer = customer;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", employee=" + employee +
                ", customer=" + customer +
                '}';
    }
}
