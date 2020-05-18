package wx.leetcode;

public class Leetcode158 {

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


        private int temp=0;
        private int readNums=0;
        private char [] buffer=new char[4];

        public int read(char[] buf, int n) {

            for(int i=0;i<n;i++){//最多读取n次
                if(temp==readNums){
                    readNums=read4(buffer);//一次性读取4个，供接下来4次使用
                    temp=0;
                    if(readNums==0) return i;//返回i，说明文件先被读完了
                }
                buf[i]=buffer[temp++];
            }
            return n;  //返回n，文件还没被读完
        }
    }



    private int read4(char[] temp) {
        return 0;
    }

    private class Reader4 {
    }
}
