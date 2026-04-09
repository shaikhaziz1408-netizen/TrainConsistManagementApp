import java.util.Scanner;

/**
 * ============================================================================
 * MAIN CLASS - TrainConsistManagementApp
 * ============================================================================
 * Use Case 18: Linear Search for Bogie ID (Array-Based Searching)
 * * Description:
 * This use case demonstrates the Linear Search algorithm. We traverse an
 * unsorted array of bogie IDs sequentially to find a specific target ID.
 * * @version 18.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println("   === Train Consist Management App ===");
        System.out.println("=======================================\n");

        // 1. Initialize an unsorted array of bogie IDs
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // 2. Define the search key (the ID we want to find)
        String searchKey = "BG309";
        boolean isFound = false;

        System.out.println("Initiating Linear Search for: " + searchKey);

        // 3. Key Concept: Sequential Traversal
        // We visit each index from 0 to n-1
        for (int i = 0; i < bogieIds.length; i++) {
            System.out.println("Checking Position " + (i + 1) + ": " + bogieIds[i]);

            // 4. Key Concept: Equality Comparison using equals()
            if (bogieIds[i].equals(searchKey)) {
                isFound = true;
                // 5. Key Concept: Early Termination (Stop searching once found)
                System.out.println("\n✔ MATCH FOUND: Bogie " + searchKey + " located at position " + (i + 1));
                break;
            }
        }

        // 6. Final Result
        if (!isFound) {
            System.out.println("\n❌ SEARCH COMPLETED: Bogie " + searchKey + " not found in the consist.");
        }

        System.out.println("\nStatus: Linear search traversal finished.");
    }
}