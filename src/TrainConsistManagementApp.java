import java.util.HashSet;
import java.util.Set;

/**
 * ============================================================================
 * MAIN CLASS - TrainConsistManagementApp
 * ============================================================================
 * Use Case 3: Track Unique Bogie IDs (Set – HashSet)
 * * Description:
 * This use case introduces the concept of uniqueness. We use a HashSet to
 * store bogie IDs, ensuring that no two bogies share the same identification.
 * Unlike a List, a Set will automatically reject duplicate entries.
 * * @version 3.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println("   === Train Consist Management App ===");
        System.out.println("=======================================\n");

        // Key Concept: HashSet for uniqueness and fast lookup
        Set<String> bogieIds = new HashSet<>();

        System.out.println("Registering bogie IDs...");

        // 1. Adding unique bogie IDs
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");

        // 2. Intentionally adding duplicate IDs to test deduplication
        System.out.println("Attempting to add duplicate IDs: BG101, BG102...");
        bogieIds.add("BG101");
        bogieIds.add("BG102");

        // 3. Display the final set
        System.out.println("\n--- Unique Bogie ID Registry ---");
        System.out.println("Current IDs: " + bogieIds);

        // Key Concept: Automatic Deduplication
        System.out.println("Total Unique Bogies: " + bogieIds.size());

        System.out.println("\nStatus: Uniqueness enforced. No duplicate IDs allowed.");
    }
}