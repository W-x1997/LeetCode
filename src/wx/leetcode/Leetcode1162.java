package wx.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode1162 {
    /**
     *
     * Given an N x N grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such that its distance to the nearest land cell is maximized and return the distance.
     *
     * The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
     *
     * If no land or water exists in the grid, return -1.
     *
     *  
     *
     * Example 1:
     *
     *
     *
     * Input: [[1,0,1],[0,0,0],[1,0,1]]
     * Output: 2
     * Explanation:
     * The cell (1, 1) is as far as possible from all the land with distance 2.
     * Example 2:
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/as-far-from-land-as-possible
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class Solution {
        public int maxDistance(int[][] grid) {
            int dx[]={0,-1,0,1};
            int dy[]={1, 0,-1,0};
            Queue<ArrayList<Integer>> queue=new LinkedList<ArrayList<Integer>>();
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    if(grid[i][j]==1){
                        ArrayList<Integer> arr=new ArrayList();
                        arr.add(i);
                        arr.add(j);
                        queue.offer(arr);
                    }
                }
            }

            boolean hasOcean = false;

            List<Integer> list=null;


            while(!queue.isEmpty()){
                list=queue.poll();
                int oldx=list.get(0);
                int oldy=list.get(1);
                int value=grid[oldx][oldy];

                for(int i=0;i<4;i++){
                    int x=oldx+dx[i];
                    int y=oldy+dy[i];

                    if(x<0||x>=grid.length||y<0||y>=grid[0].length||grid[x][y]>0)
                        continue;
                    grid[x][y]=value+1;
                    hasOcean = true;
                    ArrayList<Integer> tmp=new ArrayList();
                    tmp.add(x);
                    tmp.add(y);
                    queue.offer(tmp);
                }

            }
            if(hasOcean==false||list==null)return -1;
            return grid[list.get(0)][list.get(1)]-1;



        }
    }
}
