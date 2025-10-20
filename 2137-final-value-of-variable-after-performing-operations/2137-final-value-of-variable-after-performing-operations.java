class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int num=0;
        for(int i=0;i<operations.length;i++)
        {
            if(operations[i].charAt(1) == '+')num++;
            else num--;
        }
        return num;
    }
}