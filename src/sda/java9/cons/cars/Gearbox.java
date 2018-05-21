package sda.java9.cons.cars;

import java.math.BigDecimal;

public class Gearbox extends Part {

    public Gearbox(String name){
        super(name);
        this.price = new BigDecimal("33.33");
    }

    @Override
    public String toString() {
        return String.format("Gearbox[name=%s,price=%.2f]", name, price);
    }
}
