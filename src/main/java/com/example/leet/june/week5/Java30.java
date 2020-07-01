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

}
