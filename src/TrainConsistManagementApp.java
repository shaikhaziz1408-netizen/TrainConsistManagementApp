import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * ============================================================================
 * DOMAIN MODEL - Bogie
 * ============================================================================
 * Represents a train bogie with a name and seating capacity.
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
        return String.format("Bogie: %-15s | Capacity: %d Seats", name, capacity);
    }
}

/**
 * ============================================================================
 * MAIN CLASS - TrainConsistManagementApp
 * ============================================================================
 * Use Case 7: Sort Bogies by Capacity (Comparator)
 * * Description:
 * This use case demonstrates how to sort custom objects using the Comparator
 * interface. We rank bogies from lowest to highest capacity.
 * * @version 7.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println("   === Train Consist Management App ===");
        System.out.println("=======================================\n");

        // 1. Create a List of Custom Objects
        List<Bogie> passengerBogies = new ArrayList<>();

        // 2. Add Bogie instances
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair Car", 56));
        passengerBogies.add(new Bogie("First Class", 24));
        passengerBogies.add(new Bogie("General Coach", 90));

        System.out.println("Current Unsorted Bogies:");
        passengerBogies.forEach(System.out::println);

        // 3. Key Concept: Custom Sorting using a Comparator
        // We sort by capacity in Ascending order
        passengerBogies.sort((b1, b2) -> Integer.compare(b1.getCapacity(), b2.getCapacity()));

        System.out.println("\n--- Sorted Bogies by Capacity (Ascending) ---");
        for (Bogie b : passengerBogies) {
            System.out.println(b);
        }

        System.out.println("\nStatus: Capacity-based planning report generated successfully.");
    }
}