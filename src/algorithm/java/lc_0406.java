class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length<2)
            return people;
        int len = people.length;
        int[][] res = new int[len][2];
        Arrays.sort(people, (a, b) -> Integer.compare(a[0], b[0])==0 ? Integer.compare(a[1], b[1])<=0 ? 1 : -1 : Integer.compare(a[0], b[0])<0? -1: 1);
        List<Integer> unoccupy = new ArrayList<>();
        for(int i=0;i<len;i++) {
            unoccupy.add(i);
        }
        for(int i=0;i<len;i++) {
            int index = unoccupy.get(people[i][1]);
            res[index] = people[i];
            unoccupy.remove(people[i][1]);
        }
        return res;
    }
}
