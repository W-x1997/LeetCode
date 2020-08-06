package wx.leetcode.OA;
import java.util.*;

public class Substrings {
    /**
     * Given a string s and an int k, return all unique substrings of s of size k with k distinct characters.
     * <p>
     * Example 1:
     * <p>
     * Input: s = "abcabc", k = 3
     * Output: ["abc", "bca", "cab"]
     * Example 2:
     * <p>
     * Input: s = "abacab", k = 3
     * Output: ["bac", "cab"]
     * Example 3:
     * <p>
     * Input: s = "awaglknagawunagwkwagl", k = 4
     * Output: ["wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag"]
     * Explanation:
     * Substrings in order are: "wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag", "wagl"
     * "wagl" is repeated twice, but is included in the output once.
     */

    private static List<String> getKSubstring(String s, int k) {
        Set<String> res = new HashSet<>();
        int prev = 0;
        int cur = 0;
        Set<Character>  set = new HashSet<>();

        while (cur < s.length()) {
            while (set.contains(s.charAt(cur))) {
                set.remove(s.charAt(prev));
                prev++;
            }
            set.add(s.charAt(cur));
            cur++;
            if (cur - prev == k) {
                res.add(s.substring(prev, cur));
                set.remove(s.charAt(prev));
                prev++;
            }

        }



        return new ArrayList<>(res);

    }


//    private static List<String> getKSubstring(String s, int k) {
//        Set<String> res = new HashSet<String>();
//        if (s == null || s.length() == 0)
//            return new ArrayList<>(res);
//        ;
//
//        Set<Character> window = new HashSet<>();
//
//        int left = 0;
//        int right = 0;
//        while (right < s.length()) {
//            char ch = s.charAt(right);
//            while(window.contains(ch) || window.size() >= k) {
//                window.remove(s.charAt(left));
//                left++;
//            }
//            window.add(ch);
//            right++;
//            if (right - left == k) {
//                res.add(new String(s.substring(left, right)));
//            }
//        }
//
//        return new ArrayList<>(res);
//
//
//    }

    public static void main(String[] args) {
        String s1="abcabc";//k=3
        String s2="abacab";//k=3
        String s3="awaglknagawunagwkwagl";//k=4
        String s4="aaabbccdeeeffgskwsiwsadf"; //k=3;

        System.out.println(getKSubstring(s1,3));
        System.out.println(getKSubstring(s2,3));
        System.out.println(getKSubstring(s3,4));
        System.out.println(getKSubstring(s4,5));

        //corner case
        System.out.println(getKSubstring("",2));
        System.out.println(getKSubstring("abcdefgh",1));


    }
}
