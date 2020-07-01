package com.example.leet.june.week5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Word Search II
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those
 * horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 *
 *
 *
 * Example:
 *
 * Input:
 * board = [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 * words = ["oath","pea","eat","rain"]
 *
 * Output: ["eat","oath"]
 *
 *
 * Note:
 *
 * All inputs are consist of lowercase letters a-z.
 * The values of words are distinct.
 *    Hide Hint #1
 * You would need to optimize your backtracking to pass the larger test. Could you stop backtracking earlier?
 *    Hide Hint #2
 * If the current candidate does not exist in all words' prefix, you could stop backtracking immediately. What kind
 * of data structure could answer such query efficiently? Does a hash table work? Why or why not? How about a Trie?
 * If you would like to learn how to implement a basic trie, please work on this problem: Implement Trie (Prefix
 * Tree) first.
 */
public class Java30 {
    public static class Trie{
        public Trie[] children;
        public boolean endOfWord;

        public Trie(){
            endOfWord = false;
            children = new Trie[26];
        }

        public void insert(String word){
            Trie curr = this;
            for (char c : word.toCharArray()){
                if(curr.children[c - 'a'] == null)
                    curr.children[c - 'a'] = new Trie();
                curr = curr.children[c - 'a'];
            }
            curr.endOfWord = true;
        }
    }


    public static List<String> findWords(char[][] board, String[] words) {

        if(words.length == 0)
            return new ArrayList<>();
        Trie trie = new Trie();
        for(String s : words)
            trie.insert(s);
        Set<String> result = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, result, trie, "");
            }
        }

        return new ArrayList<>(result);
    }

    private static void dfs(char[][] board, int i, int j, Set<String> result, Trie trie, String s){
        char c = board[i][j];
        if(c == '$')
            return;
        board[i][j] = '$';
        Trie child = trie.children[c - 'a'];
        if(child != null){
            String str = s + c;
            if(child.endOfWord)
                result.add(str);
            if(i < board.length - 1)
                dfs(board, i+1, j, result, child, str);
            if(j < board.length - 1)
                dfs(board, i, j+1, result, child, str);
            if(i > 0)
                dfs(board, i-1, j, result, child, str);
            if(j > 0)
                dfs(board, i, j-1, result, child, str);
        }
        board[i][j] = c;
    }

    public static void main(String[] args) {
        System.out.println(findWords(new char[][]{
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
            }, new String[]{"oath","pea","eat","rain"}));
    }

    class Solution {

        class TrieNode {
            private TrieNode[] next = new TrieNode[26];
            private String word;
        }

        public List<String> findWords(char[][] board, String[] words) {
            TrieNode root = buildTrie(words);
            List<String> result = new ArrayList<>();

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    dfs(board, root, result, i, j);
                }
            }
            return result;
        }

        private void dfs(char[][] board, TrieNode node, List<String> result, int i, int j) {
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
                return;
            }

            char c = board[i][j];
            int diff = c - 'a';


            if (c == '*' || node.next[diff] == null) {
                return;
            }

            node = node.next[diff];
            if (node.word != null) {
                result.add(node.word);
                node.word = null;
            }

            board[i][j] = '*';
            dfs(board, node, result, i+1, j);
            dfs(board, node, result, i-1, j);
            dfs(board, node, result, i, j-1);
            dfs(board, node, result, i, j+1);
            board[i][j] = c;
        }


        private TrieNode buildTrie(String[] words) {
            TrieNode root = new TrieNode();

            for (String word : words) {
                TrieNode node = root;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    int diff = c - 'a';
                    if (node.next[diff] == null) {
                        node.next[diff] = new TrieNode();
                    }
                    node = node.next[diff];
                }
                node.word = word;
            }
            return root;
        }
    }
}
