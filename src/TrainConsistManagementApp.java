import java.util.LinkedHashSet;
import java.util.Set;

/**
 * ============================================================================
 * MAIN CLASS - TrainConsistManagementApp
 * ============================================================================
 * Use Case 5: Preserve Insertion Order of Bogies (LinkedHashSet)
 * * Description:
 * This use case demonstrates how to maintain the physical attachment order
 * while ensuring that every bogie in the consist is unique.
 * LinkedHashSet is used to prevent duplicate attachments without losing
 * the sequence of the train formation.
 * * @version 5.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println("   === Train Consist Management App ===");
        System.out.println("=======================================\n");

        // Key Concept: LinkedHashSet - Unique elements + Insertion Order
        Set<String> trainFormation = new LinkedHashSet<>();

        System.out.println("Attaching bogies to the engine...");

        // 1. ADD: Attaching bogies in a specific sequence
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        // 2. DEDUPLICATION: Attempting to add a duplicate intentionally
        System.out.println("Attempting to re-attach 'Sleeper' bogie...");
        boolean isAdded = trainFormation.add("Sleeper");

        if (!isAdded) {
            System.out.println("Validation: Duplicate 'Sleeper' rejected by the system.");
        }

        // 3. DISPLAY: Showing the ordered and unique formation
        System.out.println("\n--- Final Train Formation Order ---");
        // LinkedHashSet ensures that "Engine" remains first and "Guard" remains last
        int position = 1;
        for (String bogie : trainFormation) {
            System.out.println("Position " + position + ": " + bogie);
            position++;
        }

        System.out.println("\nStatus: Consist is unique and formation order is preserved.");
    }
}