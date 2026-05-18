class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> map1 = new HashMap<>();
        HashMap<String,Character> map2 = new HashMap<>();
        int m = pattern.length();
        String arr[] = s.split(" ");
        if(m!=arr.length)return false;

        for(int i=0;i<m;i++)
        {
            char ch = pattern.charAt(i);
            if(map1.containsKey(ch) && map2.containsKey(arr[i]))
            {
                if(!map1.get(ch).equals(arr[i]) || !map2.get(arr[i]).equals(ch))return false;
            }
            else if(map1.containsKey(ch) || map2.containsKey(arr[i])) return false;

            map1.put(ch,arr[i]);
            map2.put(arr[i],ch);
        }
        return true;
    }
}