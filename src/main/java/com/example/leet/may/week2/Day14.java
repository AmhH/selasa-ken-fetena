package com.example.leet.may.week2;

/**
 * Implement Trie (Prefix Tree)
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Example:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * Note:
 *
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 */
public class Day14 {

}
class Trie {

    class TrieNode {
        private TrieNode[] children = new TrieNode[26];
        private boolean isEnd = false;

        public void setEnd() {
            isEnd =true;
        }
        public boolean isEnd() {
            return isEnd;
        }
    }

    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode p =root;
        for(char c: word.toCharArray()) {
            if(p.children[c-'a'] == null) {
                p.children[c-'a'] = new TrieNode();
            }
            p= p.children[c-'a'];
        }
        p.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode p =root;
        for(char c: word.toCharArray()) {
            if(p.children[c-'a'] == null) {
                return false;
            }
            p= p.children[c-'a'];
        }
        return p.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode p =root;
        for(char c: prefix.toCharArray()) {
            if(p.children[c-'a'] == null) {
                return false;
            }
            p= p.children[c-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */