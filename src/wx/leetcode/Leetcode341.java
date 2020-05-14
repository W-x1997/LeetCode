package wx.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Leetcode341 {
    /**
     * 341. Flatten Nested List Iterator
     * Medium
     *
     * 1522
     *
     * 618
     *
     * Add to List
     *
     * Share
     * Given a nested list of integers, implement an iterator to flatten it.
     *
     * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
     */

    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     *
     *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     *     public boolean isInteger();
     *
     *     // @return the single integer that this NestedInteger holds, if it holds a single integer
     *     // Return null if this NestedInteger holds a nested list
     *     public Integer getInteger();
     *
     *     // @return the nested list that this NestedInteger holds, if it holds a nested list
     *     // Return null if this NestedInteger holds a single integer
     *     public List<NestedInteger> getList();
     * }
     */
    public class NestedIterator implements Iterator<Integer> {


        List<Integer> list;
        int index;
        public NestedIterator(List<NestedInteger> nestedList) {
            list=new ArrayList();
            index=0;
            helper(nestedList);


        }

        public void helper(List<NestedInteger> nestedList){
            for(NestedInteger cur:nestedList){
                if(cur.isInteger()){
                    list.add(cur.getInteger());
                }else {
                    helper(cur.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return list.get(index++);
            //  index++;
        }

        @Override
        public boolean hasNext() {
            return index<list.size();
        }
    }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
 public interface NestedInteger {

                  // @return true if this NestedInteger holds a single integer, rather than a nested list.
                  public boolean isInteger();

                  // @return the single integer that this NestedInteger holds, if it holds a single integer
                  // Return null if this NestedInteger holds a nested list
                  public Integer getInteger();

                  // @return the nested list that this NestedInteger holds, if it holds a nested list
                  // Return null if this NestedInteger holds a single integer
                  public List<NestedInteger> getList();
      }
}
