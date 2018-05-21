package sda.java9.cons.cars;

import java.util.ArrayList;

public class Car {

    private String mark;
    private int year;
    private ArrayList<Part> damagedParts;

    public static final String[] ALL_MARKS = new String[] {"A", "B", "C", "D", "E", "F", "G", "H"};

    public Car(String mark, int year, ArrayList<Part> damagedParts) {
        this.mark = mark;
        this.year = year;
        this.damagedParts = damagedParts;
    }

    public Car() {
    }

    public static Car makeRandomCarWithBrokenEngine(){
        Car car = makeCar();
        Engine engine = new Engine("Engine");
        ArrayList<Part> damagedParts = new ArrayList<>();
        damagedParts.add(engine);
        car.setDamagedParts(damagedParts);
        return car;
    }

    public static Car makeRandomCar(){
        Car car = makeCar();
        int brokenPartsNo = (int) (Math.random() * 5 + 1);
        ArrayList<Part> damagedParts = new ArrayList<>();
        ArrayList<Integer> list = makeList();
        int randomNumber;
        for (int i = 0; i < brokenPartsNo; i++) {
            randomNumber = (int) (Math.random() * list.size());
            damagedParts.add(addPart(list.get(randomNumber)));
            list.remove(randomNumber);
        }
        car.setDamagedParts(damagedParts);
        return car;
    }

    private static Part addPart(int i){
        switch (i){
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

    private static ArrayList<Integer> makeList(){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        return list;
    }

    private static Car makeCar() {
        Car car = new Car();
        car.setMark(randomMark());
        car.setYear(randomYear(car.getMark()));
        return car;
    }

    private static int randomYear(String mark){
        switch (mark){
            default:
            case "A":
            case "B":
            case "C":
                return (int) (Math.random() * (2019 - 1990) + 1990);
            case "D":
            case "E":
                return (int) (Math.random() * (2019 - 1995) + 1995);
            case "F":
                return (int) (Math.random() * (2019 - 1985) + 1985);
            case "G":
                return (int) (Math.random() * (2019 - 2000) + 2000);
            case "H":
                return (int) (Math.random() * (2019 - 2015) + 2015);
        }
    }

    private static String randomMark(){
        return ALL_MARKS[(int) (Math.random() * ALL_MARKS.length)];
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ArrayList<Part> getDamagedParts() {
        return damagedParts;
    }

    public void setDamagedParts(ArrayList<Part> damagedParts) {
        this.damagedParts = damagedParts;
    }

    @Override
    public String toString() {
        return String.format("Car:\nMark: %s\nyear: %d\ndamagedParts: %d %s",
                getMark(), getYear(), getDamagedParts().size(), getDamagedParts().toString());
    }
}
