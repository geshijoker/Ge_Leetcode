class Solution {
    public int candy(int[] ratings) {
        if(ratings==null || ratings.length==0)
            return 0;
        if(ratings.length==1)
            return 1;
        int n = ratings.length;
        int res = 0;
        int[] arr = new int[n];
        arr[0] = 1;
        for(int i=1;i<n;i++) {
            arr[i] = (ratings[i]>ratings[i-1])? arr[i-1]+1 : 1;
        }
        for(int i=n-2;i>=0;i--) {
            arr[i] = (ratings[i]>ratings[i+1])? Math.max(arr[i],arr[i+1]+1) : arr[i];
            res += arr[i];
        }
        return res+arr[n-1];
    }
}
