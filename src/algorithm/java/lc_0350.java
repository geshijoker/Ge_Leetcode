class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int i=0;
        int j=0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> arr = new ArrayList<Integer>();
        while(i<nums1.length && j<nums2.length) {
            if(nums1[i] == nums2[j]) {
                arr.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }
            else{
                j++;
            }
        }
        int[] output = new int[arr.size()];
        for(i=0;i<arr.size();i++) {
            output[i] = arr.get(i);
        }
        return output;
    }
}
