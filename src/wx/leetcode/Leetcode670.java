package wx.leetcode;
import  java.util.*;
public class Leetcode670 {
    class Solution {
        /**
         670. Maximum Swap

         Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.

         Example 1:
         Input: 2736
         Output: 7236
         Explanation: Swap the number 2 and the number 7.
         **/

        public int maximumSwap(int num) {

            /**
             * 我的方法 复杂化了
             * 看下面答案
             思路就是找到每一个位置右边的最大数 然后替换
             注意 如果相等的情况很复杂！！
             **/
            if (num == 0)
                return 0;
            List<Integer> list = new ArrayList();

            while(num > 0){
                int tmp = num % 10;
                list.add(tmp);
                num = num / 10;
            }


            int[] arr = new int[list.size()];
            int index = 0;
            for (int i = list.size() - 1; i >= 0; i--){
                arr[index] = list.get(i);
                index ++;
            }



            int[] max_index = new int[arr.length];

            for(int i = 0; i < arr.length; i++){
                int cur = arr[i];
                max_index[i] = -1;
                int max = cur;
                int flag = 0;
                for (int j = i + 1; j < arr.length; j++){
                    if (max < arr[j]  ){ // 就是找到最左边的
                        max = arr[j];
                        max_index[i] = j;
                        flag = 1;
                    }
                    if (max == arr[j]&&flag == 1){  //为了从右边找
                        max_index[i] = j;

                    }


                }

            }



            for(int i = 0; i < max_index.length; i++){
                if(max_index[i] == -1)
                    continue;
                int tmp = arr[i];
                arr[i] = arr[max_index[i]];
                arr[max_index[i]] = tmp;
                break;

            }




            int res = 0;
            for(int i = 0; i < arr.length; i++){
                // System.out.println(arr[i]);
                res = res * 10 + arr[i];
            }

            return res;

        }

        /**
         * 答案
         * @param num
         * @return
         */
        public int maximumSwap2(int num) {
            char[] A = Integer.toString(num).toCharArray();
            int[] last = new int[10];
            for (int i = 0; i < A.length; i++) {
                last[A[i] - '0'] = i;
            }

            for (int i = 0; i < A.length; i++) {
                for (int d = 9; d > A[i] - '0'; d--) {
                    if (last[d] > i) {
                        char tmp = A[i];
                        A[i] = A[last[d]];
                        A[last[d]] = tmp;
                        return Integer.valueOf(new String(A));
                    }
                }
            }
            return num;

        }
    }
}
