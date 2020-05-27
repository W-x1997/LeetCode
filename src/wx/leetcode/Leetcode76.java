package wx.leetcode;

public class Leetcode76 {
    class Solution {
        /**
         76. Minimum Window Substring

         Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

         Example:

         Input: S = "ADOBECODEBANC", T = "ABC"
         Output: "BANC"
         **/
        public String minWindow(String s, String t) {

            /**
             依然是经典的滑动窗口

             巧妙：要用一个map来存储t中的char 用一个matched来验证是否匹配
             ！！注意只有t包含的char map中才有可能为正

             **/
            if(s == null || s.length() < t.length() || s.length() == 0)
                return "";

            int i=0;
            int j=0;

            int matched=t.length();//用来判断是否已经匹配
            int min_len=Integer.MAX_VALUE;
            int min_start=0;

            int[] map=new int[128];
            for(char c:t.toCharArray())
                map[c]++;

            while(i<s.length()){
                char ch=s.charAt(i);
                if(map[ch]>0)
                    matched--;

                map[ch]--;  //！！ 注意只有t包含的char map中才有可能为正
                //通过matched==0，来判断是否已经完全匹配
                while(matched==0){
                    if(min_len>i-j+1){
                        min_len=i-j+1;
                        min_start=j;
                    }

                    char left=s.charAt(j);
                    map[left]++; //！！恢复
                    if(map[left]>0){
                        matched++; //！！ 注意只有t包含的char map中才有可能为正
                    }
                    j++;


                }
                i++;



            }

            if(min_len==Integer.MAX_VALUE)return "";
            return s.substring(min_start,min_start+min_len);

        }
    }
}
