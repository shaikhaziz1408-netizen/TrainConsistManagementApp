import java.util.Arrays;

/**
 * ============================================================================
 * MAIN CLASS - TrainConsistManagementApp
 * ============================================================================
 * Use Case 20: Exception Handling During Search Operations
 * * Description:
 * This use case implements defensive programming. Before performing a
 * search, the system validates the state of the collection. If the train
 * is empty, it throws an IllegalStateException to prevent invalid logic.
 * * @version 20.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println("   === Train Consist Management App ===");
        System.out.println("=======================================\n");

        // Scenario 1: Empty Consist
        String[] emptyConsist = {};
        System.out.println("--- Scenario 1: Searching an Empty Consist ---");
        try {
            performSearch(emptyConsist, "BG101");
        } catch (IllegalStateException e) {
            System.out.println("❌ STATE ERROR: " + e.getMessage());
        }

        // Scenario 2: Valid Consist
        String[] validConsist = {"BG309", "BG101", "BG550"};
        System.out.println("\n--- Scenario 2: Searching a Valid Consist ---");
        try {
            performSearch(validConsist, "BG101");
        } catch (IllegalStateException e) {
            System.out.println("❌ STATE ERROR: " + e.getMessage());
        }
    }

    /**
     * Performs an optimized Binary Search with State Validation.
     * @param bogieIds Array of IDs to search
     * @param key ID to find
     * @throws IllegalStateException if the array is null or empty
     */
    public static void performSearch(String[] bogieIds, String key) {
        // 1. Key Concept: State Validation (Defensive Programming)
        if (bogieIds == null || bogieIds.length == 0) {
            // 2. Key Concept: Throwing IllegalStateException
            throw new IllegalStateException("Search Failed: The train consist is empty. Please add bogies before searching.");
        }

        // Precondition: Binary Search requires sorted data
        Arrays.sort(bogieIds);

        int low = 0;
        int high = bogieIds.length - 1;
        boolean found = false;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = key.compareTo(bogieIds[mid]);

            if (comparison == 0) {
                System.out.println("✔ Result: Bogie " + key + " found at sorted position " + (mid + 1));
                found = true;
                break;
            } else if (comparison > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (!found) {
            System.out.println("ℹ Result: Bogie " + key + " is not in the current consist.");
        }
    }
}