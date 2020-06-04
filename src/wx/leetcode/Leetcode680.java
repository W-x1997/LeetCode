package wx.leetcode;

public class Leetcode680 {
    /**
     * 680. Valid Palindrome II
     * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
     */

    class Solution {

        /**
         * 双指针 或者 递归
         * @param s
         * @return
         */
        public boolean validPalindrome2(String s) {
            boolean removed=false;
            int i = 0, j = s.length()-1;
            while (i < j) {
                if (s.charAt(i) != s.charAt(j)) {
                    if (removed) {
                        return false;
                    } else {
                        removed = true;
                        if (validPalindrome(s.substring(i+1, j+1)) || validPalindrome(s.substring(i, j)))
                            return true;
                        else
                            return false;
                    }
                }

                i++;
                j--;
            }

            return true;
        }
        public boolean isPalindromeRange(String s, int i, int j) {
            for (int k = i; k <= i + (j - i) / 2; k++) {
                if (s.charAt(k) != s.charAt(j - k + i)) return false;
            }
            return true;
        }
        public boolean validPalindrome(String s) {
            for (int i = 0; i < s.length() / 2; i++) {
                if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                    int j = s.length() - 1 - i;
                    return (isPalindromeRange(s, i+1, j) ||
                            isPalindromeRange(s, i, j-1));
                }
            }
            return true;
        }
    }
// bcabbab
}
