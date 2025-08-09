package com.aksh.management.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cost")
public class Cost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer quantity;

    @Column(name = "")
    private Double total_price;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotal_price() {
        return total_price;
    }
    public void setTotal_price(Double total_price) {
        this.total_price = total_price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString(){
        return "cost{" +
                ", quantity=" + quantity + '\''+
                ", totalPrice=" + total_price +
                '}';
    }
}

