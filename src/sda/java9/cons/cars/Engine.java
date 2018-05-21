package sda.java9.cons.cars;

import java.math.BigDecimal;

public class Engine extends Part {

    public Engine(String name){
        super(name);
        this.price = new BigDecimal("46.95");
    }

    @Override
    public String toString() {
        return String.format("Engine[name=%s,price=%.2f]", name, price);
    }

}
