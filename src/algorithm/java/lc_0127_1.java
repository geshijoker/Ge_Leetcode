public class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    if (beginWord == null || endWord == null || beginWord.equals(endWord)) {
      return 0;
    }
      
      // Each transformed word must exist in the word list.
      if(wordList == null || wordList.isEmpty() || !wordList.contains(endWord)){
          return 0;
      }
      
      
    int size = wordList.size();
    Set<String> beginSet = new HashSet<>(size);
    Set<String> endSet = new HashSet<>(size);
    Set<String> dictSet = new HashSet<>(wordList); // have a copy of input
    beginSet.add(beginWord);
    endSet.add(endWord);
    int steps = 1;
    while (!beginSet.isEmpty() && !endSet.isEmpty()) {
      /*
       * if beginSet bigger than endSet, swap them, make sure beginSet.size() <= endSet.size()
       */
      if (beginSet.size() > endSet.size()) {
        Set<String> set = beginSet;
        beginSet = endSet;
        endSet = set;
      }
      Set<String> tmpSet = new HashSet<>();
      for (String word : beginSet) {
        char[] wordArr = word.toCharArray();
        int wordLen = wordArr.length;
        for (int i = 0; i < wordLen; i++) {
          char ch = wordArr[i];
          // update one char in word
          for (char c = 'a'; c <= 'z'; c++) {
            wordArr[i] = c;
            String newWord = String.valueOf(wordArr);
            if (endSet.contains(newWord)) {
              return steps + 1;
            }
            if (dictSet.contains(newWord)) {
              dictSet.remove(newWord);// mark as checked
                
              tmpSet.add(newWord);
            }
          }
          wordArr[i] = ch;// reset for next compute
        }
      }
      // update beginSet to move forward one step
      beginSet = tmpSet;
      steps++;
    }

    // no such transformation sequence
    return 0;
  }
}
