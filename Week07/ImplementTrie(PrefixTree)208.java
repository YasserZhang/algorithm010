//Implement a trie with insert, search, and startsWith methods.
//
// Example:
//
//
//Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // returns true
//trie.search("app");     // returns false
//trie.startsWith("app"); // returns true
//trie.insert("app");
//trie.search("app");     // returns true
//
//
// Note:
//
//
// You may assume that all inputs are consist of lowercase letters a-z.
// All inputs are guaranteed to be non-empty strings.
//
// Related Topics Design Trie
// 👍 3497 👎 53


//leetcode submit region begin(Prohibit modification and deletion)
class Trie {

    /*    Success:
        Runtime:30 ms, faster than 92.58% of Java online submissions.
        Memory Usage:48.7 MB, less than 86.70% of Java online submissions.*/
    private boolean isEnd;
    private Trie[] next;
    //** Initialize your data structure here. *//*
    public Trie() {
        next = new Trie[26];
        isEnd = false;
    }

    //** Inserts a word into the trie. *//*
    public void insert(String word) {
        if (word == null || word.length() == 0) return;
        Trie curr = this;
        for (int i = 0; i < word.length(); ++i) {
            int idx = word.charAt(i) - 'a';
            if (curr.next[idx] == null) curr.next[idx] = new Trie();
            curr = curr.next[idx];
        }
        curr.isEnd = true;
    }

    //** Returns if the word is in the trie. *//*
    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    //** Returns if there is any word in the trie that starts with the given prefix. *//*
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) return false;
        Trie node = searchPrefix(prefix);
        return node != null;
    }

    private Trie searchPrefix(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); ++i) {
            int idx = word.charAt(i) - 'a';
            node = node.next[idx];
            if (node == null) return null;
        }
        return node;
    }


/*    Success:
    Runtime:38 ms, faster than 64.49% of Java online submissions.
    Memory Usage:48.7 MB, less than 85.05% of Java online submissions.*/
/*    private boolean isEnd;
    private Trie[] tries;

    *//** Initialize your data structure here. *//*
    public Trie() {
        tries = new Trie[26];
        isEnd = false;
    }

    *//** Inserts a word into the trie. *//*
    public void insert(String word) {
        if (word == null) return;
        if (word.length() == 0) {
            isEnd = true;
            return;
        }
        int idx = word.charAt(0) - 'a';
        if (tries[idx] == null) tries[idx] = new Trie();
        tries[idx].insert(word.substring(1, word.length()));
    }

    *//** Returns if the word is in the trie. *//*
    public boolean search(String word) {
        if (word == null) return false;
        if (word.length() == 0) return isEnd;
        int idx = word.charAt(0) - 'a';
        if (tries[idx] != null) return tries[idx].search(word.substring(1,word.length()));
        return false;
    }

    *//** Returns if there is any word in the trie that starts with the given prefix. *//*
    public boolean startsWith(String prefix) {
        if (prefix == null) return false;
        if (prefix.length() == 0) return true;
        int idx = prefix.charAt(0) - 'a';
        if (tries[idx] != null) return tries[idx].startsWith(prefix.substring(1, prefix.length()));
        return false;
    }*/
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)
