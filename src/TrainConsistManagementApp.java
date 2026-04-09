import java.util.Arrays;

/**
 * ============================================================================
 * MAIN CLASS - TrainConsistManagementApp
 * ============================================================================
 * Use Case 16: Sort Passenger Bogies by Capacity (Bubble Sort)
 * * Description:
 * This use case demonstrates the fundamental Bubble Sort algorithm.
 * We manually compare and swap adjacent elements to sort bogie
 * capacities in ascending order.
 * * @version 16.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println("   === Train Consist Management App ===");
        System.out.println("=======================================\n");

        // 1. Initialize an array of passenger bogie capacities
        int[] capacities = {72, 56, 24, 70, 60};

        System.out.println("Original Capacities: " + Arrays.toString(capacities));

        // 2. Key Concept: Bubble Sort Algorithm
        // Outer loop: Controls the number of passes
        // Inner loop: Compares adjacent elements and 'bubbles' the largest to the end
        int n = capacities.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // If the left element is greater than the right, swap them
                if (capacities[j] > capacities[j + 1]) {

                    // Swapping Logic using a temporary variable
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;

                    System.out.println("Swapping " + capacities[j+1] + " and " + capacities[j]);
                }
            }
        }

        // 3. Display Result
        System.out.println("\n--- Sorted Bogie Capacities (Manual Bubble Sort) ---");
        System.out.print("[");
        for (int i = 0; i < capacities.length; i++) {
            System.out.print(capacities[i] + (i == capacities.length - 1 ? "" : ", "));
        }
        System.out.println("]");

        System.out.println("\nStatus: Manual sorting completed. Algorithm logic verified.");
    }
}