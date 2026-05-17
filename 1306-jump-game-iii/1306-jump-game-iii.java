class Solution {
    public boolean canReach(int[] arr, int start) {
        if(start<0 || start>=arr.length )return false;
        if(arr[start]==-1)return false;
        int num = arr[start];
        if(num == 0)return true;
        arr[start]=-1;
        return (canReach(arr , start+num) || canReach(arr,start-num));
    }
}