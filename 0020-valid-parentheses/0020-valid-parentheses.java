class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        int i;
        char ch;
        for(i=0;i<s.length();i++)
        {
            ch= s.charAt(i);
            if(ch==')' || ch=='}' || ch==']')
            {
                if(stk.isEmpty())
                return(false);
                else if(ch==')' && stk.peek() == '(')
                stk.pop();
                else if(ch=='}' && stk.peek() == '{')
                stk.pop();
                else if(ch==']' && stk.peek() == '[')
                stk.pop();
                else
                return(false);
            }
            else
            stk.push(ch);
        }
        return(stk.isEmpty());
    }
}