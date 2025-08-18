class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int match = 0 , left=0 ,subcost=0;
        Queue<Integer> que = new LinkedList<>();
        for(int right=0;right<s.length();right++)
        {
            int diff = Math.abs(s.charAt(right)-t.charAt(right));
            que.offer(diff);
            subcost += diff;
            while(subcost>maxCost)
            {
                subcost-=que.poll();
                left++;
            }
            match = Math.max(match,right-left+1);
        }
        return match;
    }
}