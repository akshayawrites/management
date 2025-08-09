package com.aksh.management.pojo;

public class CostDTO {

    private Long id;
    private Long productId;
    private Integer quantity;
    private Double total_price;

    public Double getTotal_price() {
        return total_price;
    }
    public void setTotal_price(Double total_price) {
        this.total_price = total_price;
    }

    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
