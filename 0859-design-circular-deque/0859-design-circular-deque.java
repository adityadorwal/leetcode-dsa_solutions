class MyCircularDeque {
    int [] arr;
    int front,rear,len;
    public MyCircularDeque(int k) {
        arr = new int[k+1];
        front = 0;
        rear =0;
        len = k+1;
    }
    
    public boolean insertFront(int value) {
        if(isFull())return false;
        front = (front-1+len)%len;
        arr[front]=value;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull())return false;
        arr[rear] = value;
        rear = (rear+1)%len;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty())return false;
        front = (front+1)%len;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty())return false;
        rear = (rear-1+len)%len;
        return true;
    }
    
    public int getFront() {
        if(isEmpty())return -1;
        return arr[front];
    }

    public int getRear() {
        if(isEmpty())return -1;
        return arr[(rear - 1 + len) % len];
    }
    
    public boolean isEmpty() {
        if(front == rear)return true;
        return false;
    }
    
    public boolean isFull() {
        if((rear+1)%len == front)return true;
        return false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */