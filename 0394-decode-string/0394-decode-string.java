class Solution {
    Stack <Character> stk = new Stack<>();
    Stack <String> sub = new Stack<>();

    public String iter(String s, int n)
    {
        if (n==1)return s;
        return (s+iter(s,n-1));
    }
    int start=0,z=1;

    public String decodeString(String s) {
        int i=0,l=s.length(),open=0;
        String str="",num="",temp="",result="";
        System.out.println(s);
        while(start<l)
        {
            if(s.charAt(start)=='[')
            {
                start++;
                // for(int y=0;y<z;y++)System.out.print("   ");
                // z++;
                str = decodeString(s);
                // System.out.println(str);
                if(num=="")num="1";
                temp = temp + iter(str,Integer.parseInt(num));
                num="";
                // System.out.println("he"+start);
                z--;
            }
            else if(Character.isDigit(s.charAt(start)))
            {
                num = num+s.charAt(start);
                
            }
            else if(s.charAt(start)==']')
            {
                return(temp);
            }
            else
            {
                temp+=s.charAt(start);
                System.out.println(temp);
            }
            System.out.println(i);
            i++;
            start++;

        }
        return temp;
        
    }
}