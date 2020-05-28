package wx.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode937 {
    class Solution {
        /**
         937. Reorder Data in Log Files


         这个是sort方法里的那个比较函数的特殊的返回值，比较函数的参数 a 和 b 代表数组里的两个元素，
         如果 a 小于 b，排序后的数组 a 在 b 前面，此时返回一个负数 （即上面的 return -1）
         如果 a 等于 b，排序后两者位置不变，此时返回 0 （即上面的 return 0）
         如果 a 大于 b，排序后 a 在 b 后面， 返回一个正数 （即上面的 return 1）
         **/
        public String[] reorderLogFiles(String[] logs) {
            if(logs==null||logs.length==0)return logs;

            Arrays.sort(logs,new Comparator<String>(){
                public int compare(String log1,String log2){
                    String[] split1 = log1.split(" ", 2);  //第二个参数表示分割的数量 即分成2组
                    String[] split2 = log2.split(" ", 2);
                    boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                    boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
                    if (!isDigit1 && !isDigit2) {
                        int cmp = split1[1].compareTo(split2[1]);
                        if (cmp != 0) return cmp;
                        return split1[0].compareTo(split2[0]);
                    }
                    return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
                }
            });

            return logs;

        }

    }
}
