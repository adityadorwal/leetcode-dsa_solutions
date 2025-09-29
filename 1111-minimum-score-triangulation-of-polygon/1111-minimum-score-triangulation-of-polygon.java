class Solution {
    Integer[][] memo;
    public int poly(int []value,int i,int j)
    {
        if(j-i<2)return 0;
        int m = Integer.MAX_VALUE;
        if(memo[i][j] != null) return memo[i][j];
        for(int k=i+1;k<j;k++)
        {
            int p = value[i]*value[k]*value[j];
            int left = poly(value,i,k);
            int right = poly(value,k,j);
            m = Math.min(m,(left+right+p));
        }
        memo[i][j] = m;
        return m;     
    }
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        memo = new Integer[n][n];
        return poly(values,0,n-1);
    }
}