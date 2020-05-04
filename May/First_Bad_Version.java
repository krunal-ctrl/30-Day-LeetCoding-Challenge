/*
You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. 
You should minimize the number of calls to the API.
Example:

Given n = 5, and version = 4 is the first bad version.

call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true

Then 4 is the first bad version. 
*/
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return returnIsVersion(1, n);
    }
    
    int returnIsVersion(int left, int right) {
        if (left>=right) {
            return left;
        }
        
        int mid = left +(right-left) / 2;
        
        if (isBadVersion(mid)) {
            return returnIsVersion(left, mid);
        } else {
            return returnIsVersion(mid+1, right);
    
        }
    }
}
