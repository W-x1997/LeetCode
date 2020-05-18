package wx.leetcode;

import java.util.HashMap;

public class Leetcode146 {
    /**
     * 146. LRU Cache
     * Medium
     *
     * 5422
     *
     * 242
     *
     * Add to List
     *
     * Share
     * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
     *
     * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
     * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
     *
     * The cache is initialized with a positive capacity.
     *
     * Follow up:
     * Could you do both operations in O(1) time complexity?
     */
    class LRUCache {

        /**
         *  we need to use hashmap and doublelinked list to implement this LRU cache
         *
         *  we need to define the structure node !!!
         *  1.Double-linked Node
         *  2. HashMap   <Integer,Node >
         *
         *  !!The reason we need to store the key is that when we need to remove the node from hashmap,
         *  we need to use the key to  get the node.
         *
         *
         *  We just need  to finish 2 functions:!!!
         *   1. addToHead()
         *   2.removeNode()
         *
         *
         * The LRU includes:
         * 1. hashMap
         * 2. two nodes:  head and tail
         * 3. capacity
         *
         *
         *  includes key and vals !! The reason we need to define the key
         *
         */

        class Node{
            int key;
            int val;
            Node next;
            Node prev;

            public Node(int key,int val){ // we need to store the key, since we when we want to delete the Node in hashmap, we need to know the its key
                this.key=key;
                this.val=val;
            }

        }


        HashMap<Integer,Node> map;
        Node head;
        Node tail;
        int capacity;



        public LRUCache(int capacity) {
            this.capacity=capacity;
            map=new HashMap<Integer,Node>();
            head=new Node(0,0);
            tail=new Node(0,0);
            head.next=tail;
            head.prev=null;

            tail.prev=head;
            tail.next=null;
        }

        public int get(int key) {
            if(!map.containsKey(key)){
                return -1;
            }

            Node node=map.get(key);
            deleteNode(node);
            addToHead(node);

            return node.val;
        }


        public void put(int key, int value) {
            if(map.containsKey(key)){
                Node node=map.get(key);
                node.val=value;
                deleteNode(node);
                addToHead(node);


            }else{
                Node node=new Node(key,value);
                map.put(key,node);
                if(map.size()>capacity){  // we have added before!

                    map.remove(tail.prev.key); //  ！ Denote:we need to remove the tail(last) node from the hashmap !!!do it before remove forom map
                    deleteNode(tail.prev);  //!

                    addToHead(node);
                }else
                    addToHead(node);


            }

        }





        public void addToHead(Node node){
            node.next=head.next;
            node.prev=head;
            head.next.prev=node;
            head.next=node;

        }

        public void deleteNode(Node node){
            node.prev.next=node.next;
            node.next.prev=node.prev;

        }

    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
