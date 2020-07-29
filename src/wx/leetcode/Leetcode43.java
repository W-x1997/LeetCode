package wx.leetcode;

public class Leetcode43 {
    class Solution {
        /**
         43. Multiply Strings

         Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

         Example 1:

         Input: num1 = "2", num2 = "3"
         Output: "6"
         Example 2:

         Input: num1 = "123", num2 = "456"
         Output: "56088"

         num1 长度为m，num2 长度为n，则 num1 x num2 的长度不会超过 m+n，还有就是要明白乘的时候为什么要错位，比如6乘8得到的 48 为啥要跟6乘9得到的 54 错位相加，因为8是十位上的数字，其本身相当于80，所以错开的一位实际上末尾需要补的0。还有一点需要观察出来的就是，num1 和 num2 中任意位置的两个数字相乘，得到的两位数在最终结果中的位置是确定的，比如 num1 中位置为i的数字乘以 num2 中位置为j的数字，那么得到的两位数字的位置为 i+j 和 i+j+1，明白了这些后，就可以进行错位相加了，累加出最终的结果。


         **/
        public String multiply(String num1, String num2) {

            if (num1.equals("0") || num2.equals("0") )//注意这边要用equals！！！
                return "0";

            int m = num1.length();
            int n = num2.length();

            int[] res = new int[m+n];

            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >=0; j--) {
                    int val = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                    int p2 = i + j + 1;   //个位
                    int p1 = i + j;  //十位

                    int sum = res[p2] + val;
                    res[p2] = sum % 10;
                    res[p1] = res[p1] + sum / 10;

                }
            }
            StringBuilder sb = new StringBuilder("");
            for (int cur : res) {
                if(sb.length() == 0 && cur == 0) //排除第一位是0的可能性
                    continue;
                else
                    sb.append(cur);
            }

            return sb.toString();


        }


    }
}
