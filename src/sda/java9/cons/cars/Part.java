package sda.java9.cons.cars;

import java.math.BigDecimal;

public abstract class Part {
    String name;
    BigDecimal price;

    public Part(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
