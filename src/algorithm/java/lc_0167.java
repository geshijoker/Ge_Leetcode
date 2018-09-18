class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers==null || numbers.length==0)
            return null;
        int[] res = new int[2];
        for(int i=0,j=numbers.length-1;i<j;i++) {
            int temp = target-numbers[i];
            while(temp<numbers[j]) {
                j--;
            }
            if(temp==numbers[j]) {
                res[0] = i+1;
                res[1] = j+1;
                break;
            }
        }
        return res;
    }
}
