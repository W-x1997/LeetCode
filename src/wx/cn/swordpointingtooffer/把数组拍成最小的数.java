package wx.cn.swordpointingtooffer;
import java.util.*;
public class 把数组拍成最小的数 {


    /**
     *
     * 题目描述
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
     *
     *
     *  解题思路：
     *  * 先将整型数组转换成String数组，然后将String数组排序，最后将排好序的字符串数组拼接出来。关键就是制定排序规则。
     *  * 排序规则如下：
     *  * 若ab > ba 则 a > b，
     *  * 若ab < ba 则 a < b，
     *  * 若ab = ba 则 a = b；
     *
     *  int result = obj1.compareTo(obj2);
     *
     * 假如result返回1。Collections.sort(List)方法就是升序; True升序
     * 假如result返回-1。Collections.sort(List)方法就是降序; False降序
     */


    public class Solution {
        public String PrintMinNumber(int [] numbers) {


            if(numbers == null || numbers.length == 0) return "";
            int len = numbers.length;
            String[] str = new String[len];
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < len; i++){
                str[i] = String.valueOf(numbers[i]);
            }
            Arrays.sort(str,new Comparator<String>(){
                @Override
                public int compare(String s1, String s2) {
                    String c1 = s1 + s2;
                    String c2 = s2 + s1;
                    return c1.compareTo(c2);
                }
            });
            for(int i = 0; i < len; i++){
                sb.append(str[i]);
            }
            return sb.toString();

        }




    }
}
