import java.util.*;

class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.offer(s);
        visited.add(s);
        
        String ans = s;
        
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            
            // Update lexicographically smallest
            if (cur.compareTo(ans) < 0) {
                ans = cur;
            }
            
            // Operation 1: Add 'a' to digits at odd indices
            char[] arr = cur.toCharArray();
            for (int i = 1; i < arr.length; i += 2) {
                int digit = (arr[i] - '0' + a) % 10;
                arr[i] = (char) (digit + '0');
            }
            String added = new String(arr);
            if (visited.add(added)) {
                queue.offer(added);
            }
            
            // Operation 2: Rotate right by 'b' positions
            String rotated = cur.substring(cur.length() - b) + cur.substring(0, cur.length() - b);
            if (visited.add(rotated)) {
                queue.offer(rotated);
            }
        }
        
        return ans;
    }
}
