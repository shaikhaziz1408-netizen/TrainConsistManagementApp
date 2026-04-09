import java.util.ArrayList;
import java.util.List;

/**
 * ============================================================================
 * MAIN CLASS - TrainConsistManagementApp
 * ============================================================================
 * Use Case 2: Add Passenger Bogies to Train (ArrayList Operations)
 * * Description:
 * This use case demonstrates dynamic list management. We simulate attaching
 * passenger bogies, removing a specific coach, and checking for existence.
 * * @version 2.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println("   === Train Consist Management App ===");
        System.out.println("=======================================\n");

        // Key Concept: ArrayList for resizable collection
        List<String> passengerBogies = new ArrayList<>();

        // 1. ADD: Attaching passenger bogies
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        System.out.println("Bogies added: Sleeper, AC Chair, First Class.");
        System.out.println("Current Consist: " + passengerBogies);

        // 2. REMOVE: Detaching a specific bogie
        String bogieToRemove = "AC Chair";
        passengerBogies.remove(bogieToRemove);
        System.out.println("\nDetaching: " + bogieToRemove);
        System.out.println("Updated Consist: " + passengerBogies);

        // 3. CONTAINS: Checking for existence
        String searchBogie = "Sleeper";
        System.out.println("\nChecking for: " + searchBogie);
        if (passengerBogies.contains(searchBogie)) {
            System.out.println("Result: " + searchBogie + " is attached to the train.");
        } else {
            System.out.println("Result: " + searchBogie + " is not in the consist.");
        }

        // Final State
        System.out.println("\nFinal Bogie Count: " + passengerBogies.size());
        System.out.println("Consist Summary: " + passengerBogies);
    }
}