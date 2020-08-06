package com.example.leet.august.week1;

/**
 * Add and Search Word - Data structure design
 * Design a data structure that supports the following two operations:
 * <p>
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means
 * it can represent any one letter.
 * <p>
 * Example:
 * <p>
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 * <p>
 * Hide Hint #1
 * You should be familiar with how a Trie works. If not, please work on this problem: Implement Trie (Prefix Tree)
 * (https://leetcode.com/problems/implement-trie-prefix-tree/)
 * first.
 */
public class Day5 {

    class WordDictionary {
        public class TrieNode {
            public TrieNode[] children = new TrieNode[26];
            public String item = "";
        }

        private TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            this.root = new TrieNode();
            ;
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.item = word;
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any
         * one letter.
         */
        public boolean search(String word) {
            return match(word.toCharArray(), 0, root);
        }

        private boolean match(char[] chs, int k, TrieNode node) {
            if (k == chs.length) return !node.item.equals("");
            if (chs[k] != '.') {
                return node.children[chs[k] - 'a'] != null && match(chs, k + 1, node.children[chs[k] - 'a']);
            } else {
                for (int i = 0; i < node.children.length; i++) {
                    if (node.children[i] != null) {
                        if (match(chs, k + 1, node.children[i])) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }


    public static void main(String[] args) {
        /**
         * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
         * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
         */

        WordDictionary obj = new Day5().new WordDictionary();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");
        System.out.println(obj.search("pad"));
        System.out.println(obj.search("bad"));
        System.out.println(obj.search(".ad"));
        System.out.println(obj.search("b.."));
    }

    class WordDictionary1 {

        TrieNode root ;
        /** Initialize your data structure here. */
        public WordDictionary1() {
            root = new TrieNode(null);
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            TrieNode current = root;
            for(int i=0; i<word.length(); i++) {
                Character ch = word.charAt(i);
                TrieNode child = current.children[ch-'a'];
                if(child == null)
                    child = new TrieNode(ch);
                current.children[ch-'a'] = child;
                current = child;
            }
            current.isEnd = true;
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return searchUtil(root, word, 0);
        }

        private boolean searchUtil(TrieNode current, String word, int index) {
            if(index == word.length()) {
                return current.isEnd ? true : false;
            }
            Character ch = word.charAt(index);
            if(ch == '.') {
                //    System.out.println("At index found . " + index);
                for(TrieNode child : current.children) {
                    if(child != null && searchUtil(child, word, index+1)) {
                        //    System.out.println("Child is " + child.ch);
                        return true;
                    }
                }
                return false;
            }else {
                TrieNode child = current.children[ch-'a'];
                if(child == null)
                    return false;
                else
                    return searchUtil(child, word, index+1);
            }

        }
    }

    class TrieNode {
        Character ch;
        TrieNode[] children;
        boolean isEnd;
        TrieNode(Character ch) {
            this.ch = ch;
            this.children = new TrieNode[26];
            this.isEnd = false;
        }
    }

}
