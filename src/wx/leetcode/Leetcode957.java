package wx.leetcode;

import java.util.HashSet;
import java.util.*;

public class Leetcode957 {
    class Solution {
        public int[] prisonAfterNDays(int[] cells, int N) {

            /**
             *
             * 957. Prison Cells After N Days
             * There are 8 prison cells in a row, and each cell is either occupied or vacant.
             *
             * Each day, whether the cell is occupied or vacant changes according to the following rules:
             *
             * If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
             * Otherwise, it becomes vacant.
             * (Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)
             *
             * We describe the current state of the prison in the following way: cells[i] == 1 if the i-th cell is occupied, else cells[i] == 0.
             *
             * Given the initial state of the prison, return the state of the prison after N days (and N such changes described above.)


             找规律题 用hashset
             **/
            if(N<=0) return cells;
            Set<String> set=new HashSet<String>();
            boolean hascycle=false;


            for(int i=0;i<N;i++){
                int[] next=getprison(cells);
                String cur=Arrays.toString(next);
                if(!set.contains(cur)){
                    set.add(cur);

                }else {
                    hascycle=true;
                    break;
                }
                cells=next;
            }

            if(hascycle==true){
                N=N%set.size();
                for(int j=0;j<N;j++){
                    cells=getprison(cells);
                }

            }

            return cells;
        }



        public int[] getprison(int[] cells){
            int[] res=new int[cells.length];

            //res[0]=0;
            //res[cells.length-1]=0;
            for(int i=1;i<cells.length-1;i++){

                res[i]=(cells[i-1]==cells[i+1])?1:0;
                // if((cells[i-1]==1&&cells[i+1]==1)||(cells[i-1]==0&&cells[i+1]==0))
                //     res[i]=1;
                // else
                //     res[i]=0;
            }
            return res;

        }
    }
}
