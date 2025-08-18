class Solution {
    public int maxVowels(String s, int k) {
        int max_vo = 0;
        for(int i=0;i<k;i++)
        {
            char ch = s.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')max_vo ++;
        }
        int sum = max_vo;
        for(int i=k;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')sum++;
            ch = s.charAt(i-k);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')sum--;
            max_vo = Math.max(max_vo,sum);
            if(max_vo==k)return k;
        }
        return max_vo;
    }
}