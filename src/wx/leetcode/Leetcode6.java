package wx.leetcode;

public class Leetcode6 {
    class Solution {
        /**
         6. ZigZag Conversion

         The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

         P   A   H   N
         A P L S I I G
         Y   I   R
         **/
        public String convert(String s, int numRows) {
            /**
             simulate this process
             调换方向 很巧妙
             注意case

             **/
            if(numRows == 1)
                return s;
            StringBuilder[] rows = new StringBuilder[numRows];

            for(int i=0;i<numRows;i++)
                rows[i] = new StringBuilder();

            int index = 0; // 表示当前位置
            int dir = -1; //用来调整递增递减

            for(int i=0;i<s.length();i++){
                char ch = s.charAt(i);
                rows[index].append(ch);

                if(index >= numRows-1||index <= 0){
                    dir = dir * -1;
                }

                index = index + dir;
            }

            StringBuilder res = new StringBuilder();
            for(int i=0;i<numRows;i++){
                res.append(rows[i]);
            }
            return res.toString();


        }
    }
}
