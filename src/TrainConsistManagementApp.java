import java.util.ArrayList;
import java.util.List;

/**
 * ============================================================================
 * CUSTOM EXCEPTION - InvalidCapacityException
 * ============================================================================
 * A domain-specific exception to handle railway business rule violations.
 */
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

/**
 * ============================================================================
 * DOMAIN MODEL - Bogie
 * ============================================================================
 */
class Bogie {
    private String name;
    private int capacity;

    /**
     * Constructor with Fail-Fast Validation
     * @throws InvalidCapacityException if capacity is 0 or negative
     */
    public Bogie(String name, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity Error: [" + name + "] must have a capacity greater than zero.");
        }
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Bogie: " + name + " (Capacity: " + capacity + ")";
    }
}

/**
 * ============================================================================
 * MAIN CLASS - TrainConsistManagementApp
 * ============================================================================
 * Use Case 14: Handle Invalid Bogie Capacity (Custom Exception)
 * * Description:
 * This use case ensures system integrity by preventing the creation of
 * invalid bogies. We use a try-catch block to handle the custom exception.
 * * @version 14.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println("   === Train Consist Management App ===");
        System.out.println("=======================================\n");

        List<Bogie> trainConsist = new ArrayList<>();

        // 1. Attempting to create bogies
        System.out.println("--- Starting Bogie Allocation ---");

        // Scenario A: Valid Bogie
        try {
            Bogie b1 = new Bogie("Sleeper", 72);
            trainConsist.add(b1);
            System.out.println("✔ SUCCESS: " + b1 + " added to consist.");
        } catch (InvalidCapacityException e) {
            System.out.println("❌ ERROR: " + e.getMessage());
        }

        // Scenario B: Invalid Capacity (Zero)
        try {
            System.out.println("\nAttempting to add a zero-capacity bogie...");
            Bogie b2 = new Bogie("General", 0);
            trainConsist.add(b2);
        } catch (InvalidCapacityException e) {
            System.out.println("❌ CAUGHT EXCEPTION: " + e.getMessage());
        }

        // Scenario C: Invalid Capacity (Negative)
        try {
            System.out.println("\nAttempting to add a negative-capacity bogie...");
            Bogie b3 = new Bogie("AC Tier", -10);
            trainConsist.add(b3);
        } catch (InvalidCapacityException e) {
            System.out.println("❌ CAUGHT EXCEPTION: " + e.getMessage());
        }

        // 2. Final Summary
        System.out.println("\n--- Final Valid Consist ---");
        System.out.println("Total Valid Bogies: " + trainConsist.size());
        trainConsist.forEach(System.out::println);

        System.out.println("\nStatus: Defensive validation active. Data integrity maintained.");
    }
}