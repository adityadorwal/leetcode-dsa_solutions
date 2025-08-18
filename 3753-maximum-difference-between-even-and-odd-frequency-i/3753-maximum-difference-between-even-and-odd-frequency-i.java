class Solution {
    public int maxDifference(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int odd_max=0,even_max=Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char i:map.keySet())
        {
            int num = map.get(i);
            if(num%2==0)even_max = Math.min(even_max,num);
            else odd_max = Math.max(odd_max,num);
        }
        return odd_max-even_max;
    }
}