package com.example.leet.august.week4;

/**
 * Stream of Characters
 * Implement the StreamChecker class as follows:
 *
 * StreamChecker(words): Constructor, init the data structure with the given words.
 * query(letter): returns true if and only if for some k >= 1, the last k characters queried (in order from oldest to
 * newest, including this letter just queried) spell one of the words in the given list.
 *
 *
 * Example:
 *
 * StreamChecker streamChecker = new StreamChecker(["cd","f","kl"]); // init the dictionary.
 * streamChecker.query('a');          // return false
 * streamChecker.query('b');          // return false
 * streamChecker.query('c');          // return false
 * streamChecker.query('d');          // return true, because 'cd' is in the wordlist
 * streamChecker.query('e');          // return false
 * streamChecker.query('f');          // return true, because 'f' is in the wordlist
 * streamChecker.query('g');          // return false
 * streamChecker.query('h');          // return false
 * streamChecker.query('i');          // return false
 * streamChecker.query('j');          // return false
 * streamChecker.query('k');          // return false
 * streamChecker.query('l');          // return true, because 'kl' is in the wordlist
 *
 *
 * Note:
 *
 * 1 <= words.length <= 2000
 * 1 <= words[i].length <= 2000
 * Words will only consist of lowercase English letters.
 * Queries will only consist of lowercase English letters.
 * The number of queries is at most 40000.
 *    Hide Hint #1
 * Put the words into a trie, and manage a set of pointers within that trie.
 */
public class Day23 {
    //Store the words in the trie with reverse order, and check the query string from the end
    static class StreamChecker {

        class TrieNode {
            boolean isWord;
            TrieNode[] next = new TrieNode[26];
        }

        TrieNode root = new TrieNode();
        StringBuilder sb = new StringBuilder();

        public StreamChecker(String[] words) {
            createTrie(words);
        }

        public boolean query(char letter) {
            sb.append(letter);
            TrieNode node = root;
            for (int i = sb.length() - 1; i >= 0 && node != null; i--) {
                char c = sb.charAt(i);
                node = node.next[c - 'a'];
                if (node != null && node.isWord) {
                    return true;
                }
            }
            return false;
        }

        private void createTrie(String[] words) {
            for (String s : words) {
                TrieNode node = root;
                int len = s.length();
                for (int i = len - 1; i >= 0; i--) {
                    char c = s.charAt(i);
                    if (node.next[c - 'a'] == null) {
                        node.next[c - 'a'] = new TrieNode();
                    }
                    node = node.next[c - 'a'];
                }
                node.isWord = true;
            }
        }
    }
    /**
     * Your StreamChecker object will be instantiated and called as such:
     * StreamChecker obj = new StreamChecker(words);
     * boolean param_1 = obj.query(letter);
     */
    public static void main(String[] args) {
        StreamChecker streamChecker = new StreamChecker(new String[]{"cd", "f", "kl"}); // init the dictionary.
        System.out.println(streamChecker.query('a'));          // return false
        System.out.println(streamChecker.query('b'));          // return false
        System.out.println(streamChecker.query('c'));          // return false
        System.out.println(streamChecker.query('d'));          // return true, because 'cd' is in the wordlist
        System.out.println(streamChecker.query('e'));          // return false
        System.out.println(streamChecker.query('f'));          // return true, because 'f' is in the wordlist
        System.out.println(streamChecker.query('g'));          // return false
        System.out.println(streamChecker.query('h'));          // return false
        System.out.println(streamChecker.query('i'));          // return false
        System.out.println(streamChecker.query('j'));          // return false
        System.out.println(streamChecker.query('k'));          // return false
        System.out.println(streamChecker.query('l'));          // return true, because 'kl' is in the wordlist
    }
}
