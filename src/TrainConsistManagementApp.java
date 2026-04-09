import java.util.LinkedList;

/**
 * ============================================================================
 * MAIN CLASS - TrainConsistManagementApp
 * ============================================================================
 * Use Case 4: Maintain Ordered Bogie IDs (LinkedList)
 * * Description:
 * This use case models the physical chaining of a train. Unlike ArrayList,
 * LinkedList allows for efficient insertions at the head, tail, or middle,
 * which mirrors how bogies are shunted in a railway yard.
 * * @version 4.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println("   === Train Consist Management App ===");
        System.out.println("=======================================\n");

        // Key Concept: LinkedList for physical chaining and efficient shunting
        LinkedList<String> trainConsist = new LinkedList<>();

        // 1. ADD: Building the initial train sequence
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC Coach");
        trainConsist.add("Cargo");
        trainConsist.add("Guard Coach");

        System.out.println("Initial Sequence: " + trainConsist);

        // 2. INSERT: Adding a Pantry Car at Position 2 (Index 2)
        // In a LinkedList, this just updates the node pointers
        System.out.println("\nInserting 'Pantry Car' at position 3...");
        trainConsist.add(2, "Pantry Car");

        // 3. REMOVE: Detaching bogies from both ends
        System.out.println("Detaching first and last bogies...");
        trainConsist.removeFirst(); // Removes Engine
        trainConsist.removeLast();  // Removes Guard Coach

        // 4. DISPLAY: Final ordered consist
        System.out.println("\n--- Final Ordered Train Consist ---");
        for (int i = 0; i < trainConsist.size(); i++) {
            System.out.println("Bogie " + (i + 1) + ": " + trainConsist.get(i));
        }

        System.out.println("\nStatus: Consist ordering maintained via node chaining.");
    }
}