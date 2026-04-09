import java.util.Arrays;

/**
 * ============================================================================
 * MAIN CLASS - TrainConsistManagementApp
 * ============================================================================
 * Use Case 17: Sort Bogie Names Using Arrays.sort()
 * * Description:
 * This use case demonstrates the use of Java's optimized built-in sorting.
 * We sort bogie type names alphabetically using Arrays.sort(), which is
 * more efficient than manual algorithms for production environments.
 * * @version 17.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println("   === Train Consist Management App ===");
        System.out.println("=======================================\n");

        // 1. Initialize an array of unsorted bogie type names
        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("Original Bogie Names: " + Arrays.toString(bogieNames));

        // 2. Key Concept: Using the optimized built-in Arrays.sort()
        // This method uses a Dual-Pivot Quicksort for primitives and
        // TimSort for objects (Strings), providing O(n log n) performance.
        System.out.println("\nSorting bogie names alphabetically...");
        Arrays.sort(bogieNames);

        // 3. Display the sorted result using Arrays.toString()
        System.out.println("--- Sorted Bogie Names (Natural Order) ---");
        System.out.println(Arrays.toString(bogieNames));

        // 4. Verify alphabetical order
        System.out.println("\nStatus: Production-level sorting implemented. Output is alphabetical.");
    }
}