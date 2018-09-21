public class Solution {
    public int grabFruit(int[] fruits) {
        if(fruits==null || fruits.length==0)
            return 0;
        int res = 0;
        int n = fruits.length;
        int j=0;
        int k=0;
        while(k<n && fruits[j]==fruits[k]){
            k++;
            res = Math.max(res,k-j);
        }
        for(int i=k;i<n;){
            if(fruits[i]!=fruits[j] && fruits[i]!=fruits[k]) {
                j=k;
                k=i;
            }
            i++;
            res = Math.max(res,i-j);
        }
        return res;
    }
}
