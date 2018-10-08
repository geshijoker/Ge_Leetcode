class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if(wordList==null || wordList.size()==0 || !wordList.contains(endWord) || beginWord == null || endWord == null)
            return res;
        if (beginWord.equals(endWord)) {
            List<String> temp = new ArrayList<>();
            temp.add(beginWord);
            temp.add(endWord);
            res.add(temp);
            return res;
        }
        Set<String> wordSet = new HashSet<>();
        wordSet.addAll(wordList);
        int len=1, limit=0;
        Map<String,List<String>> beginMap = new HashMap<>();
        Map<String,List<String>> endMap = new HashMap<>();
        List<String> beginTemp = new ArrayList<>();
        beginTemp.add(beginWord);
        beginMap.put(beginWord,beginTemp);
        List<String> endTemp = new ArrayList<>();
        endTemp.add(endWord);
        endMap.put(endWord,endTemp);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        visited.add(endWord);
        
        boolean flag = true;
        while(!beginMap.isEmpty() && !endMap.isEmpty() && len>limit){
            if(beginMap.size()>endMap.size()) {
                flag = !flag;
                Map<String,List<String>> tempMap = endMap;
                endMap = beginMap;
                beginMap = tempMap;
            }
        
            Map<String,List<String>> temp = new HashMap<>();
            for(String word : beginMap.keySet()){
                char[] wordArr = word.toCharArray();
                for(int i=wordArr.length-1;i>=0;i--){
                    char old = wordArr[i];
                    for(char ch = 'a'; ch <= 'z'; ch++) {
                        wordArr[i] = ch;
                        String newWord = String.valueOf(wordArr);
                        if(endMap.containsKey(String.valueOf(wordArr))){
                            limit = len+1;
                            List<String> tempList = new ArrayList<>();
                            if(flag) {
                                tempList.addAll(beginMap.get(word));
                                tempList.addAll(endMap.get(newWord));
                            }else{
                                tempList.addAll(endMap.get(newWord));
                                tempList.addAll(beginMap.get(word));
                            }
                            res.add(tempList);
                        }
                        if(!visited.contains(newWord) && wordSet.contains(newWord)) {
                            visited.add(newWord);
                            List<String> tempList = new ArrayList(beginMap.get(word));
                            if(flag)
                                tempList.add(newWord);
                            else
                                tempList.add(0,newWord);
                            temp.put(newWord,tempList);
                        }
                    }
                    wordArr[i] = old;
                }
            }
            beginMap = temp;
            len++;
        }
        return res;
    }
}
