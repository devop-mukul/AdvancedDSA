package Queue;
/* https://leetcode.com/problems/design-circular-queue/ */

public class CircularQueue {
    private int front;
    private int rear;
    private int[] arr;
    private int size;

    public CircularQueue(int k) {
        this.size = k;
        this.arr = new int[size];
        this.front = -1;
        this.rear = -1;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (front == -1 && rear == -1) {
            front = rear = 0;
            arr[rear] = value;
        } else if (front != 0 && rear == size - 1) {
            rear = 0;
            arr[rear] = value;
        } else {
            rear++;
            arr[rear] = value;
        }
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        arr[front] = -1;
        if (front == rear) {
            front = rear = -1;
        } else if (front == size - 1) {
            front = 0;
        } else {
            front++;
        }
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return arr[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[rear];
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public boolean isFull() {
        return (rear + 1) % size == front;
    }
}
