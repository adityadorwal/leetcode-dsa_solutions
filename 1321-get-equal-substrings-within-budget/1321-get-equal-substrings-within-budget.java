class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int match = 0 , left=0 ,subcost=0;
        for(int right=0;right<s.length();right++)
        {
            subcost += Math.abs(s.charAt(right)-t.charAt(right));
            while(subcost>maxCost)
            {
                subcost-=Math.abs(s.charAt(left)-t.charAt(left));
                left++;
            }
            match = Math.max(match,right-left+1);
        }
        return match;
    }
}