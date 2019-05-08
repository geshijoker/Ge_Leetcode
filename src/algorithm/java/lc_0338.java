class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        res[0] = 0;
        int temp = 1;
        for(int i=1;i<=num;i++) {
            if(temp*2 == i)
                temp*=2;
            res[i] = res[i-temp]+1;
            System.out.println(res[i]);
        }
        return res;
    }
}
