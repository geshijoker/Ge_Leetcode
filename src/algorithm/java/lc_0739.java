class Solution {
    public int[] dailyTemperatures(int[] T) {
        if(T.length==1)
            return new int[1];
        int[] marks = new int[71];
        int[] res = new int[T.length];
        Arrays.fill(marks, T.length);
        Arrays.fill(res, T.length);
        for(int i=T.length-1;i>=0;i--) {
            int temp = T[i];
            int j=temp-30;
            for(;j<71;j++){
                int date = marks[j];
                if(date>T.length-1)
                    continue;
                else if(T[date]>temp) {
                    res[i] = Math.min(res[i],date - i);
                }
            }
            if(res[i]>T.length-1)
                res[i]=0;
            marks[temp-30] = i;
        }
        return res;
    }
}
