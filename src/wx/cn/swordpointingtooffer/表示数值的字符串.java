package wx.cn.swordpointingtooffer;

public class 表示数值的字符串 {
    /**
     *
     *
     * 题目描述
     * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
     *
     * 解题思路
     * 12e说明e的后面必须有数字，不能有两个e
     * +-5说明符号位要么出现一次在首位，要么出现一次在e的后一位，其他地方都不能有
     * 12e4.3说明e的后面不能有小数，1.2.3说明不能有两个小数点
     * 1a3.14说明不能有其他的非法字符，比如这里的a
     *
     */

    public class Solution {
        public boolean isNumeric(char[] str) {
            //signal表示符号，decimal表示小树点，hasE表示含有符号e
            boolean signal = false,decimal = false,hasE = false;
            for(int i=0;i<str.length;i++){
                if(str[i] == 'E' || str[i] == 'e'){
                    //e后面必须有数字，所以是最后一位肯定不通过
                    if(i==str.length-1){
                        return false;
                    }
                    //不能有两个e
                    if(hasE){
                        return false;
                    }
                    hasE = true;
                }else if(str[i] == '+' || str[i] == '-'){
                    //不是第一次出现，那么后面能出现符合的地方只有紧贴着e的后面一位，不是则不通过
                    if(signal && str[i-1] != 'E' && str[i-1] != 'e'){
                        return false;
                    }
                    //第一次出现，如果不是出现在第一位，那么还是判断一下是不是出现在e的后面一位
                    if(!signal && i>0 && str[i-1] != 'E' && str[i-1] != 'e'){
                        return false;
                    }
                    signal = true;
                }else if(str[i] == '.'){
                    //如果存在e并且e后面为小数则不通过
                    if(hasE){
                        for(;i>=0;i--){
                            if(str[i] == 'e' || str[i] == 'E'){
                                return false;
                            }
                        }
                    }
                    //不能有两个小数点
                    if(decimal){
                        return false;
                    }
                    decimal = true;
                }else if(str[i] < '0' || str[i] > '9'){
                    //不是e也不是+-符号也不是小数点，那么只能是数字，不是数字就是非法的字符
                    return false;
                } }

            return true;
        }
    }
}
