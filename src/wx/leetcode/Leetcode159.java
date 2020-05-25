package wx.leetcode;

import java.util.Collections;
import java.util.HashMap;

public class Leetcode159 {
    class Solution {
        /**

         159. Longest Substring with At Most Two Distinct Characters

         Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.

         Input: "eceba"
         Output: 3
         Explanation: t is "ece" which its length is 3.

         **/

        public int lengthOfLongestSubstringTwoDistinct(String s) {

            /**
             这道题和之前有一道最长无重复的连续字串类似 都是双指针滑动窗口
             但这道题需要用hashmap来保存最后出现的下班
             主要是 删除的时候 需要删除 hashmap中 最小的那个 ！！不是第一次出现坐标的最小值 而是最后一次出现的最小值 即hashmap中value的最小值！！！

             **/
            int n=s.length();
            if(s==null||n==0)return 0;

            HashMap<Character,Integer> map=new HashMap<>();
            int left=0;
            int right=0;

            int max_len=0;

            while(right<n){
                char ch=s.charAt(right);
                if(map.size()<3){
                    map.put(ch,right);
                    right++;
                }

                if(map.size()>=3){
                    int todelete=Collections.min(map.values());//!!!!超过三个就删掉当前所有元素中 最后出现的位置中 最靠前的元素！！！
                    map.remove(s.charAt(todelete));
                    left=todelete+1;


                }
                max_len=Math.max(max_len,right-left);//因为这时候right指向下一个


            }
            return max_len;

        }
    }
}
