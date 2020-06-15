package wx.leetcode;
import java.util.*;
public class Leetcode207 {
    class Solution {
        /**
         207. Course Schedule
         There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

         Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

         Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
         **/


        /**
         重点题

         BFS

         用一个入度数组 最后查每一个入度是否都为0

         **/
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if(prerequisites == null||prerequisites.length == 0)
                return true;
            int[] inDegree=new int[numCourses]; //入度 比如[0,1] 表示 1---->0     课程1是课程0的前置课程 0的入度+1

            HashMap<Integer,List<Integer>> map=new HashMap<>();

            for(int i=0;i<prerequisites.length;i++){
                inDegree[prerequisites[i][0]]++;

                if(map.containsKey(prerequisites[i][1])){
                    map.get(prerequisites[i][1]).add(prerequisites[i][0]);
                }else{
                    List<Integer> list=new ArrayList();
                    list.add(prerequisites[i][0]);
                    map.put(prerequisites[i][1],list);

                }
            }

            Queue<Integer> queue=new LinkedList<Integer>();
            for(int i=0;i<numCourses;i++){
                if(inDegree[i]==0)
                    queue.add(i);
            }


            while(!queue.isEmpty()){
                int course=queue.poll();
                List<Integer> tmp=map.get(course);

                for(int i=0;tmp!=null&&i<tmp.size();i++){//!!要注意tmp可能为空
                    inDegree[tmp.get(i)]--;
                    if(inDegree[tmp.get(i)]==0){
                        queue.add(tmp.get(i));
                    }
                }

            }

            for(int i=0;i<numCourses;i++){
                if(inDegree[i] != 0)
                    return false;
            }

            return true;


        }
    }
}
