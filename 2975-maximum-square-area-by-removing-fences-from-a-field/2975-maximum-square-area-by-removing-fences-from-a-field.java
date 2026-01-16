class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        HashSet<Integer> set = new HashSet<>();
        set.add(m-1);
        long max = 0;
        for(int i=0;i<hFences.length;i++)
        {
            int num = hFences[i];
            for(int j=i+1;j<hFences.length;j++)
            {
                set.add(Math.abs(num - hFences[j]));
            }
            set.add(Math.abs(1-num));
            set.add(m-num);
        }
        if(set.contains(n-1))
        {
            max = n-1;
            max = (max*max)%1000000007;
            return (int)max;
        }
        for(int i=0;i<vFences.length;i++)
        {
            int num = vFences[i];
            for(int j=i+1;j<vFences.length;j++)
            {
                int curr = Math.abs(num - vFences[j]);
                if(set.contains(curr))max = Math.max(max,curr);
            }
            if(set.contains(num-1))max = Math.max(max,num-1);
            if(set.contains(n-num))max = Math.max(max,n-num);
        }
        max = (max*max)%1000000007;
        return (max!=0)?(int)max:-1;
    }
}