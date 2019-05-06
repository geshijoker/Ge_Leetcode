class Solution {
    public int hammingDistance(int x, int y) {
        int flag = (x ^ y);
        int count = 0;
        for(int i=0;i<31;i++) {
            if( ((flag >> i)&1) % 10 == 1) 
                count++;
        }
        return count;
    }
}
