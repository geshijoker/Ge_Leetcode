class Solution {
    struct TrieNode {
        unordered_map<char, TrieNode*> children;
        bool flag = false;
    };
public:
    TrieNode* node;
    
    Solution() {
        node = new TrieNode;
    }
    
    void insert(string entry) {
        TrieNode* cur = this->node;
        for(string::iterator it = entry.begin(); it != entry.end(); ++it){
            if((cur->children).find(*it) == (cur->children).end()) {
                (cur->children)[*it] = new TrieNode;
            }
            cur = (cur->children)[*it];
        }
        cur->flag = true;
    }
    
    string search(string word) {
        TrieNode * cur = this->node;
        int i=0;
        for(string::iterator it = word.begin(); it != word.end(); ++it) {
            if (cur->flag == true)
                break;
            if((cur->children).find(*it) == (cur->children).end()) {
                return word;
            }
            cur = (cur->children)[*it];
            i++;
        }
        return word.substr(0,i);
    }
    
    string replaceWords(vector<string>& dict, string sentence) {
        for(vector<string>::iterator it = dict.begin(); it != dict.end(); ++it) {
            this->insert(*it);
        }
        istringstream iss(sentence);
        vector<string> words((istream_iterator<string>(iss)), istream_iterator<string>());
        string result = "";
        for (vector<string>::iterator it = words.begin(); it != words.end(); ++it) {
            string word = this->search(*it);
            result += " ";
            result += word;
        }
        result.erase(0,1);
        return result;
    }
};
