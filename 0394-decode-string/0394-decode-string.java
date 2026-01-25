class Solution {
    public String decodeString(String s) {
        Stack<String> stk = new Stack<>();
        StringBuilder result = new StringBuilder();
        int i=0, len = s.length();
        int start=0;
        while(i<len)
        {
            char ch = s.charAt(i);
            if(Character.isDigit(ch))
            {
                if(stk.isEmpty())result.append(s.substring(start,i));
                else if(i!=start)stk.push(s.substring(start,i));
                start = i;
                while(s.charAt(++i) != '[');
                stk.push(s.substring(start,i));
                stk.push("[");
                start=i+1;
            }
            else if(ch ==']')
            {
                StringBuilder temp = new StringBuilder();
                String str = s.substring(start,i);
                stk.push(str);
                str =stk.pop();
                while(str != "[")
                {
                    temp.insert(0,str);
                    str = stk.pop();
                }
                int num = Integer.parseInt(stk.pop());
                str = temp.toString();
                for(int j=1;j<num;j++)
                {
                    temp.append(str);
                }
                if(stk.isEmpty())result.append(temp.toString());
                else stk.push(temp.toString());
                start=i+1;
            }
            i++;
        }
        result.append(s.substring(start,i));
        return result.toString();
    }
}