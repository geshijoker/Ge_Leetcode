class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1)
            return s;
        StringBuilder sb = new StringBuilder();
        int cycle = 2*numRows-2;
        int n = s.length();
        for(int i=0;i<numRows;i++) {
            for(int j=0;j+i<n;j+=cycle) {
                sb.append(s.charAt(j + i));
                if(i!=0 && i!=numRows-1 && j+cycle-i<n)
                    sb.append(s.charAt(j+cycle-i));
            }
        }
        return sb.toString();
    }
}
