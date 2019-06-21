class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if(rowIndex<0) return res;
        res.add(1);
        if(rowIndex==0) return res;
        return helper(rowIndex, res);
    }
    public List<Integer> helper(int rowIndex, List<Integer> lastRow) {
        int size = lastRow.size() + 1;
        if(rowIndex +1< size) return lastRow;
        List<Integer> res = new ArrayList<>();
        for(int j=0;j<size;j++) {
            if(j==0 || j==size-1) res.add(1);
            else{
                if(size<=2) continue;
                res.add(lastRow.get(j-1)+lastRow.get(j));
            }
        }
        return helper(rowIndex, res);
    }
}
