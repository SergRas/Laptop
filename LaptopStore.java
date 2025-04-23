package Laptop;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.List;

public class LaptopStore {
    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>(List.of(
            new Laptop("Lenovo", 8, 512, "Windows", "Black"),
            new Laptop("HP", 16, 1024, "Windows", "Silver"),
            new Laptop("Apple", 8, 256, "macOS", "Gray"),
            new Laptop("Asus", 16, 512, "Linux", "Black"),
            new Laptop("Dell", 32, 1024, "Windows", "White")
        ));

        Scanner scanner = new Scanner(System.in);
        Map<String, String> filters = new HashMap<>();
        boolean continueInput = true;

        while (continueInput) {
            System.out.println("Выберите критерий фильтрации:");
            System.out.println("1 - ОЗУ");
            System.out.println("2 - Объем ЖД");
            System.out.println("3 - Операционная система");
            System.out.println("4 - Цвет");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Минимальный объем ОЗУ (в ГБ): ");
                    filters.put("ram", scanner.nextLine());
                    break;
                case "2":
                    System.out.print("Минимальный объем ЖД (в ГБ): ");
                    filters.put("storage", scanner.nextLine());
                    break;
                case "3":
                    System.out.print("Операционная система: ");
                    filters.put("os", scanner.nextLine().toLowerCase());
                    break;
                case "4":
                    System.out.print("Цвет: ");
                    filters.put("color", scanner.nextLine().toLowerCase());
                    break;
                default:
                    System.out.println("Неверный выбор");
            }

            System.out.print("Хотите добавить еще критерий? (y/n): ");
            continueInput = scanner.nextLine().equalsIgnoreCase("y");
        }

        filterLaptops(laptops, filters);
    }

    private static void filterLaptops(Set<Laptop> laptops, Map<String, String> filters) {
        for (Laptop laptop : laptops) {
            boolean matches = true;

            if (filters.containsKey("ram") && laptop.getRam() < Integer.parseInt(filters.get("ram")))
                matches = false;
            if (filters.containsKey("storage") && laptop.getStorage() < Integer.parseInt(filters.get("storage")))
                matches = false;
            if (filters.containsKey("os") && !laptop.getOs().equalsIgnoreCase(filters.get("os")))
                matches = false;
            if (filters.containsKey("color") && !laptop.getColor().equalsIgnoreCase(filters.get("color")))
                matches = false;

            if (matches) {
                System.out.println(laptop);
            }
        }
    }
}
