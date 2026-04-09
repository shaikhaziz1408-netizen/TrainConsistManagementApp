import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * ============================================================================
 * DOMAIN MODEL - Bogie
 * ============================================================================
 */
class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() { return name; }
    public int getCapacity() { return capacity; }

    @Override
    public String toString() {
        return String.format("[%s (Cap: %d)]", name, capacity);
    }
}

/**
 * ============================================================================
 * MAIN CLASS - TrainConsistManagementApp
 * ============================================================================
 * Use Case 9: Group Bogies by Type (Collectors.groupingBy)
 * * Description:
 * This use case uses advanced Stream collectors to categorize a flat list
 * into a Map structure. This mimics real-world reporting where bogies
 * are grouped by their class or category.
 * * @version 9.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println("   === Train Consist Management App ===");
        System.out.println("=======================================\n");

        // 1. Initialize the List with multiple bogies of the same type
        List<Bogie> trainConsist = new ArrayList<>();
        trainConsist.add(new Bogie("Sleeper", 72));
        trainConsist.add(new Bogie("Sleeper", 72));
        trainConsist.add(new Bogie("AC Chair Car", 56));
        trainConsist.add(new Bogie("First Class", 24));
        trainConsist.add(new Bogie("AC Chair Car", 56));
        trainConsist.add(new Bogie("General Coach", 90));

        System.out.println("Processing flat consist list for categorization...");

        // 2. Key Concept: Collectors.groupingBy()
        // This creates a Map where the Key is the Bogie Name
        // and the Value is a List of all Bogies with that name.
        Map<String, List<Bogie>> groupedBogies = trainConsist.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        // 3. Display the structured report
        System.out.println("\n--- Categorized Bogie Report ---");
        groupedBogies.forEach((type, list) -> {
            System.out.println("Category: " + type + " (Count: " + list.size() + ")");
            System.out.println("   Members: " + list);
        });

        // 4. Verify original list integrity
        System.out.println("\nTotal Bogies in System: " + trainConsist.size());
        System.out.println("Status: Flat data successfully transformed into hierarchical Map.");
    }
}