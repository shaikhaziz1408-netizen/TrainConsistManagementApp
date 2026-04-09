import java.util.ArrayList;
import java.util.List;

/**
 * ============================================================================
 * MAIN CLASS - TrainConsistManagementApp
 * ============================================================================
 * Use Case 1: Initialize Train and Display Consist Summary
 * * Description:
 * This class represents the entry point for managing a train's composition.
 * At this stage, we initialize a basic list of coaches and display them.
 * * Key Concepts:
 * - List (ArrayList): Used to maintain the ordered sequence of coaches.
 * - String Literals: Representing different coach types.
 * * @author Developer
 * @version 1.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println("   Train Consist Management System v1.0");
        System.out.println("=======================================\n");

        // UC1: Initializing the train consist using a dynamic list
        List<String> trainConsist = new ArrayList<>();

        // Adding basic engine and initial coaches
        trainConsist.add("Engine (WAP-7)");
        trainConsist.add("Power Car");
        trainConsist.add("General Coach (G1)");
        trainConsist.add("Sleeper Coach (S1)");
        trainConsist.add("AC 3-Tier (B1)");
        trainConsist.add("Power Car");

        System.out.println("--- Current Train Composition ---");
        for (int i = 0; i < trainConsist.size(); i++) {
            System.out.println("Position " + (i + 1) + ": " + trainConsist.get(i));
        }

        System.out.println("\nTotal Coaches (including Engine): " + trainConsist.size());
        System.out.println("System initialized successfully.");
    }
}