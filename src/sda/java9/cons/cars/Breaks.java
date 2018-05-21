package sda.java9.cons.cars;

import java.math.BigDecimal;

public class Breaks extends Part {

    public Breaks(String name){
        super(name);
        this.price = new BigDecimal("30");
    }

    @Override
    public String toString() {
        return String.format("Breaks[name=%s,price=%.2f]", name, price);
    }
}
