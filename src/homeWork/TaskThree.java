package homeWork;

import java.util.*;

public class TaskThree {
    static int[] nums1 = {1, 2, 2, 1};
    static int[] nums2 = {2, 2};

    public static void main(String[] args) {
        int[] ans = intersect(nums1, nums2);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        List<Integer> inter = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums1) {
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
        }

        for (int num : nums2) {
            if (map.containsKey(num)) {
                inter.add(num);
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0) {
                    map.remove(num);
                }
            }
        }

        int[] ans = new int[inter.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = inter.get(i);
        }

        return ans;
    }
}
