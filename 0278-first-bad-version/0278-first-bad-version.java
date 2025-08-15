/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int a=1;
        while(a<=n)
        {
            int mid = a+(n-a)/2;
            if(isBadVersion(mid))n=mid-1;
            else a=mid+1;
        }
        return a;
    }
}