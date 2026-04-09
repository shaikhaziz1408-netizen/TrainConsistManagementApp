/**
 * ============================================================================
 * CUSTOM RUNTIME EXCEPTION - CargoSafetyException
 * ============================================================================
 */
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

/**
 * ============================================================================
 * DOMAIN MODEL - GoodsBogie
 * ============================================================================
 */
class GoodsBogie {
    private String shape;
    private String currentCargo = "Empty";

    public GoodsBogie(String shape) {
        this.shape = shape;
    }

    /**
     * Attempts to assign cargo with safety checks.
     * Demonstrates the use of custom runtime exceptions.
     */
    public void assignCargo(String cargo) {
        System.out.println(">>> Attempting to load " + cargo + " into " + shape + " bogie...");

        // Safety Rule: Petroleum MUST NOT be in a Rectangular bogie
        if (shape.equalsIgnoreCase("Rectangular") && cargo.equalsIgnoreCase("Petroleum")) {
            throw new CargoSafetyException("CRITICAL SAFETY VIOLATION: Petroleum requires Cylindrical bogies!");
        }

        this.currentCargo = cargo;
        System.out.println("✔ SUCCESS: Cargo assigned successfully.");
    }

    @Override
    public String toString() {
        return "GoodsBogie [" + shape + " | Cargo: " + currentCargo + "]";
    }
}

/**
 * ============================================================================
 * MAIN CLASS - TrainConsistManagementApp
 * ============================================================================
 * Use Case 15: Safe Cargo Assignment Using try-catch-finally
 * * Description:
 * This use case demonstrates structured exception handling. It ensures the
 * app stays stable even during high-risk operational errors.
 * * @version 15.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println("   === Train Consist Management App ===");
        System.out.println("=======================================\n");

        GoodsBogie rectangularBogie = new GoodsBogie("Rectangular");
        GoodsBogie cylindricalBogie = new GoodsBogie("Cylindrical");

        // Process Assignment 1: Safe
        processAssignment(cylindricalBogie, "Petroleum");

        // Process Assignment 2: Unsafe
        processAssignment(rectangularBogie, "Petroleum");

        System.out.println("\nFinal System Audit: All operations processed.");
    }

    /**
     * Demonstrates the try-catch-finally block structure.
     */
    private static void processAssignment(GoodsBogie bogie, String cargo) {
        try {
            bogie.assignCargo(cargo);
        } catch (CargoSafetyException e) {
            System.out.println("❌ CAUGHT ERROR: " + e.getMessage());
            System.out.println("ACTION: Assignment blocked for safety.");
        } finally {
            // This block ALWAYS runs, ensuring a log is created
            System.out.println("[AUDIT LOG]: Safety check completed for assignment attempt.");
        }
    }
}