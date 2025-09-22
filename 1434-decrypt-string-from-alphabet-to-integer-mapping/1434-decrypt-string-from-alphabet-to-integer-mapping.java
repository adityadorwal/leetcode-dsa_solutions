class Solution {
    public String freqAlphabets(String s) {
        StringBuilder stb=new StringBuilder();
        int i=s.length()-1;
        while(i>=0){
            if(s.charAt(i)=='#'){
                int res=(s.charAt(i-2)-'0')*10+s.charAt(i-1)-'0';
                stb.append((char)('a'+res-1));
                i-=3;
            }
            else{
                stb.append((char)('a'+s.charAt(i)-'0'-1));
                i--;
            }
        }
        stb.reverse();
        return stb.toString();
    }
}