class Solution {
    public boolean closeStrings(String word1, String word2) {
        int len1 = word1.length() , len2 = word2.length();
        if(len1 != len2)return false;
        int [] arr = new int[26];
        int [] brr = new int[26];
        for(int i=0;i<len1;i++)
        {
            arr[word1.charAt(i)-'a']++;
            brr[word2.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++)
        {
            if((arr[i] > 0 && brr[i] == 0) || (arr[i] == 0 && brr[i] > 0))return false;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<26;i++)
        {
            int count = arr[i];
            map.put(count,map.getOrDefault(count,0)+1);
            int exchange = brr[i];
            map.put(exchange,map.getOrDefault(exchange,0)-1);
        }
        for(int key : map.keySet())
        {
            if(map.get(key)!=0)return false;
        }
        return true;
    }
}