class Solution {
    public int minimumPairRemoval(int[] nums) {
        int operations =0;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i:nums)arr.add(i);
        boolean unsorted = true;
        while(unsorted)
        {
            int min_sum = Integer.MAX_VALUE;
            unsorted = false;
            int ind=-1;
            int len = arr.size()-1;
            int curr, prev =arr.get(len);
            for(int i=len-1 ; i>=0;i--)
            {
                curr = arr.get(i);
                int sum = curr+prev;
                if(curr>prev)unsorted=true;
                if(sum <= min_sum)
                {
                    min_sum = sum;
                    ind = i;
                }
                prev = curr;
            }
            if(unsorted)
            {
                arr.remove(ind);
                arr.set(ind,min_sum);
                operations++;
            }
        }
        return operations;
    }
}