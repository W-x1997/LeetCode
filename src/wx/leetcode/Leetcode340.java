package wx.leetcode;
import java.util.*;
public class Leetcode340 {
    /**
     * 340. Longest Substring with At Most K Distinct Characters
     *
     * Given a string, find the length of the longest substring T that contains at most k distinct characters.
     *
     * Example 1:
     *
     * Input: s = "eceba", k = 2
     * Output: 3
     * Explanation: T is "ece" which its length is 3.
     *
     */
    class Solution {
        public int lengthOfLongestSubstringKDistinct(String s, int k) {

            /**
             和leetcode 159 一摸一样

             双指针+Hashmap

             每次遇到一个字符都加入到map
             如果map 大小超过k 则删除一个最早 最后 出现的！！ 这里用Collections.min(map.values())
             然后让left坐标移动到下一个
             **/
            if(s==null||s.length()==0||k==0)
                return 0;

            int left=0;
            int right=0;

            HashMap<Character,Integer> map=new HashMap<>();// char and its position

            int max_len=0;

            while(right<s.length()){
                map.put(s.charAt(right),right);
                right++;

                if(map.size()==k+1){
                    int delete=Collections.min(map.values());
                    map.remove(s.charAt(delete));
                    left=delete+1;
                }
                max_len=Math.max(max_len,right-left);

            }



            return max_len;
        }
    }


}
