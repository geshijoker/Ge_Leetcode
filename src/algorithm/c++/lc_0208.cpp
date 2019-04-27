#define N 26

struct TrieNode {
    TrieNode* children[N] = {};
    bool flag = false;
};
class Trie {
public:
    /** Initialize your data structure here. */
    TrieNode* node;
    
    Trie() {
        node = new TrieNode;
    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
        TrieNode* cur = this->node;
        for(string::iterator it = word.begin(); it != word.end(); ++it) {
            if((cur->children)[*it-'a'] == nullptr) {
                (cur->children)[*it-'a'] = new TrieNode;
            }
            cur = (cur->children)[*it-'a'];
        }
        cur->flag = true;
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        TrieNode* cur = this->node;
        for(string::iterator it = word.begin(); it != word.end(); ++it) {
            if((cur->children)[*it-'a'] == nullptr) {
                return false;
            }
            cur = (cur->children)[*it-'a'];
        }
        return cur->flag;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        TrieNode* cur = this->node;
        for(string::iterator it = prefix.begin(); it != prefix.end(); ++it) {
            if((cur->children)[*it-'a'] == nullptr) {
                return false;
            }
            cur = (cur->children)[*it-'a'];
        }
        return true;
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */
