package wx.cn.swordpointingtooffer;
import java.util.*;
public class 圆圈中最后剩下的数 {

    /**
     *
     * 约瑟夫环问题
     */
    public class Solution {



        public class Solution2 {
            public int LastRemaining_Solution(int n, int m) {
                LinkedList<Integer> list = new LinkedList<Integer>();
                for (int i = 0; i < n; i ++) {
                    list.add(i);
                }

                int bt = 0;
                while (list.size() > 1) {
                    bt = (bt + m - 1) % list.size();
                    list.remove(bt);
                }

                return list.size() == 1 ? list.get(0) : -1;
            }
        }
        public int LastRemaining_Solution(int n, int m) {

            if (m == 0 || n == 0) {
                return -1;
            }
            ArrayList<Integer> data = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                data.add(i);
            }
            int index = -1;
            while (data.size() > 1) {
//          System.out.println(data);
                index = (index + m) % data.size();
//          System.out.println(data.get(index));
                data.remove(index);
                index--;
            }
            return data.get(0);




        }
    }

}
