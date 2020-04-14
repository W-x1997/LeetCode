package wx.leetcode;

import java.util.HashMap;

public class Leetcode16_25 {
    class LRUCache {
        class ListNode{
            int key;
            int val;
            ListNode  prev;
            ListNode next;
            public ListNode(){}
            public ListNode(int key,int val){
                this.key=key;
                this.val=val;
            }
        }


        ListNode head;
        ListNode tail;
        HashMap<Integer,ListNode> map;
        int capacity;
        int size;
        public LRUCache(int capacity) {
            head=new ListNode();
            tail=new ListNode();
            head.next=tail;
            head.prev=null;
            tail.prev=head;
            tail.next=null;
            map=new HashMap<Integer,ListNode>();
            this.capacity=capacity;
            this.size=0;

        }

        public int get(int key) {
            if(!map.containsKey(key))
                return -1;
            else {
                ListNode newnode=map.get(key);
                removeFromList(newnode);
                insertList(newnode);
                return newnode.val;
            }

        }

        public void put(int key, int value) {
            // if(size==capacity){
            //     ListNode node=tail.prev;
            //     removeFromList(tail.prev);
            //     map.remove(node.key);
            //     if(map.containsKey(key)){
            //         ListNode newnode=map.get(key);
            //         newnode.val=value;
            //         removeFromList(newnode);
            //         insertList(newnode);
            //     }else {
            //         ListNode newnode=new ListNode(key,value);
            //         map.put(key,newnode);
            //         insertList(newnode);
            //     }
            // }else {
            //     size++;
            //     if(map.containsKey(key)){
            //         ListNode newnode=map.get(key);
            //         newnode.val=value;
            //         removeFromList(newnode);
            //         insertList(newnode);
            //     }else {
            //         ListNode newnode=new ListNode(key,value);
            //         map.put(key,newnode);
            //         insertList(newnode);
            //     }

            // }
            if(map.containsKey(key)){

                ListNode t = map.get(key);
                t.val = value;
                //move to tail
                removeFromList(t);
                insertList(t);
            }else{
                if(map.size()>=capacity){
                    //delete head
                    map.remove(tail.prev.key);
                    removeFromList(tail.prev);
                }

                //add to tail
                ListNode node = new ListNode(key, value);
                insertList(node);
                map.put(key, node);
            }

        }

        public void removeFromList(ListNode node){
            node.prev.next=node.next;
            node.next.prev=node.prev;

        }

        public void insertList(ListNode node){
            node.next=head.next;
            head.next.prev=node;
            head.next=node;
            node.prev=head;



        }

    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
