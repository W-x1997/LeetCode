package wx.leetcode;

import java.util.HashMap;

public class Leetcode166 {
    /**
     *
     * 166. Fraction to Recurring Decimal
     * Medium
     *
     * 757
     *
     * 1658
     *
     * Add to List
     *
     * Share
     * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
     *
     * If the fractional part is repeating, enclose the repeating part in parentheses.
     * 使用StringBuilder存储结果
     * 使用HashMap保存每次进行除运算的结果的位置
     * 有可能出现溢出情况（转换成Long）
     * 存在负数的情况，注意判断正负号
     *
     *
     *
     * 长除法
     * 需要用一个哈希表记录余数出现在小数部分的位置，当你发现已经出现的余数，就可以将重复出现的小数部分用括号括起来。
     *
     * 再出发过程中余数可能为 0，意味着不会出现循环小数，立刻停止程序。
     *
     */
    class Solution {
        public String fractionToDecimal(int numerator, int denominator) {
            if(numerator==0) return "0";
            StringBuilder sb=new StringBuilder("");
            if(numerator<0 ^ denominator<0)
                sb.append("-");

            long n = Math.abs((long) numerator);
            long d = Math.abs((long) denominator);
            sb.append(n/d);
            n=n%d;

            if(n==0)  return sb.toString();
            sb.append(".");

            HashMap<Long,Integer> map=new HashMap<Long,Integer>();
            while(!map.containsKey(n)){
                map.put(n,sb.length());

                n=n*10;
                sb.append(n/d);
                n=n%d;
                if(n==0) return sb.toString();

            }

            sb.insert(map.get(n),"(");
            sb.append(")");

            return sb.toString();
        }
    }
}
