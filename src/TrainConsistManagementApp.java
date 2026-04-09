import java.util.ArrayList;
import java.util.List;

/**
 * ============================================================================
 * DOMAIN MODEL - GoodsBogie
 * ============================================================================
 */
class GoodsBogie {
    private String type; // e.g., Cylindrical, Open, Box
    private String cargo; // e.g., Petroleum, Coal, Grain

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() { return type; }
    public String getCargo() { return cargo; }

    @Override
    public String toString() {
        return String.format("[%s Bogie carrying %s]", type, cargo);
    }
}

/**
 * ============================================================================
 * MAIN CLASS - TrainConsistManagementApp
 * ============================================================================
 * Use Case 12: Safety Compliance Check for Goods Bogies
 * * Description:
 * This use case enforces critical safety rules. Cylindrical bogies are
 * strictly restricted to 'Petroleum' cargo. We use allMatch() to ensure
 * 100% compliance across the consist.
 * * @version 12.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println("   === Train Consist Management App ===");
        System.out.println("=======================================\n");

        // 1. Initialize Goods Bogies
        List<GoodsBogie> goodsConsist = new ArrayList<>();
        goodsConsist.add(new GoodsBogie("Open", "Coal"));
        goodsConsist.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsConsist.add(new GoodsBogie("Box", "Grain"));

        // Scenario A: Valid Train
        System.out.println("Checking Safety Compliance for Train A...");
        validateSafety(goodsConsist);

        // Scenario B: Invalid Train (Violation)
        System.out.println("\nAdding an unsafe bogie (Cylindrical with Coal) to Train B...");
        List<GoodsBogie> unsafeConsist = new ArrayList<>(goodsConsist);
        unsafeConsist.add(new GoodsBogie("Cylindrical", "Coal"));
        validateSafety(unsafeConsist);
    }

    /**
     * Uses Stream.allMatch() to verify safety rules.
     */
    private static void validateSafety(List<GoodsBogie> bogies) {
        // Key Concept: allMatch() with conditional logic
        // Rule: IF type is Cylindrical, THEN cargo MUST be Petroleum.
        // Logic: (Not Cylindrical) OR (Is Petroleum)
        boolean isSafe = bogies.stream().allMatch(b ->
                !b.getType().equalsIgnoreCase("Cylindrical") ||
                        b.getCargo().equalsIgnoreCase("Petroleum")
        );

        System.out.println("Consist Check: " + bogies);
        if (isSafe) {
            System.out.println("✔ RESULT: Safety Compliance Passed. Train is clear for departure.");
        } else {
            System.out.println("❌ RESULT: SAFETY VIOLATION DETECTED! Unsafe cargo assignment found.");
        }
    }
}