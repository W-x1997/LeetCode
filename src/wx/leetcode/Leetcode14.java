package wx.leetcode;

public class Leetcode14 {
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if(strs==null||strs.length==0)
                return "";

            String str=strs[0];
            StringBuilder res=new StringBuilder("");


            for(int i=1;i<strs.length;i++){
                if(str.length()>strs[i].length()){
                    str=strs[i];
                }
            }

            for(int i=0;i<str.length();i++){
                int flag=0;
                char ch=str.charAt(i);

                for(int j=0;j<strs.length;j++){
                    if(ch == strs[j].charAt(i))
                        continue;
                    else {
                        flag=1;
                        break;
                    }

                }
                if(flag==0){
                    res.append(ch);

                }
                if(flag==1)break;


            }
            return res.toString();



        }
    }
}
