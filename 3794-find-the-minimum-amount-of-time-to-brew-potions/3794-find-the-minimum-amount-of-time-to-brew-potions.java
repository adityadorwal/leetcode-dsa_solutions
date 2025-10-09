class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length , m = mana.length;
        long arr[] = new long[n+1];
        for(int i=0;i<m;i++)
        {
            long por = mana[i];
            long diff =0;
            for(int j=1;j<=n;j++)
            {
                if(arr[j-1]<arr[j]) 
                {
                    diff += arr[j]-arr[j-1];
                    arr[j-1] = arr[j]; 
                }
                arr[j] = arr[j-1]+skill[j-1]*por;
            }
            arr[0] = diff;
            for(int j=1;j<=n;j++)
            {
                arr[j] = arr[j-1]+skill[j-1]*por;
            }
            // for(long k:arr)System.out.print(k+" ");
            // System.out.println("  "+diff);
            arr[0] = 0;
        }
        return arr[n];
    }
}