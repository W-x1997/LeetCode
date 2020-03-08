package wx.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode179 {

    /**
     *
     * 179. Largest Number
     * Medium
     *
     * 1516
     *
     * 184
     *
     * Add to List
     *
     * Share
     * Given a list of non negative integers, arrange them such that they form the largest number.
     *
     * Example 1:
     *
     * Input: [10,2]
     * Output: "210"
     * Example 2:
     *
     * Input: [3,30,34,5,9]
     * Output: "9534330"
     * Note: The result may be very large, so you need to return a string instead of an integer.
     *
     * Accepted
     * 161,102
     * Submissions
     * 585,505
     *
     */
    class Solution {
        public String largestNumber(int[] nums) {
            if(nums.length==0||nums==null){
                return "";
            }
            StringBuilder sb=new StringBuilder("");
            String[] str=new String[nums.length];

            for(int i=0;i<nums.length;i++){
                str[i]=String.valueOf(nums[i]);
            }


            Arrays.sort(str,new Comparator<String>(){
                public int compare(String s1,String s2){
                    String str1=s1+s2;
                    String str2=s2+s1;
                    return str2.compareTo(str1);
                }
            });

            for(int i=0;i<nums.length;i++){
                sb.append(str[i]);
            }
            if(sb.toString().charAt(0)=='0')
                return new String("0");
            return sb.toString();

        }
    }
}
