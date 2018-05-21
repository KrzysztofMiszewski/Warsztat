package sda.java9.cons.cars;

import java.math.BigDecimal;

public class Suspension extends Part {

    public Suspension(String name){
        super(name);
        this.price = new BigDecimal("36.55");
    }

    @Override
    public String toString() {
        return String.format("Suspension[name=%s,price=%.2f]", name, price);
    }
}
