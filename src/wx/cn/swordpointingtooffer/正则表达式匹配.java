package wx.cn.swordpointingtooffer;

public class 正则表达式匹配 {


    /**
     *
     * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
     * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
     *
     *
     *
     * 思路：
     * 这题重点题
     * 主要是分情况递归
     *
     *
     * 递归结束条件为 判断 pattern中的j是否遍历到最后 如果遍历到了最后 则根据str中的i来判断i是否走到了最后
     *
     * 分情况主要看 j的下一位j+1是否为*
     *       1. 这里 如果j+1 为*：  则有两种情况                                                     !!下面这种情况也不能忘
     *                      1）当前j 匹配 则下一轮 i+1，j不变 ---》 ispattern(str,i+1,pattern,j)||ispattern(str,i,pattern,j+2)
     *                                                                                                  比如：       i
     *                                                                                                 str：     ab c*cdd
     *                                                                                                 pattern   ab cdd
     *                                                                                                              j
     *
     *                      2）当前j 不匹配 如下
     *                         比如
     *                                        i
     *                          str：      ab cd
     *                          pattern:   ab k*cd 不匹配
     *                                        j
     *                                  此时不匹配 则i不变 j+2 ---》 spattern(str,i,pattern,j+2);
     *
     *       2. 如果 j+1 不为*：
     *         这种情况很简单 直接匹配当前str[i]和pattern[j]即可
     *         若匹配 直接进入下一轮ispattern(str,i+1,pattern,j+1)
     *         若不匹配 则直接return false
     *
     *
     *
     */
    public class Solution {
        public boolean match(char[] str, char[] pattern)
        {
            return ispattern(str,0,pattern,0);

        }


        public boolean ispattern(char[] str,int i,char []pattern,int j){

            if(str==null||pattern==null)
                return false;

            if(j == pattern.length)//pattern遍历完了
                return str.length == i;

            if(j < pattern.length - 1&&pattern[j+1]=='*'){
                if(str.length != i && (pattern[j]==str[i]||pattern[j]=='.')){
                    return ispattern(str,i+1,pattern,j)||ispattern(str,i,pattern,j+2);
                }else
                    return ispattern(str,i,pattern,j+2);
            }

            if(str.length != i&&(pattern[j]==str[i]||pattern[j]=='.'))
                return  ispattern(str,i+1,pattern,j+1);
            else
                return false;

        }


    }


}
