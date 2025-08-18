/*******************TWO Pointer Method**************************************** */
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

/**********************************Stack WAY ************************ */
// class Solution {
//     public int equalSubstring(String s, String t, int maxCost) {
//         int match = 0 ,subcost=0;
//         Queue<Integer> que = new LinkedList<>();
        
//         for(int right=0;right<s.length();right++)
//         {
//             int diff = Math.abs(s.charAt(right)-t.charAt(right));
//             que.offer(diff);
//             subcost += diff;
//             while(subcost>maxCost)subcost-=que.poll();

//             match = Math.max(match,que.size());
//         }
//         return match;
//     }
// }