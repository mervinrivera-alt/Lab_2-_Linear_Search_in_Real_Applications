import java.util.Scanner;

public class LibraryFinder {

      public static int findFirst(String[] items, String target) {
        for (int i = 0; i < items.length; i++) {
            System.out.println("index " + i + " -> comparison");
            if (items[i].equals(target)) {
                System.out.println("index " + i + " -> match -> stops");
                return i;               // first match → stop
            }
        }
        return -1;                      // not found
    }

    // -------------------------------------------------
    //  countMatches – returns the total number of occurrences
    // -------------------------------------------------
    public static int countMatches(String[] items, String target) {
        int count = 0;
        for (int i = 0; i < items.length; i++) {
            System.out.println("index " + i + " -> comparison");
            if (items[i].equals(target)) {
                System.out.println("index " + i + " -> match");
                count++;                // keep counting, do NOT stop
            }
        }
        return count;
    }

    // -------------------------------------------------
    //  main – user input, method calls, final display
    // -------------------------------------------------
    public static void main(String[] args) {
        String[] books = {"C", "Java", "DSA", "Java", "SQL"};

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the book title to find: ");
        String userTarget = scanner.nextLine();

        // ----- method headings (requirement 1) -----
        System.out.println("findFirst(\"" + userTarget + "\"):");
        int first = findFirst(books, userTarget);

        System.out.println("\ncountMatches(\"" + userTarget + "\"):");
        int total = countMatches(books, userTarget);

        // ----- final result lines (requirements 4‑6) -----
        if (first == -1) {
            System.out.println("findFirst -> no index found");
        } else {
            System.out.println("findFirst -> index: " + first);
        }
        System.out.println("countMatches -> occurrences: " + total);

        scanner.close();   // prevent resource memory leaks
    }
}