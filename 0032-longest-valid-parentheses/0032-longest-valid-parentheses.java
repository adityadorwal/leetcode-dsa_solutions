class Solution {
    public int longestValidParentheses(String s) {
        Stack <Integer> stk = new Stack<Integer>();
        Stack <Integer> covered = new Stack<Integer>();
        int i,l=s.length(),t;
        for(i=0;i<l;i++)
        {
            if(s.charAt(i)=='(')
            stk.push(i);
            else if (!stk.isEmpty())
            {
                stk.pop();
                covered.push(i);
            }
        }
        int max=0,temp=0,a,b,open=0,close;
        System.out.println(covered);
        while(!covered.isEmpty())
        {
            a=covered.pop();
            open++;
            while((!covered.isEmpty()) && (covered.peek()==a-1))
            {
                a=covered.pop();
                open++;
            }
            if(!covered.isEmpty())
            close = a-covered.peek()-1;
            else
            close = a;

            temp=temp+(((open>=close)?close:open)*2);
            max = (temp>max)?temp:max;
            if(close>open)
            {
                temp=0;
                open =0;
            }
            else
            open=open-close;
        }
        return(max);
    }
}