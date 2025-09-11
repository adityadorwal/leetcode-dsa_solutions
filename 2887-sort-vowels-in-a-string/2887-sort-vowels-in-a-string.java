class Solution {
    public String sortVowels(String s) {
        HashMap<Character,Integer> map = new LinkedHashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);

        char arr[] = new char[]{'A','E','I','O','U','a','e','i','o','u'};
        for(char i:arr) map.put(i,0);
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U' ||
             ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')
            {
                map.put(ch,map.get(ch)+1);
                list.add(i);
            }
        }

        int k=0;
        for(char ch:map.keySet())
        {
            int n = map.get(ch);
            if(n == 0)continue;
            for(int i=0;i<n;i++) sb.setCharAt(list.get(k++),ch);
        }
        return sb.toString();
    }
}