class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int size = bits.length, i=0;
        while(i<size-1)
        {
            if(bits[i] == 0)i+=1;
            else i+=2;
        }
        return i==size-1;
    }
}