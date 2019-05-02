class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<String>();
        LinkedHashSet<String> hashSet = new LinkedHashSet<String>();
        if(board==null || board.length==0 || board[0].length==0)
            return res;
        if(words==null || words.length==0)
            return res;
        int row = board.length;
        int col = board[0].length;
        for(String word : words) {
            for(int i=0; i<row; i++) {
                for(int j=0; j<col; j++) {
                    if(word.charAt(0)==board[i][j]) {
                        if(DFS(board, word, 0, i, j, row, col) && hashSet.add(word))
                            res.add(word);
                    }
                }
            }
        }
        return res;
    }
    public boolean DFS(char[][] board, String word, int index, int i, int j, int row, int col) {
        if (word.length()==index)
            return true;
        if(i<0 || i>=row || j<0 || j>=col)
            return false;
        if(board[i][j]!=word.charAt(index))
            return false;
        char charc = board[i][j];
        board[i][j]='#';
        boolean res = DFS(board, word, index+1, i-1, j, row, col) || 
            DFS(board, word, index+1, i+1, j, row, col) || 
            DFS(board, word, index+1, i, j-1, row, col) || 
            DFS(board, word, index+1, i, j+1, row, col);
        board[i][j] = charc;
        return res;
    }
}
