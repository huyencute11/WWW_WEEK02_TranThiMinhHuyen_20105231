package www.week2.www_lab02.models;

import jakarta.persistence.*;
import www.week2.www_lab02.pk.OrderDetailPK;

import java.io.Serializable;

@Entity
@Table(name = "order_detail")
public class OrderDetail {

    @EmbeddedId
    private OrderDetailPK orderDetailPK;

    @Column(name = "quantity")
    private long quantity;

    @Column(name = "price")
    private double price;

    @Column(name = "note")
    private String note;

    public OrderDetail() {
        // Default constructor
    }

    public OrderDetail(OrderDetailPK orderDetailPK, long quantity, double price, String note) {
        this.orderDetailPK = orderDetailPK;
        this.quantity = quantity;
        this.price = price;
        this.note = note;
    }

    public OrderDetailPK getOrderDetailPK() {
        return orderDetailPK;
    }

    public void setOrderDetailPK(OrderDetailPK orderDetailPK) {
        this.orderDetailPK = orderDetailPK;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderDetailPK=" + orderDetailPK +
                ", quantity=" + quantity +
                ", price=" + price +
                ", note='" + note + '\'' +
                '}';
    }
}
