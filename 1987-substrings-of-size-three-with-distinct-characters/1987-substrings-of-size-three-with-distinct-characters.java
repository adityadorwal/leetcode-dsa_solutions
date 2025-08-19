class Solution {
    public int countGoodSubstrings(String s) {
        int left=0,c=0;
        Set<Character> set = new HashSet<>();
        for(int right=0;right<s.length();right++)
        {
            char ch = s.charAt(right);
            while(set.contains(ch))set.remove(s.charAt(left++));
            set.add(ch);
            if(right-left+1 >= 3)c++;
        }
        return c;
    }
}