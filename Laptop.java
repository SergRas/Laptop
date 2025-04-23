package Laptop;
import java.util.Objects;

public class Laptop {
    private String brand;
    private int ram;
    private int storage;
    private String os;
    private String color;

    public Laptop(String brand, int ram, int storage, String os, String color) {
        this.brand = brand;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
    }

    public int getRam() { return ram; }
    public int getStorage() { return storage; }
    public String getOs() { return os; }
    public String getColor() { return color; }

    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", RAM=" + ram + " GB" +
                ", Storage=" + storage + " GB" +
                ", OS='" + os + '\'' +
                ", Color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Laptop)) return false;
        Laptop laptop = (Laptop) o;
        return ram == laptop.ram &&
                storage == laptop.storage &&
                brand.equals(laptop.brand) &&
                os.equals(laptop.os) &&
                color.equals(laptop.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, ram, storage, os, color);
    }
}

