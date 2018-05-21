package sda.java9.cons.cars;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;

public class Workshop {

    private ArrayList<String> supportedMark;
    private ArrayList<Part> partsInShop;
    private BigDecimal earnings = new BigDecimal("0").setScale(2, RoundingMode.HALF_DOWN);

    private static BigDecimal PRICE_WITHOUT_REPLACMENT = new BigDecimal("50").setScale(2, RoundingMode.HALF_DOWN);
    private static BigDecimal MARKUP = new BigDecimal("31").setScale(2, RoundingMode.HALF_DOWN);

    public static void main(String[] args) {
        Workshop workshop1 = new Workshop(randomMarks(3), randomParts());
        Workshop workshop2 = new Workshop(randomMarks(3), randomParts());
        Workshop workshop3 = new Workshop(randomMarks(3), randomParts());
        Workshop workshop4 = new Workshop(randomMarks(3), randomParts());
        Workshop workshop5 = new Workshop(randomMarks(3), randomParts());

        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            cars.add(Car.stworzLosowySamochod());
        }
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.toString()).append("\n");
        }
        System.out.println(sb);
    }

    public static Part[] randomParts(){
        int numberOfParts = (int) (Math.random() * 11 + 10);
        Part[] parts = new Part[numberOfParts];
        for (int i = 0; i < numberOfParts; i++) {
            parts[i] = randomPart((int) (Math.random() * 5), i);
        }
        return parts;
    }

    private static Part randomPart(int partType, int i){
        switch (partType){
            default:
            case 0:
                return new Gearbox("Gearbox" + i);
            case 4:
                return new Body("Body" + i);
            case 3:
                return new Breaks("Breaks" + i);
            case 2:
                return new Suspension("Suspension" + i);
            case 1:
                return new Engine("Engine" + i);
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
