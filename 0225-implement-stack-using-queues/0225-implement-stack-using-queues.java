class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q1.add(x); // O(1)
    }

    public int pop() {
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }
        int val = q1.poll(); // last item = top of stack
        swap();
        return val;
    }

    public int top() {
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }
        int val = q1.poll();
        q2.add(val); // re-insert it since it's top()
        swap();
        return val;
    }

    public boolean empty() {
        return q1.isEmpty();
    }

    private void swap() {
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
}
