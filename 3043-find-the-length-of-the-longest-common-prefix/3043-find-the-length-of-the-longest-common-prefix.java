class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        int result=0;
        for(int num:arr1)
        {
            int p=1,k=1;
            while(num >= p)
            {
                set.add(num/p);
                p=p*10;
            }
        }
        for(int num:arr2)
        {
            int q,p=1,k=1;
            while(num >= p)
            {
                q=num/p;
                if(set.contains(q))result = Math.max(result,q);
                p=p*10;
            }
        }
        int prefix_length=0;
        while(result>0)
        {
            prefix_length++;
            result=result/10;
        }
        return prefix_length;
    }
}