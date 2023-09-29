package www.week2.www_lab02.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;
@Entity
@Table(name = "product_price")
@NamedQueries({
        @NamedQuery(
                name = "product_price.findAllPriceByProductId",
                query = "SELECT pp FROM ProductPrice pp WHERE pp.product.id = :productId"
        ),
        @NamedQuery(
                name = "ProductPrice.findOldestPriceByProductId",
                query = "SELECT pp FROM ProductPrice pp WHERE pp.product.id = :productId " +
                        "ORDER BY pp.priceDateTime DESC"
        )

})
public class ProductPrice implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;

    @Id
    @Column(name = "price_date_time")
    private Date priceDateTime;

    @Column(name = "price")
    private double price;

    @Column(name = "note")
    private String note;

    public ProductPrice() {
        // Default constructor
    }

    public ProductPrice(Product product, Date priceDateTime, double price, String note) {
        this.product = product;
        this.priceDateTime = priceDateTime;
        this.price = price;
        this.note = note;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getPriceDateTime() {
        return priceDateTime;
    }

    public void setPriceDateTime(Date priceDateTime) {
        this.priceDateTime = priceDateTime;
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
        return "ProductPrice{" +
                "product=" + product +
                ", priceDateTime=" + priceDateTime +
                ", price=" + price +
                ", note='" + note + '\'' +
                '}';
    }
}
