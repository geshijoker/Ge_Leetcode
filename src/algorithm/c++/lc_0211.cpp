class WordDictionary {
    struct TrieNode {
        unordered_map<char, TrieNode*>children;
        bool flag = false;
    };
    TrieNode *node;
public:
    /** Initialize your data structure here. */
    WordDictionary() {
        node = new TrieNode;
    }
    
    /** Adds a word into the data structure. */
    void addWord(string word) {
        TrieNode* cur = this->node;
        for(string::iterator it=word.begin(); it!=word.end(); ++it) {
            if ((cur->children).find(*it)==(cur->children).end())
                (cur->children)[*it]=new TrieNode;
            cur = (cur->children)[*it];
        }
        cur->flag = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    bool search(string word) {
        TrieNode* cur = this->node;
        for(int it=0; it<word.length(); ++it) {
            if (word[it]=='.') {
                string temp_word = word;
                for(unordered_map<char, TrieNode*>::iterator ite=(cur->children).begin(); ite!=(cur->children).end(); ++ite) {
                    temp_word[it] = ite->first;
                    if (this->search(temp_word))
                        return true;
                }
                return false;
            }
            else if ((cur->children).find(word[it])==(cur->children).end())
                return false;
            cur = (cur->children)[word[it]];
        }
        return cur->flag;
    }
};

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary* obj = new WordDictionary();
 * obj->addWord(word);
 * bool param_2 = obj->search(word);
 */
