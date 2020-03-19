package wx.leetcode;

import java.util.HashMap;

public class Leetcode409 {
    /**
     *
     * 409. Longest Palindrome
     * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
     *
     * This is case sensitive, for example "Aa" is not considered a palindrome here.
     *
     * Note:
     * Assume the length of given string will not exceed 1,010.
     *
     * Example:
     *
     * Input:
     * "abccccdd"
     *
     * Output:
     * 7
     *
     * Explanation:
     * One longest palindrome that can be built is "dccaccd", whose length is 7.
     *
     */
    class Solution {
        public int longestPalindrome(String s) {
            if(s==null||s.length()==0)
                return 0;
            int res=0;

            HashMap<Character,Integer> map=new HashMap<Character,Integer>();
            for(int i=0;i<s.length();i++){
                char ch=s.charAt(i);
                if(map.containsKey(ch)){
                    map.put(ch,map.get(ch)+1);
                }else
                    map.put(ch,1);

            }
            int odd_max=0;
            int flag=0;
            for(Character ch:map.keySet()){
                int num=map.get(ch);
                if(num%2==0)
                    res=res+num;
                else{
                    res=res+num-1;
                    flag=1;
                }

            }
            if(flag==1)
                res=res+1;

            return res;


        }
    }
}
