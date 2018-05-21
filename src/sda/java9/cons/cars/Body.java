package sda.java9.cons.cars;

import java.math.BigDecimal;

public class Body extends Part {

    public Body(String name){
        super(name);
        this.price = new BigDecimal("98.99");
    }

    @Override
    public String toString() {
        return String.format("Body[name=%s,price=%.2f]", name, price);
    }
}
