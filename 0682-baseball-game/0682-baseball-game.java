class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stk = new Stack<>();
        int sum = 0;
        for (int i = 0; i < operations.length; i++) {
            String str = operations[i];
            if (str.equals("C"))
                sum -= stk.pop();
            else if (str.equals("D")) {
                int dob = stk.peek() * 2;
                sum += dob;
                stk.push(dob);
            } else if (str.equals("+")) {
                int t = stk.pop();
                int add = t + stk.peek();
                stk.push(t);
                stk.push(add);
                sum += add;
            } else {
                int num = Integer.parseInt(str);
                sum += num;
                stk.push(num);
            }
        }
        return sum;
    }
}