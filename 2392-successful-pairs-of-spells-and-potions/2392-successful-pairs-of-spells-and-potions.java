class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length, m = potions.length;
        Arrays.sort(potions);

        for(int i=0;i<n;i++)
        {
            long a = spells[i];
            int s=0,e=m-1;
            while(s<=e)
            {
                int mid = (s+e)/2;
                long pro = a*potions[mid];
                if(pro>=success) e=mid-1;
                else s=mid+1;
            }
            spells[i] = m-s;
        }
        return spells;
    }
}