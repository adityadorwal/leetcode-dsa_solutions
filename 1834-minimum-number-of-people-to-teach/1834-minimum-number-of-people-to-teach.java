class Solution {
    public boolean commonlanguage(int []a, int []b)
    {
        for(int i:a)
        {
            for(int j:b)
            {
                if(i==j)return true;
            }
        }
        return false;
    }
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        HashSet<Integer> set = new HashSet<>();
        for(int []i:friendships)
        {
            if(!commonlanguage(languages[i[0]-1] , languages[i[1]-1]))
            {
                set.add(i[0]);
                set.add(i[1]);
            }
        }

        System.out.println(set);
        n=set.size();
        if(n==0)return 0;

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:set)
        {
            for(int j:languages[i-1])
            {
                map.put(j,map.getOrDefault(j,0)+1);
            }
        }
        int max=0;
        for(int i:map.keySet())
        {
            max=Math.max(max,map.get(i));
        }
        System.out.println(map);
        return n-max;
    }
}