package wx.leetcode;
import java.util.*;
public class Leetcode210 {
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {

            /**
             210. Course Schedule II

             There are a total of n courses you have to take, labeled from 0 to n-1.

             Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

             Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

             There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.


             解法和lc207一样
             **/
            List<Integer> res=new ArrayList();


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
                if(inDegree[i]==0){
                    queue.add(i);
                    res.add(i);
                }

            }


            while(!queue.isEmpty()){
                int course=queue.poll();
                List<Integer> tmp=map.get(course);

                for(int i=0;tmp!=null&&i<tmp.size();i++){//!!要注意tmp可能为空
                    inDegree[tmp.get(i)]--;
                    if(inDegree[tmp.get(i)]==0){
                        queue.add(tmp.get(i));
                        res.add(tmp.get(i));
                    }
                }

            }

            for(int i=0;i<numCourses;i++){
                if(inDegree[i] != 0)
                    return new int[0];
            }


            int[] arr=new int[res.size()];
            for(int i=0;i<res.size();i++){
                arr[i] = res.get(i);
            }
            return arr;


        }
    }
}
