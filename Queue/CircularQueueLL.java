package Queue;

public class CircularQueueLL {
    class Node {
        int val;
        Node next;

        Node (int val) {
            this.val = val;
            this.next = null;
        }
    }

    Node dummy;
    Node head;
    Node tail;

    int curSize;
    int maxSize;

    public CircularQueueLL(int k) {
        this.dummy = new Node(-1);
        this.head = dummy;
        this.tail = dummy;

        this.curSize = 0;
        this.maxSize = k;
    }
    
    public boolean enQueue(int value) {
        if (curSize == maxSize) {
            return false;
        }
        tail.next = new Node(value);
        tail = tail.next;
        curSize++;
        if (curSize == 1) {
            head = tail;
        }
        return true;
    }
    
    public boolean deQueue() {
        if (curSize == 0) {
            return false;
        }
        head = head.next;
        curSize--;
        if (curSize == 0) {
            tail = dummy;
            head = dummy;
        }
        return true;
    }
    
    public int Front() {
        if (curSize == 0) {
            return -1;
        }

        return head.val;
    }
    
    public int Rear() {
        if (curSize == 0) {
            return -1;
        }

        return tail.val;
    }
    
    public boolean isEmpty() {
        return curSize == 0;
    }
    
    public boolean isFull() {
        return curSize == maxSize;
    }
}
