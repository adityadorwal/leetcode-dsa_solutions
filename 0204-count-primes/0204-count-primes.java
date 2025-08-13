class Solution {
    public int countPrimes(int n) {
        boolean arr[] = new boolean[n];
        int l = (int)Math.floor(Math.sqrt(n));
        if(n<2)return 0;
        arr[0]=true;
        arr[1]=true;
        for(int i=2; i<=l;i++)
        {
            // System.out.println(i);
            if(arr[i] == false)
            for(int j = i*i ; j<n ; j+=i)arr[j]=true;
        }
        System.out.println("hey");
        l=0;
        int k=0;
        for(boolean z : arr)
        {
            // System.out.println(k + " " + z);
            if(!z)l++;
            k++;
        }
        return l;
    }
}