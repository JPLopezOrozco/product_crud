package juan.product_crud.entity;

import lombok.Builder;

@Builder
public class Vape {
    private Integer id;
    private String name;
    private String brand;
    private String flavour;
    private String puffs;
    private Double price;
    private Integer stock;

    public Vape(Integer id, String name, String brand, String flavour, String puffs, Double price, Integer stock) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.flavour = flavour;
        this.puffs = puffs;
        this.price = price;
        this.stock = stock;
    }

    public Vape(String name, String brand, String flavour, String puffs, Double price, Integer stock) {
        this.name = name;
        this.brand = brand;
        this.flavour = flavour;
        this.puffs = puffs;
        this.price = price;
        this.stock = stock;
    }

    public Vape() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPuffs() {
        return puffs;
    }

    public void setPuffs(String puffs) {
        this.puffs = puffs;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }
}
