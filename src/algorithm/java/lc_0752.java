class Solution {
    public int openLock(String[] deadends, String target) {
        StringBuilder str = new StringBuilder("0000");
        Queue<StringBuilder> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        HashSet<String> deads = new HashSet<>();
        for(String dead : deadends) {
            deads.add(dead);
        }
        char[] arr = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        q.add(str);
        visited.add(str.toString());
        int res = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; ++j) {
                StringBuilder cur = q.poll();
                //System.out.println(cur.toString());
                if(target.equals(cur.toString()))
                    return res;
                if(deads.contains(cur.toString()))
                    continue;
                for(int i=0;i<4;i++) {
                    char ch = cur.charAt(i);
                    int chi = ch - '0';
                    StringBuilder strp = new StringBuilder(cur);
                    strp.setCharAt(i, arr[(chi+11)%10]);
                    if (!visited.contains(strp.toString())) {
                        q.add(strp);
                        visited.add(strp.toString());
                    }
                    StringBuilder strm = new StringBuilder(cur);
                    strm.setCharAt(i, arr[(chi+9)%10]);
                    if (!visited.contains(strm.toString())) {
                        q.add(strm);
                        visited.add(strm.toString());
                    }
                }
            }
            res++;
        }
        return -1;
    }
}
