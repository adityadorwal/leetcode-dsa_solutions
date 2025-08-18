class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int s_len = s.length(), p_len = p.length();
        if(s_len<p_len)return list;
        HashMap<Character,Integer> map = new HashMap<>();
        for ( int i=0 ; i<p_len ; i++)
        {
            char ch = p.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int len = p_len;

        for(int i=0;i<p_len;i++)
        {
            char ch = s.charAt(i);
            if(map.containsKey(ch))
            {
                int c = map.get(ch);
                map.put(ch,c-1);
                if(c>0)len--;
            }
        }
        if(len == 0)list.add(0);
    
        for(int i=p_len ; i<s_len ; i++)
        {
            char ch=s.charAt(i);
            char re=s.charAt(i-p_len);
            if(map.containsKey(re))
            {
                int c = map.get(re);
                if(c>=0)len++;
                map.put(re,c+1);
            }
            if(map.containsKey(ch))
            {
                int c = map.get(ch);
                if(c>0)len--;
                map.put(ch,c-1);
            }
            if(len == 0)list.add(i-p_len+1);
        }
        return (list);
    }
}