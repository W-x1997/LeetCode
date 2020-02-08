package wx.cn.swordpointingtooffer;

import java.util.HashMap;
import java.util.*;


public class 把字符串转换为整数 {


    /**
     *
     *
     * 题目描述
     * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
     * 输入描述:
     * 输入一个字符串,包括数字字母符号,可以为空
     * 输出描述:
     * 如果是合法的数值表达则返回该数字，否则返回0
     *
     * 思路：
     * 这题 主要是 考虑一个所有的case  尤其是int 的边界值
     *
     * 所以先把res设置成为long
     * 然后判断是否越界
     */

    public class Solution {
        public int StrToInt(String str) {
            if(str==null||str.length()==0)
                return 0;

            HashMap<Character,Integer> map=new HashMap<Character,Integer>();
            map.put('1',1);
            map.put('2',2);
            map.put('3',3);
            map.put('4',4);
            map.put('5',5);
            map.put('6',6);
            map.put('7',7);
            map.put('8',8);
            map.put('9',9);
            map.put('0',0);
            map.put('+',-1);
            map.put('-',-2);


            long res=0;

            for(int i=0;i<str.length();i++){
                char ch=str.charAt(i);
                if(ch=='+'||ch=='-'){
                    if(i==0)
                        continue;
                    else
                        return 0;
                }

                if(ch<'0'||ch>'9')
                    return 0;

                int tmp=map.get(ch);
                res=res*10+tmp;



            }
            if(str.charAt(0)=='-')
                res=(-1)*res;


            if(res>Integer.MAX_VALUE||res<Integer.MIN_VALUE)
                return 0;
            else
                return (int)res;

        }
    }
}
