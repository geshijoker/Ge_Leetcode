class Solution {
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<numRows;i++) {
            List<Integer> row = new ArrayList<>();
            for(int j=0;j<=i;j++) {
                if(j==0 || j==i) row.add(1);
                else{
                    if(i<2) continue;
                    List<Integer> lastRow = res.get(res.size()-1);
                    row.add(lastRow.get(j-1)+lastRow.get(j));
                }
            }
            res.add(row);
        }
        return res;
    }
}
