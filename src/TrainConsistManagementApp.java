import java.util.HashMap;
import java.util.Map;

/**
 * ============================================================================
 * MAIN CLASS - TrainConsistManagementApp
 * ============================================================================
 * Use Case 6: Map Bogie to Capacity (HashMap)
 * * Description:
 * This use case introduces Key-Value pairs. We use a HashMap to link bogie
 * names to their specific capacities (seats or load). This allows the
 * system to perform calculations and lookups efficiently.
 * * @version 6.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println("   === Train Consist Management App ===");
        System.out.println("=======================================\n");

        // Key Concept: HashMap - Key (String: Bogie Name) -> Value (Integer: Capacity)
        Map<String, Integer> bogieCapacities = new HashMap<>();

        // 1. PUT: Associating data with bogies
        // Mapping bogie types to their seating/load capacities
        bogieCapacities.put("Sleeper", 72);
        bogieCapacities.put("AC Chair Car", 56);
        bogieCapacities.put("First Class", 24);
        bogieCapacities.put("General Coach", 90);

        System.out.println("Bogie-Capacity mapping initialized.");

        // 2. ITERATION: Displaying the data using entrySet()
        // entrySet() allows us to access both the Key and Value in a single loop
        System.out.println("\n--- Bogie Capacity Summary ---");
        for (Map.Entry<String, Integer> entry : bogieCapacities.entrySet()) {
            System.out.println("Bogie Type: " + entry.getKey() + " | Capacity: " + entry.getValue() + " Seats");
        }

        // 3. FAST LOOKUP: Demonstrate O(1) retrieval
        String checkBogie = "AC Chair Car";
        System.out.println("\nFast Lookup Check:");
        System.out.println("Capacity of " + checkBogie + ": " + bogieCapacities.get(checkBogie) + " Seats");

        System.out.println("\nStatus: Operational attributes successfully mapped.");
    }
}