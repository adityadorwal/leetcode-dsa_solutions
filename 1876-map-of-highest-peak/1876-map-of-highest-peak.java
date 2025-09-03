class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int max = isWater.length+isWater[0].length;
        int m=isWater.length,n=isWater[0].length;
        for (int i = 0; i <m ;i++)
        {
            for (int j = 0; j <n; j++)
            {
                if (isWater[i][j] == 1) isWater[i][j]=0;
                else isWater[i][j]=max;
            }
        }
        for(int i=0 ;i<m;i++)
        {
            for(int j=0; j<n;j++)
            {
                    int a = (i>0)?isWater[i-1][j]+1:max;
                    int b = (j>0)?isWater[i][j-1]+1:max;
                    isWater[i][j]=Math.min(isWater[i][j],Math.min(a,b));
            }
        }
        for(int i=m-1 ;i>=0;i--)
        {
            for(int j=n-1 ;j>=0;j--)
            {
                    int a = (i<m-1)?isWater[i+1][j]+1:max;
                    int b = (j<n-1)?isWater[i][j+1]+1:max;
                    isWater[i][j]=Math.min(isWater[i][j],Math.min(a,b));
            }
        } 
        return isWater;
    }
}