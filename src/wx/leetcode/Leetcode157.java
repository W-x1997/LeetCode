package wx.leetcode;

public class Leetcode157 {


    /**
     *
     * 157. Read N Characters Given Read4
     * Easy
     *
     * 246
     *
     * 1872
     *
     * Add to List
     *
     * Share
     * Given a file and assume that you can only read the file using a given method read4, implement a method to read n characters.
     */
    /**
     * The read4 API is defined in the parent class Reader4.
     *     int read4(char[] buf);
     */

    public class Solution extends Reader4 {
        /**
         * @param buf Destination buffer
         * @param n   Number of characters to read
         * @return    The number of actual characters read
         */
        public int read(char[] buf, int n) {
            char temp[]=new char[4]; // used to store read4 buff
            int index=0;

            while(true){
                int count=read4(temp);//这一次 read4读取的数量
                count=Math.min(count,n-index);//取小的那一个    因为一共只能读n个 这次读了count个 不能超过 n-count

                for(int i=0;i<count;i++){
                    buf[index++]=temp[i];
                }

                if(index==n||count<4) return index;

            }

        }



    }
}
