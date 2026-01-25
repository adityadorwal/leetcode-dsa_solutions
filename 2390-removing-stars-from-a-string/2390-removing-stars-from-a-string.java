class Solution {
    public String removeStars(String s) {
        StringBuilder result = new StringBuilder();
        int c=0;
        for(int i = s.length()-1;i>=0;i--)
        {
            char ch = s.charAt(i);
            if( ch == '*')c++;
            else if(c>0) c--;
            else result.append(ch);
        }
        return result.reverse().toString();
    }
}