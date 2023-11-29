package www.week2.www_lab02.converters;

import java.util.List;

public class ProductDTO {
    private long id;
    private String des;
    private String name;
    private double price;
    private List<String> pathImage;

    public ProductDTO(List<String> pathImage) {
        this.pathImage = pathImage;
    }

    public ProductDTO(long id, String des, String name, double price, List<String> pathImage) {
        this.id = id;
        this.des = des;
        this.name = name;
        this.price = price;
        this.pathImage = pathImage;
    }

    public ProductDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<String> getPathImage() {
        return pathImage;
    }

    public void setPathImage(List<String> pathImage) {
        this.pathImage = pathImage;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", des='" + des + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", pathImage=" + pathImage +
                '}';
    }
}
