class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> details = new HashMap<>();
        int m=s.length(),n=t.length(),i;
        for ( i =0;i<n;i++)
        {
            details.put(t.charAt(i),details.getOrDefault(t.charAt(i),0)+1);
        }
        int front =0, back =0,size=0,k;
        char ch;
        String temp="",sub="";
        while(back<m)
        {
            if (details.containsKey(s.charAt(back)))
            {
                ch=s.charAt(back);
                k=details.get(ch);
                if (k>0)
                size++;
                details.merge(ch,-1,Integer::sum);
            }
            // System.out.println(details);
            while(size == n && front<=back)
                {
                    // System.out.println(s.substring(front,back+1)+" "+size);
                    temp = s.substring(front,back+1);
                    if(sub.length()==0 || sub.length()>temp.length())
                    {
                        sub = temp;
                        // System.out.println(sub);
                    }
                    if (details.containsKey(s.charAt(front)))
                    {
                        ch = s.charAt(front);
                        k=details.get(ch);
                        if(k>=0)
                        size--;
                        details.merge(ch,1,Integer::sum);
                    }
                    front++;
                    // System.out.println(details);
                }
                // System.out.println(s.substring(front,back+1)+" "+size);
            back++;
        }
        return sub;
    }
}