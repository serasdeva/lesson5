package homeWork;

import java.util.HashMap;
import java.util.Map;

public class TaskTwo {
    static String[] words1 = {"a", "ab"};
    static String[] words2 = {"a", "a", "a", "ab"};

    public static void main(String[] args) {
        System.out.println(countWords(words1, words2));
    }

    public static int countWords(String[] words1, String[] words2) {
        if (words1.length > words2.length) {
            return countWords(words2, words1);
        }

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words1.length; i++) {
            map.putIfAbsent(words1[i], 0);
            map.put(words1[i], map.get(words1[i]) + 1);
        }

        int ans = 0;
        for (int i = 0; i < words2.length; i++) {
            if (map.containsKey(words2[i]) && map.get(words2[i]) < 2) {
                map.put(words2[i], map.get(words2[i]) - 1);
            }
        }
        for (var e : map.entrySet()) {
            if (e.getValue() == 0) {
                ans++;
            }
        }
        return ans;
    }
}
