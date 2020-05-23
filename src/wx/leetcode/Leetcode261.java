package wx.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.*;
import java.util.Set;

public class Leetcode261 {
    /**
     * 261. Graph Valid Tree
     *
     * Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes),
     * write a function to check whether these edges make up a valid tree.
     *
     */
    class Solution {
        public boolean validTree(int n, int[][] edges) {
            /**
             *
             * 本题就是判断一个图是否能构成树
             我们用bfs来判断
             首先 n个顶点 如果边不等于 n-1 则必然无法构成树 大于n-1则必然有环
             小于n-1则有孤立点

             所以 我们在确保边数为n-1的情况下 保证n个点都是连通的 即可说明可以构成树
             **/
            if(n<=0)return false;
            if(edges.length!=n-1)return false;

            Set<Integer> visited=new HashSet<Integer>();  //用来保存已经访问过的

            Map<Integer,Set<Integer>> map=getEdges(n,edges);

            Queue<Integer> queue=new LinkedList<Integer>();

            visited.add(0);
            queue.add(0);

            while(!queue.isEmpty()){
                Integer cur=queue.poll();
                //  if(!map.containsKey(cur))continue; //空指针
                for(Integer i:map.get(cur)){
                    if(visited.contains(i))
                        continue;
                    visited.add(i);
                    queue.offer(i);
                }

            }
            return visited.size()==n;   //如果n个点都访问过 则说明都连通 又因为n-1条边 所以可以构成树





        }

        public Map<Integer,Set<Integer>> getEdges(int n, int[][] edges){
            Map<Integer,Set<Integer>> map=new HashMap<>();

            for (int i = 0; i <n ; i++) //防止空指针
                map.put(i,new HashSet<Integer>());

            for(int i=0;i<edges.length;i++){
                int u=edges[i][0];
                int v=edges[i][1];

                //由于上面已经put了  所以下面代码可以简化
                if(map.containsKey(u)){
                    map.get(u).add(v);
                }else{
                    Set<Integer> set=new HashSet<>();
                    set.add(v);
                    map.put(u,set);
                }

                if(map.containsKey(v)){
                    map.get(v).add(u);
                }else{
                    Set<Integer> set=new HashSet<>();
                    set.add(u);
                    map.put(v,set);
                }

            }

            return map;
        }

    }
}
