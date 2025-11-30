class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for(String i:tokens)
        {
            int a,b;
            if(i.equals("+"))
            {
                a=stk.pop();
                b=stk.pop();
                stk.push(b+a);
            }
            else if(i.equals("-"))
            {
                a=stk.pop();
                b=stk.pop();
                stk.push(b-a);
            }
            else if(i.equals("*"))
            {
                a=stk.pop();
                b=stk.pop();
                stk.push(a*b);
            }
            else if(i.equals("/"))
            {
                a=stk.pop();
                b=stk.pop();
                stk.push(b/a);
            }
            else
            {
                stk.push(Integer.parseInt(i));
            }
        }
        return stk.pop();
    }
}