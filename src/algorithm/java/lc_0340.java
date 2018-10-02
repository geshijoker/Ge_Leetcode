public class Solution {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if(s==null || s.length()==0 || k==0)
            return 0;
        if(s.length()<=k)
            return s.length();
        int n = s.length();
        int[] arr = new int[60];
        Arrays.fill(arr,-1);
        int max = 0;
        int count = 0;
        int i=0;
        int j=0;
        char[] sc = s.toCharArray();
        while(i<n && j<=i) {
            if(arr[sc[i]-'A']<0)
                count++;
            if(count>k) {
                while(j<arr[sc[j]-'A']){
                    j++;
                }
                arr[sc[j]-'A']=-1;
                j++;
                count--;
            }
            arr[sc[i]-'A'] = i;
            i++;
            max = Math.max(max,i-j);
        }
        return max;
    }
}
