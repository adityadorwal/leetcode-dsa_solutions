class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n= position.length;
        if(n==0 || n==1)return n;

        double [][] match = new double[n][2];
        Stack<Double> stk = new Stack<>();

        for(int i=0;i<n;i++)
        {
            match[i][0] = position[i];
            match[i][1] = (double)(target-position[i])/speed[i];
        }
        Arrays.sort(match,(a,b)->Double.compare(b[0],a[0]));
        for(int i=0;i<n;i++)
        {
            if((stk.isEmpty()) || (match[i][1]>stk.peek()))
            stk.push(match[i][1]);
        }
        return stk.size();
    }
}