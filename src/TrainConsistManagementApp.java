import java.util.Arrays;
import java.util.Scanner;

public class TrainConsistManagementApp {

    // Binary Search method for Bogie IDs
    public static boolean binarySearch(String[] bogieIds, String key) {
        // Handle empty array case
        if (bogieIds == null || bogieIds.length == 0) {
            System.out.println("No bogies available in the system.");
            return false;
        }

        // Ensure input is sorted before searching
        Arrays.sort(bogieIds);

        int low = 0;
        int high = bogieIds.length - 1;

        System.out.println("\n--- Binary Search Execution ---");
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
                System.out.println("Key is smaller than mid element → Searching Left Half");
                high = mid - 1;
            } else {
                System.out.println("Key is greater than mid element → Searching Right Half");
                low = mid + 1;
            }
        }

        System.out.println("Result: Bogie ID " + key + " not found.");
        System.out.println("Search Status: NOT FOUND ❌");
        return false;
    }

    // Main method for demonstration
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== UC19: Binary Search for Bogie ID (Optimized Searching) ===");
        System.out.print("Enter number of bogies: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] bogieIds = new String[n];
        System.out.println("Enter Bogie IDs:");
        for (int i = 0; i < n; i++) {
            bogieIds[i] = sc.nextLine();
        }

        System.out.print("Enter Bogie ID to search: ");
        String key = sc.nextLine();

        boolean found = binarySearch(bogieIds, key);

        System.out.println("\n--- Final Output ---");
        if (found) {
            System.out.println("Bogie ID " + key + " found successfully!");
        } else {
            System.out.println("Bogie ID " + key + " not found in the system.");
        }

        System.out.println("=== End of UC19 Execution ===");
        sc.close();
    }
}
