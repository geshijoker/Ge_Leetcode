class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        dict.addAll(wordList);
        dict.remove(beginWord);
        List<List<String>> result = new ArrayList<>();
        if (!dict.contains(endWord)) {
            return result;
        }
        HashMap<String, List<String>> child = new HashMap<>();
        HashSet<String> begin = new HashSet<>();
        HashSet<String> end = new HashSet<>();
        begin.add(beginWord);
        end.add(endWord);
        boolean found = false;
        boolean swap = false;
        while (!found && !begin.isEmpty() && !end.isEmpty()) {
            if (begin.size() > end.size()) {
                HashSet<String> temp = begin;
                begin = end;
                end = temp;
                swap = !swap;
            }
            dict.removeAll(begin);
            dict.removeAll(end);
            HashSet<String> temp = new HashSet<>();
            for (String word : begin) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char orig = chars[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String new_word = new String(chars);
                        String key = swap? new_word:word;
                        String value = swap? word:new_word;
                        if (end.contains(new_word)) {
                            found = true;
                            if(!child.containsKey(key)) {
                                child.put(key, new ArrayList<>());
                            }
                            child.get(key).add(value);
                        } else if (dict.contains(new_word) && !found) {
                            temp.add(new_word);
                            if (!child.containsKey(key)) {
                                child.put(key, new ArrayList<>());
                            }
                            child.get(key).add(value);
                        }
                    }
                    chars[i] = orig;
                }
            }
            begin = temp;
        }
        if (found) {
            List<String> path = new ArrayList<>();
            path.add(beginWord);
            getPaths(beginWord, endWord, child, path, result);
        }
        return result;
    }

    private void getPaths(String word, String endWord, HashMap<String, List<String>> children, List<String> path, List<List<String>> result) {
        if (word.equals(endWord)) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (!children.containsKey(word)) {
            return;
        }
        for (String child:children.get(word)) {
            path.add(child);
            getPaths(child, endWord, children, path, result);
            path.remove(path.size()-1);
        }
    }
}
