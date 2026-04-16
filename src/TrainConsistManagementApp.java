import java.util.Arrays;

public class TrainConsistManagementAppUC20 {

    // Defensive Search Method with Exception Handling
    public static boolean searchBogie(String[] bogieIds, String key) {
        // State validation: check if bogies exist
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("Error: No bogies available in the train consist. Search operation cannot proceed.");
        }

        // Ensure sorted input
        Arrays.sort(bogieIds);

        int low = 0;
        int high = bogieIds.length - 1;

        System.out.println("\n--- UC20: Exception Handling During Search ---");
        System.out.println("Searching for Bogie ID: " + key);
        System.out.println("Sorted Bogie List: " + Arrays.toString(bogieIds));

        while (low <= high) {
            int mid = (low + high) / 2;
            System.out.println("Low: " + low + " | Mid: " + mid + " | High: " + high);
            System.out.println("Comparing with: " + bogieIds[mid]);

            int comparison = key.compareTo(bogieIds[mid]);

            if (comparison == 0) {
                System.out.println("Result: Bogie ID " + key + " found at position " + mid);
                System.out.println("Search Status: SUCCESS ✅");
                return true;
            } else if (comparison < 0) {
                System.out.println("Key is smaller → Searching Left Half");
                high = mid - 1;
            } else {
                System.out.println("Key is greater → Searching Right Half");
                low = mid + 1;
            }
        }

        System.out.println("Result: Bogie ID " + key + " not found.");
        System.out.println("Search Status: NOT FOUND ❌");
        return false;
    }

    // Demo main method
    public static void main(String[] args) {
        try {
            String[] bogies = {}; // Empty case
            searchBogie(bogies, "BG101");
        } catch (IllegalStateException e) {
            System.out.println("\n--- Exception Triggered ---");
            System.out.println(e.getMessage());
            System.out.println("Search Status: FAIL-FAST ❌");
        }

        // Valid case
        String[] bogies2 = {"BG101","BG205","BG309"};
        searchBogie(bogies2, "BG205");
    }
}
