package Automation4ME.TestComponents;
import java.util.*;

class Main {

    // __define-ocg__
    public static boolean TreeConstructor(String[] strArr) {
        Map<Integer, Integer> parentMap = new HashMap<>();

        for (String pair : strArr) {
            pair = pair.replaceAll("[^0-9,]", "");
            String[] nodes = pair.split(",");
            int child = Integer.parseInt(nodes[0]);
            int parent = Integer.parseInt(nodes[1]);

            if (parentMap.containsKey(child)) {
                return false; // Duplicate child found
            }

            parentMap.put(child, parent);
        }

        // Check if each child has only one parent
        Set<Integer> parents = new HashSet<>(parentMap.values());
        return parents.size() == parentMap.size() - 1;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(TreeConstructor(new String[] {"(1,2)", "(2,4)", "(5,7)", "(7,2)", "(9,5)"})); // true
        System.out.println(TreeConstructor(new String[] {"(1,2)", "(3,2)", "(2,12)", "(5,2)"})); // false
    }
}
