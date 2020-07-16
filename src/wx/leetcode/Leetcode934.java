package wx.leetcode;
import java.util.*;

public class Leetcode934 {
    class Solution {
        /**
         934. Shortest Bridge

         In a given 2D binary array A, there are two islands.  (An island is a 4-directionally connected group of 1s not connected to any other 1s.)

         Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.

         Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)



         非常不错的一道题，DFS+BFS混合两个。
         先floodfill探索一个岛标记为2.
         然后得用一个boolean表示探索完毕

         最后用Queue+BFS遍历把所有0的点都加进来开始翻牌子。
         找到了1就说明探索到了新大陆，OK


   **/

        Queue<int[]> queue=new LinkedList<>();
        int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        public int shortestBridge(int[][] A) {
            int res = 0;
            int row = A.length;
            int col = A[0].length;
            boolean flag = false;

            for (int i = 0; i < row; i++) {
                if(flag) {
                    break;
                }
                for (int j = 0; j < col; j++) {
                    if (A[i][j] == 1){
                        dfs(A, i, j);
                        flag = true;
                        break;
                    }

                }
            }


            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] arr = queue.poll();

                    for (int j = 0; j < dir.length; j++) {
                        int x = arr[0] + dir[j][0];
                        int y = arr[1] + dir[j][1];
                        if(x < 0 || y < 0 || x >= row || y >= col || A[x][y] == 2)
                            continue;

                        if (A[x][y] == 1) {
                            return res;
                        }
                        A[x][y]=2;
                        queue.add(new int[]{x,y});


                    }
                }
                res++;




            }
            return res;
        }


        public void dfs(int[][] A, int i, int j){
            if (i < 0 || i >= A.length || j < 0 || j >= A[0].length || A[i][j] != 1)
                return;



            A[i][j] = 2;
            queue.add(new int[]{i, j});
            dfs(A, i+1, j);
            dfs(A, i-1, j);
            dfs(A, i, j+1);
            dfs(A, i, j-1);

        }



    }
}
