package wx.leetcode;
import java.util.*;

public class Leetcode3 {
    class Solution {
        /**
         3. Longest Substring Without Repeating Characters

         Given a string, find the length of the longest substring without repeating characters.

         Example 1:
         Input: "abcabcbb"
         Output: 3
         Explanation: The answer is "abc", with the length of 3.


         **/
        public int lengthOfLongestSubstring(String s) {
            /**

             经典题 双指针+Set
             **/
            if(s==null||s.length()==0)return 0;

            int i=0;
            int j=0;
            Set<Character> set=new HashSet<>();
            int len=0;

            while(i<s.length()&&j<s.length()){
                char ch=s.charAt(j);
                if(set.contains(ch)){
                    set.remove(s.charAt(i));//记的要删除！
                    i++;
                }else{
                    set.add(ch);
                    len=Math.max(len,j-i+1);
                    j++;
                }

            }

            return len;

        }
    }
}
