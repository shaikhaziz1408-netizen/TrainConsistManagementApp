import java.util.Arrays;

/**
 * ============================================================================
 * MAIN CLASS - TrainConsistManagementApp
 * ============================================================================
 * Use Case 19: Binary Search for Bogie ID (Optimized Searching)
 * * Description:
 * This use case implements the Binary Search algorithm. It requires sorted
 * data to function and uses a divide-and-conquer strategy to find target
 * IDs in logarithmic time.
 * * @version 19.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println("   === Train Consist Management App ===");
        System.out.println("=======================================\n");

        // 1. Unsorted input (Precondition for Binary Search is sorted data)
        String[] bogieIds = {"BG309", "BG101", "BG550", "BG205", "BG412"};

        // 2. Ensuring data is sorted before searching
        System.out.println("Sorting bogie IDs to satisfy Binary Search requirements...");
        Arrays.sort(bogieIds);
        System.out.println("Sorted Consist: " + Arrays.toString(bogieIds));

        // 3. Search parameters
        String searchKey = "BG412";
        System.out.println("\nInitiating Binary Search for: " + searchKey);

        // 4. Binary Search Logic
        int low = 0;
        int high = bogieIds.length - 1;
        boolean isFound = false;

        while (low <= high) {
            // Compute middle index
            int mid = low + (high - low) / 2;

            // Compare searchKey with mid element using compareTo()
            int res = searchKey.compareTo(bogieIds[mid]);

            System.out.println("Checking Mid-Point (Index " + mid + "): " + bogieIds[mid]);

            if (res == 0) {
                System.out.println("\n✔ MATCH FOUND: Bogie " + searchKey + " located at sorted index " + mid);
                isFound = true;
                break;
            }

            if (res > 0) {
                // Key is in the right half
                low = mid + 1;
            } else {
                // Key is in the left half
                high = mid - 1;
            }
        }

        if (!isFound) {
            System.out.println("\n❌ SEARCH COMPLETED: Bogie " + searchKey + " not found in the registry.");
        }

        System.out.println("\nStatus: Binary search optimization completed.");
    }
}