class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int flag = 0;
        Map<String, Integer> map = new HashMap<>(wordList.size()+1);
        map.put(beginWord,0);
        for(int i=0;i<wordList.size();i++) {
            map.put(wordList.get(i),0);
            if(wordList.get(i).equals(endWord))
                flag++;
        }
        if(flag==0)
            return 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while(!queue.isEmpty() && map.get(endWord)==0) {
            BFShelper(queue, map, wordList);
        }
        return map.get(endWord)==0?0:map.get(endWord)+1;
    }
    public int checkDiff(String beginWord, String endWord) {
        char[] beginC = beginWord.toCharArray();
        char[] endC = endWord.toCharArray();
        int diff = 0;
        for(int i=0;i<beginC.length;i++) {
            if(beginC[i]!=endC[i])
                diff++;
        }
        return diff;
    }
    public void BFShelper(Queue<String> queue, Map<String, Integer> map, List<String> wordList) {
        int num = queue.size(); 
        for(int i=0;i<num;i++) {
            String beginWord = queue.poll();
            for(String endWord : wordList) {
                if(checkDiff(beginWord, endWord)==1) {
                    if(map.get(endWord)==0 || map.get(endWord)>map.get(beginWord)+1) {
                        map.put(endWord,map.get(beginWord)+1);
                        queue.offer(endWord);
                    }
                }
            }  
        }
    }
}
