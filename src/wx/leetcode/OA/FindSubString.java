package wx.leetcode.OA;
import java.util.*;
public class FindSubString {
    /**
     * Given a string s and an int k, return an int representing the number of substrings (not unique) of s with exactly k distinct characters. If the given string doesn't have k distinct characters, return 0.
     * https://leetcode.com/problems/subarrays-with-k-different-integers
     *
     * Example 1:
     *
     * Input: s = "pqpqs", k = 2
     * Output: 7
     * Explanation: ["pq", "pqp", "pqpq", "qp", "qpq", "pq", "qs"]
     * Example 2:
     *
     * Input: s = "aabab", k = 3
     * Output: 0
     * Constraints:
     *
     * The input string consists of only lowercase English letters [a-z]
     * 0 ≤ k ≤ 26
     * @param s
     * @param k
     * @return
     */

    public static int findSubstring1(String s, int k) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                set.add(s.charAt(j));
                if (set.size() == k)
                    res++;
                if (set.size() > k) {
                    break;
                }

            }

        }
        return res;

    }

    // refer from:
    // https://leetcode.com/problems/subarrays-with-k-different-integers/discuss/523136/JavaC%2B%2BPython-Sliding-Window
    public static int findSubstring2(String s, int k) {
        return atMost(s, k) - atMost(s, k - 1);
    }

    private static int atMost(String s, int k) {
        int i = 0, j = 0, res = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (j < s.length()) {
            char c = s.charAt(j);
            // when add a new character to map, reduce k
            if (map.getOrDefault(c, 0) == 0) k--;
            map.put(c, map.getOrDefault(c, 0) + 1);
            // if the number of distinct char has exceeded k, remove the char at starting position i
            while (k < 0) {
                char r = s.charAt(i);
                map.put(r, map.getOrDefault(r, 0) - 1);
                if (map.get(r) == 0) k++;
                i++;
            }
            j++;
            res += (j - i + 1);
        }
        return res;
    }


    /**
     * i - j + 1 is essentially the length of the subarray, for a subarray with length N, there are at most k (k<=n) different permutations of it.
     * for [1], the number of permutation is 1 ([1])
     * for [1, 2], the number of permutation is 3 ([1], [2], and [1, 2]), in another way, at_most_2([1, 2]) = exact(2) + at_most_1([1, 2]) = exact(2) + at_most_1([1]) + at_most_1([2])
     * for [1, 2, 3], the number of permutation is 6 ([1], [2], [3] [1,2], [2,3], [1,2,3])
     *
     * we can see that at_most([...]) is an aggregate value, so if we want to calculate at_most([1, 2, 3])
     *
     * res += 1
     * res += 2
     * res += 3
     * and we get finally res => 6
     *
     * since we calculate all at_most less than K, we can simply get it by res += i - j + 1
     */
}
