package wx.cn.swordpointingtooffer;

public class 翻转单词顺序序列 {

    /**
     *
     *
     *
     * 题目描述
     * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，
     * 有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
     * 正确的句子应该是“I am a student.”
     */

    public class Solution {
        public String ReverseSentence(String str) {
            if(str==null||str.length()<=0){
                return "";
            }
            if(str.trim().equals("")){
                return str;
            }
            String[] a=str.split(" ");
            StringBuilder sb=new StringBuilder("");
            for(int i=a.length-1;i>=0;i--){
                sb.append(a[i]);
                if(i!=0)sb.append(" ");

            }

            return sb.toString();
        }
    }
}
