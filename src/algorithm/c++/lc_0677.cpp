class MapSum {
    struct TrieNode {
        unordered_map<char, TrieNode*> children;
        int value = 0;
        bool flag = false;
    };
public:
    /** Initialize your data structure here. */
    TrieNode* node;
    
    MapSum() {
        node = new TrieNode;
    }
    
    void insert(string key, int val) {
        TrieNode* cur = this->node;
        for(string::iterator it = key.begin(); it != key.end(); ++it) {
            if((cur->children).find(*it) == (cur->children).end()){
                (cur->children)[*it] = new TrieNode;
            }
            cur = (cur->children)[*it];
            cur->value = cur->value + val;
        }
        if(cur->flag==false)
            cur->flag = true;
        else{
            cur = this->node;
            for(string::iterator it = key.begin(); it != key.end(); ++it) {
                if((cur->children).find(*it) == (cur->children).end()){
                    (cur->children)[*it] = new TrieNode;
                }
                cur = (cur->children)[*it];
                cur->value = val;
            }
        }
    }
    
    int sum(string prefix) {
        TrieNode* cur = this->node;
        for(string::iterator it = prefix.begin(); it != prefix.end(); ++it) {
            if((cur->children).find(*it) == (cur->children).end()){
                return 0;
            }
            cur = (cur->children)[*it];
        }
        return cur->value;
    }
};

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum* obj = new MapSum();
 * obj->insert(key,val);
 * int param_2 = obj->sum(prefix);
 */
