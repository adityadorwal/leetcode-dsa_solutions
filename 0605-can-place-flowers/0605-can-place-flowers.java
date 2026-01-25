class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int a=1;
        for(int i:flowerbed)
        {
            if(i==1)a=0;
            else a++;
            if(a==3)
            {
                n--;
                a=1;
            }
        }
        if(a==2)n--;
        return(n<=0);
    }
}