package homeWork;

import java.util.HashMap;
import java.util.Map;

public class TaskOne {

    public static void main(String[] args) {
        int[] numbs = {1, 2, 3, 1, 2, 3};
        System.out.println(containsNearbyDuplicate(numbs, 2));
    }

    public static boolean containsNearbyDuplicate(int[] numbs, int k) {
        Map<Integer, Integer> mapArr = new HashMap<>();
        for (int i = 0; i < numbs.length; i++) {
            if (mapArr.containsKey(numbs[i])) {
                if (i - mapArr.get(numbs[i]) <= k) {
                    return true;
                }
            }
            mapArr.put(numbs[i], i);
        }
        return false;
    }
}
