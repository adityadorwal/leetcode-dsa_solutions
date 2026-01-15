class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int g1=1,g2=1;
        int prev=hBars[0];
        int c=1;
        for(int i=1;i<hBars.length;i++)
        {
            int num = hBars[i];
            if(num == prev+1)
            {
                c++;
                if(c>g1)g1=c;
            }
            else c=1;
            prev = num;
        }

        prev=vBars[0];
        c=1;
        for(int i=1;i<vBars.length;i++)
        {
            int num = vBars[i];
            if(num == prev+1)
            {
                c++;
                if(c>g2)g2=c;
            }
            else c=1;
            prev = num;
        }
        int min = Math.min(g1,g2)+1;
        return min*min;
    }
}