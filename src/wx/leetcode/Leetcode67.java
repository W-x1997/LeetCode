package wx.leetcode;

public class Leetcode67 {
    class Solution {
        public String addBinary(String a, String b) {
            /**
             67. Add Binary
             Given two binary strings, return their sum (also a binary string).
             The input strings are both non-empty and contains only characters 1 or 0.
             Example 1:

             Input: a = "11", b = "1"
             Output: "100"



             从末尾往前相加进位即可
             注意判定的时候也要看carry
             **/

            int i=a.length()-1;
            int j=b.length()-1;
            int sum=0;
            int carry=0;
            StringBuilder sb=new StringBuilder("");

            while(i>=0||j>=0||carry==1){
                sum=carry;
                if(i>=0){
                    sum=sum+(a.charAt(i)-'0');
                    i--;
                }

                if(j>=0){
                    sum=sum+(b.charAt(j)-'0');
                    j--;
                }

                carry=sum/2;
                int cur=sum%2;
                sb.append(cur);




            }
            return sb.reverse().toString();



        }
    }
}
