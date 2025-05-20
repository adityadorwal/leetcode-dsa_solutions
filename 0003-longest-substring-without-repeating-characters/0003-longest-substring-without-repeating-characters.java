class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0,right=0,max=0;
        HashMap<Character,Integer> map = new HashMap<>();
        char ch;
        while(right < s.length())
        {
            ch=s.charAt(right);
            if(map.containsKey(s.charAt(right)) && map.get(ch)>=left)
            {
                left=map.get(ch)+1;
            }
            map.put(ch,right);
            
            max=Math.max(max,right-left+1);

            right++;
        }
        return(max);
        
    }
}