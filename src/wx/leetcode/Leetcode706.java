package wx.leetcode;

public class Leetcode706 {
    class MyHashMap {

        /**
         706. Design HashMap

         Design a HashMap without using any built-in hash table libraries.

         To be specific, your design should include these functions:

         put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
         get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
         remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.
         **/
        class Node{
            int key;
            int value;
            Node next;

            public Node(int k,int v){
                this.key=k;
                this.value=v;
            }
        }


        Node[] buckets;
        int SIZE = 500;


        /** Initialize your data structure here. */
        public MyHashMap() {
            buckets=new Node[SIZE];
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int hash=hash(key);
            if(buckets[hash]==null){
                buckets[hash]=new Node(key,value);

            }else{
                Node root=buckets[hash];
                Node cur=root;
                boolean ischanged=false;

                while(cur!=null){
                    if(cur.key==key){
                        cur.value=value;
                        ischanged=true;
                        break;
                    }
                    cur=cur.next;

                }

                if(!ischanged){
                    Node newnode=new Node(key,value);
                    newnode.next=root;
                    buckets[hash]=newnode;
                }

            }

        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int hash=hash(key);
            if(buckets[hash]==null)
                return -1;

            Node root=buckets[hash];
            Node cur=root;
            while(cur!=null){
                if(cur.key==key)
                    return cur.value;

                cur=cur.next;
            }
            return -1;

        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int hash=hash(key);
            if(buckets[hash]==null)return;

            Node root=buckets[hash];
            Node cur=root;

            if(cur.key==key)
                buckets[hash]=cur.next;
            else{

                while(cur.next!=null){
                    if(cur.next.key==key){
                        cur.next=cur.next.next;
                        return;
                    }
                    cur=cur.next;
                }

            }



        }


        public int hash(int key){
            return key%SIZE;
        }
    }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
}
