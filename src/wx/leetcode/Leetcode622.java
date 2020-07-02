package wx.leetcode;

public class Leetcode622 {
    class MyCircularQueue {
        /**
         622. Design Circular Queue

         Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".

         One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue. But using the circular queue, we can use the space to store new values.

         Your implementation should support following operations:

         MyCircularQueue(k): Constructor, set the size of the queue to be k.
         Front: Get the front item from the queue. If the queue is empty, return -1.
         Rear: Get the last item from the queue. If the queue is empty, return -1.
         enQueue(value): Insert an element into the circular queue. Return true if the operation is successful.
         deQueue(): Delete an element from the circular queue. Return true if the operation is successful.
         isEmpty(): Checks whether the circular queue is empty or not.
         isFull(): Checks whether the circular queue is full or not.


         用一个数组 两个指针
         head tail  每次都依次向后走 如果到达数组末尾则转0
         **/

        int[] buffer;
        int size;
        int head;
        int tail;
        /** Initialize your data structure here. Set the size of the queue to be k. */
        public MyCircularQueue(int k) {
            buffer = new int[k];
            size = 0;
            head = 0;
            tail = -1;
        }

        /** Insert an element into the circular queue. Return true if the operation is successful. */
        public boolean enQueue(int value) {
            if(isFull())
                return false;
            else {

                if(tail == buffer.length-1){
                    tail = 0;
                }else
                    tail++;

                buffer[tail] = value;
                size++;
                return true;


            }
        }

        /** Delete an element from the circular queue. Return true if the operation is successful. */
        public boolean deQueue() {
            if(isEmpty())
                return false;
            else {
                if(head == buffer.length-1){
                    head = 0;
                }else
                    head++;


                size--;
                return true;

            }

        }

        /** Get the front item from the queue. */
        public int Front() {
            if (isEmpty())
                return -1;
            return buffer[head];
        }

        /** Get the last item from the queue. */
        public int Rear() {
            if (isEmpty())
                return -1;
            return buffer[tail];
        }

        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {
            return size == 0;
        }

        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {
            return size == buffer.length;
        }
    }

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
}
