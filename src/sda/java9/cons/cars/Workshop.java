package sda.java9.cons.cars;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Workshop {

    private ArrayList<String> supportedMark;
    private ArrayList<Part> partsInShop;
    private BigDecimal earnings = new BigDecimal(0).setScale(2, RoundingMode.HALF_DOWN);

    private static BigDecimal PRICE_WITHOUT_REPLACMENT = new BigDecimal("50").setScale(2, RoundingMode.HALF_DOWN);
    private static BigDecimal profitMargin = new BigDecimal("31").setScale(2, RoundingMode.HALF_DOWN);

    public static void main(String[] args) {
        Workshop workshop = new Workshop(randomMarks(4), randomParts());
        do {
            sleep();
            Car car = Car.makeRandomCar();
            System.out.println(car.toString());
            workshop.checkIfAbleToRepair(car);
            System.out.println(workshop.getClass().getName());
        } while (true);
    }

    private void repair(Car car) {
        for (Part brokenPart : car.getDamagedParts()){
            for (Part shopPart : getPartsInShop()){
                getPartsInShop().remove(shopPart);
                car.getDamagedParts().remove(brokenPart);
            }
        }
    }

    private BigDecimal costs(Car car) {
        BigDecimal cost = new BigDecimal(0);
        for (Part part : car.getDamagedParts()){
            cost.add(part.getPrice());
        }
        return cost.add(profitMargin);
    }

    private boolean checkIfAbleToRepair(Car car) {
        if (supportedMark.contains(car.getMark())){
            if (partsInShop.containsAll(car.getDamagedParts())){
                return true;
            }
        }
        return false;
    }

    private static void sleep(){
        try {
            TimeUnit.SECONDS.sleep(((int) (Math.random() * (6 - 2) + 2)));
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static Part[] randomParts(){
        int numberOfParts = (int) (Math.random() * (101 - 10) + 10);
        Part[] parts = new Part[numberOfParts];
        for (int i = 0; i < numberOfParts; i++) {
            parts[i] = randomPart((int) (Math.random() * 5));
        }
        return parts;
    }

    private static Part randomPart(int partType){
        switch (partType){
            default:
            case 0:
                return new Gearbox("Gearbox");
            case 4:
                return new Body("Body");
            case 3:
                return new Breaks("Breaks");
            case 2:
                return new Suspension("Suspension");
            case 1:
                return new Engine("Engine");
        }
    }

    private static String randomPrice(){
        return String.format("%d.%d", (int) (Math.random() * 100 + 1), (int) (Math.random() * 100));
    }

    public static String[] randomMarks(int number){
        String[] marks = new String[number];
        ArrayList<String> allMarks = new ArrayList<>();
        allMarks.addAll(Arrays.asList(Car.ALL_MARKS));
        int randomNumber;
        for (int i = 0; i < marks.length; i++) {
            randomNumber = (int) (Math.random() * allMarks.size());
            marks[i] = allMarks.get(randomNumber);
            allMarks.remove(randomNumber);
        }
        return marks;
    }

    public Workshop(String[] supportedMark, Part[] partsInShop){
        this.supportedMark = new ArrayList<>();
        this.supportedMark.addAll(Arrays.asList(supportedMark));
        this.partsInShop = new ArrayList<>();
        this.partsInShop.addAll(Arrays.asList(partsInShop));
    }

    public ArrayList<String> getSupportedMark() {
        return supportedMark;
    }

    public void setSupportedMark(ArrayList<String> supportedMark) {
        this.supportedMark = supportedMark;
    }

    public ArrayList<Part> getPartsInShop() {
        return partsInShop;
    }

    public void setPartsInShop(ArrayList<Part> partsInShop) {
        this.partsInShop = partsInShop;
    }

    public BigDecimal getEarnings() {
        return earnings;
    }

    public void setEarnings(BigDecimal earnings) {
        this.earnings = earnings;
    }

    @Override
    public String toString() {
        return String.format("Warsztat:\nsuportedMarks: %s\npartsInShop: %s\nearnings: %.2f",
                supportedMark.toString(), partsInShop.toString(), earnings);
    }
}
