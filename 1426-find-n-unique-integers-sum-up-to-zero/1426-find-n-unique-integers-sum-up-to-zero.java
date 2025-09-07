class Solution {
    public int[] sumZero(int n) {
        int []arr = new int[n];
        int s,e;
        if(n%2==0)
        {
            s=(n/2)-1;
            e=(n/2);
        }
        else
        {
            arr[n/2] = 0;
            s=(n/2)-1;
            e=(n/2)+1;
        }
        int k=1;
        while(s>=0)
        {
            arr[s--] = k*-1;
            arr[e++] = k;
            k++;
        }
        return arr;
    }
}