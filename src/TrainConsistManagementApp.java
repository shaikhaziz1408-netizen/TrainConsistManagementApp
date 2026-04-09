import java.util.ArrayList;
import java.util.List;
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
        return String.format("Bogie: %-15s | Capacity: %d Seats", name, capacity);
    }
}

/**
 * ============================================================================
 * MAIN CLASS - TrainConsistManagementApp
 * ============================================================================
 * Use Case 8: Filter Passenger Bogies Using Streams
 * * Description:
 * This use case demonstrates the Stream API. We filter a master list to find
 * only high-capacity bogies (Capacity > 60) using a declarative pipeline.
 * * @version 8.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println("   === Train Consist Management App ===");
        System.out.println("=======================================\n");

        // 1. Initialize the Master List
        List<Bogie> masterBogieList = new ArrayList<>();
        masterBogieList.add(new Bogie("Sleeper", 72));
        masterBogieList.add(new Bogie("AC Chair Car", 56));
        masterBogieList.add(new Bogie("First Class", 24));
        masterBogieList.add(new Bogie("General Coach", 90));

        System.out.println("--- Full Passenger Bogie List ---");
        masterBogieList.forEach(System.out::println);

        // 2. Key Concept: Stream API Pipeline
        // filter: selects elements matching the condition
        // collect: converts the stream back into a List
        int threshold = 60;
        List<Bogie> highCapacityBogies = masterBogieList.stream()
                .filter(b -> b.getCapacity() > threshold)
                .collect(Collectors.toList());

        // 3. Display the results
        System.out.println("\n--- High Capacity Bogies ( > " + threshold + " Seats ) ---");
        if (highCapacityBogies.isEmpty()) {
            System.out.println("No bogies match the criteria.");
        } else {
            highCapacityBogies.forEach(System.out::println);
        }

        // 4. Verify Integrity: Original list should be untouched
        System.out.println("\nTotal Bogies in Master List: " + masterBogieList.size());
        System.out.println("Status: Stream filtering completed without modifying original data.");
    }
}