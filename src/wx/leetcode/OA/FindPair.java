package wx.leetcode.OA;
import java.util.*;

public class FindPair {
    public static final int DIFF = 30;


    public static int[] findPairs(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[2];
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        target = target - DIFF;

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                int tmp = Math.max(nums[i], target - nums[i]);
                if (tmp > max) {
                    max = tmp;
                    res[0] = i;
                    res[1] = map.get(target - nums[i]);
                }

            }

            map.put(nums[i], i);

        }

        return res;


    }

    public static void main(String[] args) {
        int[] nums1 = {1, 10, 25, 35, 60};
        int target1 = 90;
        System.out.println(Arrays.toString(findPairs(nums1, target1)));
        int[] nums2 = {20, 50, 40, 25, 30, 10};
        int target2 = 90;
        System.out.println(Arrays.toString(findPairs(nums2, target2)));
        int[] nums3 = {50, 20, 10, 40, 25, 30};
        int target3 = 90;
        System.out.println(Arrays.toString(findPairs(nums3, target3)));
        int[] nums4 = {1, 2};
        int target4 = 90;
        System.out.println(Arrays.toString(findPairs(nums4, target4)));

    }

}
