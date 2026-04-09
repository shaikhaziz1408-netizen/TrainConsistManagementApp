import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ============================================================================
 * MAIN CLASS - TrainConsistManagementApp
 * ============================================================================
 * Use Case 11: Validate Train ID & Cargo Codes (Regex)
 * * Description:
 * This use case enforces data integrity using Regular Expressions.
 * We validate that Train IDs follow the 'TRN-dddd' format and
 * Cargo Codes follow the 'PET-AA' format.
 * * @version 11.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println("   === Train Consist Management App ===");
        System.out.println("=======================================\n");

        // 1. Key Concept: Defining Regex Patterns
        // TRN-\\d{4} : Starts with 'TRN-', followed by exactly 4 digits
        // PET-[A-Z]{2} : Starts with 'PET-', followed by exactly 2 uppercase letters
        String trainIdRegex = "TRN-\\d{4}";
        String cargoCodeRegex = "PET-[A-Z]{2}";

        // 2. Compiling Patterns for efficiency
        Pattern trainIdPattern = Pattern.compile(trainIdRegex);
        Pattern cargoCodePattern = Pattern.compile(cargoCodeRegex);

        // 3. Testing Inputs
        String[] testTrainIds = {"TRN-1234", "TRAIN12", "TRN-123", "TRN-12345"};
        String[] testCargoCodes = {"PET-AB", "PET-ab", "PET123", "AB-PET"};

        System.out.println("--- Validating Train IDs ---");
        for (String id : testTrainIds) {
            Matcher matcher = trainIdPattern.matcher(id);
            if (matcher.matches()) {
                System.out.println("✔ [" + id + "] : VALID FORMAT");
            } else {
                System.out.println("❌ [" + id + "] : INVALID (Expected TRN-XXXX)");
            }
        }

        System.out.println("\n--- Validating Cargo Codes ---");
        for (String code : testCargoCodes) {
            Matcher matcher = cargoCodePattern.matcher(code);
            if (matcher.matches()) {
                System.out.println("✔ [" + code + "] : VALID FORMAT");
            } else {
                System.out.println("❌ [" + code + "] : INVALID (Expected PET-AA)");
            }
        }

        System.out.println("\nStatus: Validation engine operational. System protected from malformed data.");
    }
}