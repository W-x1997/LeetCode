package wx.leetcode;

import java.util.HashMap;

public class Leetcode13 {

    /**
     * 13. Roman to Integer
     * Easy
     *
     * 1999
     *
     * 3366
     *
     * Add to List
     *
     * Share
     * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
     *
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * For example, two is written as II in Roman numeral, just two one's added together.
     * Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
     */
    class Solution {

        /**
         *
         * 按照题目的描述，可以总结如下规则：
         *
         * 罗马数字由 I,V,X,L,C,D,M 构成；
         * 当小值在大值的左边，则减小值，如 IV=5-1=4；
         * 当小值在大值的右边，则加小值，如 VI=5+1=6；
         * 由上可知，右值永远为正，因此最后一位必然为正。
         * 一言蔽之，把一个小值放在大值的左边，就是做减法，否则为加法。
         *
         *
         * @param s
         * @return
         */
        public int romanToInt(String s) {
            int res=0;
            HashMap<Character,Integer> map=new HashMap<Character,Integer>();
            map.put('I',1);
            map.put('V',5);
            map.put('X',10);
            map.put('L',50);
            map.put('C',100);
            map.put('D',500);
            map.put('M',1000);


            for(int i=0;i<s.length()-1;i++){
                char ch=s.charAt(i);
                char next=s.charAt(i+1);
                if(map.get(ch)<map.get(next)){
                    res=res-map.get(ch);
                }else {
                    res=res+map.get(ch);
                }

            }

            res=res+map.get(s.charAt(s.length()-1));

            return res;

        }
    }
}
