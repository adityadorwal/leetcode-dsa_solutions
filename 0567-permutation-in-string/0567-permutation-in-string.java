class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> map = new HashMap<>();
        int s1_len = s1.length();
        int s2_len = s2.length();
        if(s2_len<s1_len)return false;
        for(int i=0;i<s1_len;i++)
        {
            char ch = s1.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int left=0,len=s1_len;
        for(int right=0;right<len;right++)
        {
            char ch = s2.charAt(right);
            if(map.containsKey(ch))
            {
                int count = map.get(ch);
                map.put(ch,count-1);
                if(count>0)s1_len--;
                if(s1_len == 0)return true;
            }
        }
        System.out.println(map+" "+s1_len);
        for(int right = len ; right<s2_len;right++)
        {
            char ch = s2.charAt(right);
            char remo_ch = s2.charAt(right-len);
            if(map.containsKey(remo_ch))
            {
                int count = map.get(remo_ch);
                map.put(remo_ch, count+1);
                if(count>=0)s1_len++;
            }
            if(map.containsKey(ch))
            {
                int count = map.get(ch);
                map.put(ch,count-1);
                if(count>0)s1_len--;
                if(s1_len == 0)return true;
            }
            System.out.println(remo_ch+" "+ch);
        }
        return false;
    }
}