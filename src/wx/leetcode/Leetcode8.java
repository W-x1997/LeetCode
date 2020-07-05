package wx.leetcode;

public class Leetcode8 {
    class Solution {
        /**
         8. String to Integer (atoi)
         Implement atoi which converts a string to an integer.

         The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

         The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

         If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

         If no valid conversion could be performed, a zero value is returned.

         Note:

         Only the space character ' ' is considered as whitespace character.
         Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
         **/
        public int myAtoi(String str) {

            /**
             题目翻译：忽略空格，然后计算sign。
             开始挨个字符读取计算sum 如果sum overflow了，gg

             难点在于overflow:把当前的总和与 intmax/10 或者 intmax%10 比较
             其实就两种情况：
             第一种是 之前总和就大于 intmax/10，下一个一定overflow无论正负
             第二种是 之前的总和正好等于 intmax/10，正好等于！正好等于！！新的数字大于7就完蛋，如果是8呢，没关系一样完蛋或者返回int_minvalue
             **/
            str = str.trim();
            if(str == null || str.length() == 0)
                return 0;

            char symbol = str.charAt(0);
            int sign = 1;
            int total = 0;

            int index = 0;

            if (symbol == '+'){
                sign = 1;
                index++;
            }else if(symbol == '-'){
                sign = -1;
                index ++;
            }


            while(index < str.length()){
                int tmp = str.charAt(index) - '0';
                if(tmp < 0 || tmp > 9){
                    //return total * sign;
                    break;
                }

                if (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < tmp){
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

                }

                total = total * 10 + tmp;
                index ++;
            }

            return sign * total;
        }
    }


}
