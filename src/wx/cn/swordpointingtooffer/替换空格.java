package wx.cn.swordpointingtooffer;

public class 替换空格 {


    /**
     *  Solution1
     *  用StringBuffer遍历即可
     *
     *
     */
    public class Solution {
        public String replaceSpace(StringBuffer str) {
            if(str==null||str.length()==0)
                return str.toString();

            StringBuilder res=new StringBuilder();
            for(int i=0;i<str.length();i++){
                char ch=str.charAt(i);
                if(ch==' '){
                    res.append("%20");
                }else
                    res.append(ch);


            }
            return res.toString();

        }
    }


    /**  Solution2
     * 也可以直接实现
     * @param string
     * @param usedLength
     * @return
     */

    public static int replaceBlank(char[] string, int usedLength) {
        // 判断输入是否合法
        if (string == null || string.length < usedLength) {
            return -1;
        }

        // 统计字符数组中的空白字符数
        int whiteCount = 0;
        for (int i = 0; i < usedLength; i++) {
            if (string[i] == ' ') {
                whiteCount++;
            }
        }

        // 计算转换后的字符长度是多少
        int targetLength = whiteCount * 2 + usedLength;
        int tmp = targetLength; // 保存长度结果用于返回
        if (targetLength > string.length) { // 如果转换后的长度大于数组的最大长度，直接返回失败
            return -1;
        }

        // 如果没有空白字符就不用处理
        if (whiteCount == 0) {
            return usedLength;
        }

        usedLength--; // 从后向前，第一个开始处理的字符
        targetLength--; // 处理后的字符放置的位置

        // 字符中有空白字符，一直处理到所有的空白字符处理完
        while (usedLength >= 0 && usedLength < targetLength) {
            // 如是当前字符是空白字符，进行"%20"替换
            if (string[usedLength] == ' ') {
                string[targetLength--] = '0';
                string[targetLength--] = '2';
                string[targetLength--] = '%';
            } else { // 否则移动字符
                string[targetLength--] = string[usedLength];
            }
            usedLength--;
        }

        return tmp;
    }
}
