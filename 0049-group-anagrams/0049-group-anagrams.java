class Solution {
    public List<List<String>> groupAnagrams(String[] str) {
        HashMap<String ,List<String>> map = new HashMap<>();
        for(int i=0;i<str.length;i++)
        {
            char[] arr = str[i].toCharArray();
            Arrays.sort(arr);
            String sorted= new String(arr);
            if(!map.containsKey(sorted))
            map.put(sorted,new ArrayList<>());
            map.get(sorted).add(str[i]);
        }
        return (new ArrayList<>(map.values()));
    }
}