class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m>n) {
            int[] temp=nums1; nums1=nums2; nums2=temp;
            int tmp=m; m=n; n=tmp;
        }
        int imin = 0, imax = m;
        while(imin<=imax) {
            int i = (imin+imax)/2;
            int j = (m+n+1)/2 - i;
            if (i < imax && nums2[j-1] > nums1[i]) {
                imin = i+1;
            }
            else if (i > imin && nums1[i-1] > nums2[j]) {
                imax = i-1;
            }
            else {
                int maxLeft = 0;
                if(i==0) {maxLeft = nums2[j-1];}
                else if(j==0) {maxLeft = nums1[i-1];}
                else {maxLeft = Math.max(nums2[j-1], nums1[i-1]);}
                if((m+n)%2==1) {return maxLeft;}
                
                int minRight = 0;
                if(i==m) {minRight = nums2[j];}
                else if(j==n) {minRight = nums1[i];}
                else {minRight = Math.min(nums2[j], nums1[i]);}
                
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
