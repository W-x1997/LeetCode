package wx.leetcode;

public class Leetcode8 {
    /**
     *8. String to Integer (atoi)
     * Implement atoi which converts a string to an integer.
     *
     * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
     *
     * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
     *
     * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
     *
     * If no valid conversion could be performed, a zero value is returned.
     *
     * Note:
     *
     * Only the space character ' ' is considered as whitespace character.
     * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
     *
     *
     * 这题的做法大概是这样：
     *
     * 去掉前导空格
     * 再是处理正负号
     * 识别数字，注意越界情况。
     *
     */
    public class Solution {
        public int myAtoi(String str) {
            char[] chars = str.toCharArray();
            int n = chars.length;
            int idx = 0;
            while (idx < n && chars[idx] == ' ') {
                // 去掉前导空格
                idx++;
            }
            if (idx == n) {
                //去掉前导空格以后到了末尾了
                return 0;
            }
            boolean negative = false;
            if (chars[idx] == '-') {
                //遇到负号
                negative = true;
                idx++;
            } else if (chars[idx] == '+') {
                // 遇到正号
                idx++;
            } else if (!Character.isDigit(chars[idx])) {
                // 其他符号
                return 0;
            }
            int ans = 0;
            while (idx < n && Character.isDigit(chars[idx])) {
                int digit = chars[idx] - '0';
                if (ans > (Integer.MAX_VALUE - digit) / 10) {
                    // 本来应该是 ans * 10 + digit > Integer.MAX_VALUE
                    // 但是 *10 和 + digit 都有可能越界，所有都移动到右边去就可以了。
                    return negative? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                ans = ans * 10 + digit;
                idx++;
            }
            return negative? -ans : ans;
        }
    }

    class Solution2 {
        public int myAtoi(String str) {
            if(str==null||str.length()==0)
                return 0;

            double res=0;
            boolean op=true;
            boolean isused=false;
            int index=0;
            for(int i=0;i<str.length();i++){
                char ch=str.charAt(i);
                if(ch==' '){
                    index++;
                    continue;
                }else
                    break;
            }

            if(index>=str.length())return 0;

            for(int i=index;i<str.length();i++){
                char ch=str.charAt(i);
                if(ch=='-'&&res==0&&isused==false){
                    op=false;
                    isused=true;
                    continue;
                }
                if(ch=='+'&&res==0&&isused==false){
                    //op=false;
                    isused=true;
                    continue;
                }
                isused=true;  //因为第一个符号出现之后就不能再出现+ -
                if(ch<'0'||ch>'9')break;
                res=res*10+ch-'0';

            }
            if(op==false)
                res=(-1)*res;

            if(res>Integer.MAX_VALUE)
                res=Integer.MAX_VALUE;

            if(res<Integer.MIN_VALUE)
                res=Integer.MIN_VALUE;

            return (int)res;
        }
    }



}
