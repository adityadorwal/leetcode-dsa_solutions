class Solution {
    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length(),len2 = word2.length();
        int i=0;
        StringBuilder result = new StringBuilder();
        while(i<len1 && i<len2)
        {
            result.append(word1.charAt(i));
            result.append(word2.charAt(i));
            i++;
        }
        if(i == len1)result.append(word2.substring(i));
        if(i == len2)result.append(word1.substring(i));
        return result.toString();
    }
}