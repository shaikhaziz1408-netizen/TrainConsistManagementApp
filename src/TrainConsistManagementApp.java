import java.util.ArrayList;
import java.util.List;

/**
 * ============================================================================
 * MAIN CLASS - TrainConsistManagementApp
 * ============================================================================
 * Use Case 1: Initialize Train and Display Consist Summary
 * * Description:
 * This class serves as the entry point for the Train Consist Management App.
 * It initializes an empty ArrayList to hold bogies and displays the startup state.
 * * @version 1.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        // Printing the welcome message as per requirements
        System.out.println("=======================================");
        System.out.println("   === Train Consist Management App ===");
        System.out.println("=======================================\n");

        // Key Concept: Initializing a dynamic collection using the List interface
        // This will later hold our various bogie types (Passenger, Goods, etc.)
        List<String> trainBogies = new ArrayList<>();

        // Displaying initial state
        System.out.println("Initializing train consist...");

        // Key Concept: Using .size() to track the collection count
        System.out.println("Initial Bogie Count: " + trainBogies.size());

        System.out.println("\nStatus: System is ready for bogie attachment.");
    }
}