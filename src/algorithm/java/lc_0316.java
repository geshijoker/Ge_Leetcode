    public String removeDuplicateLetters(String s) {
        
        if (s == null || s.isEmpty())
            return s;
        
        int[] freq = new int[26];
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            freq[ch - 'a']++;
        }       
        Stack<Character> stack = new Stack<>();
        stack.push(chars[0]);
        freq[chars[0] - 'a']--;
        
        for(int i = 1; i < chars.length; i++) {
            freq[chars[i] - 'a']--;
            if (stack.contains(chars[i])) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > chars[i] && freq[stack.peek() - 'a'] > 0) {
                stack.pop();
            }
            stack.push(chars[i]);
        }
        
        StringBuilder stringBuilder = new StringBuilder();
        while(!stack.isEmpty()) {
            stringBuilder.insert(0, stack.pop());
        }
        
        return stringBuilder.toString();
    }
