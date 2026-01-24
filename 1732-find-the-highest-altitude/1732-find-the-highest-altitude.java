class Solution {
    public int largestAltitude(int[] gain) {
        int highest = 0;
        int curr_alt = 0;
        for(int i:gain)
        {
            curr_alt += i;
            if(highest<curr_alt)highest = curr_alt;
        }
        return highest;
    }
}