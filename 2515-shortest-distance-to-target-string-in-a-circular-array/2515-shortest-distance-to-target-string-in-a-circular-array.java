class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n=words.length;
        int result =n;
        for(int i=0; i<n;i++)
        {
            if(target.equals(words[i]))
            {
                int gap = Math.abs(startIndex-i);
                result = Math.min(result,Math.min(n-gap,gap));
            }
        }
        if(result==n)return -1;
        return result;
    }
}