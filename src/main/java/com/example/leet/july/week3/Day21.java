package com.example.leet.july.week3;

/**
 * Word Search
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those
 * horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * Example:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * board and word consists only of lowercase and uppercase English letters.
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 */
public class Day21 {

    public static boolean exist(char[][] board, String word) {
        if (board == null || (board.length == 0 && !word.isEmpty()))
            return false;

        if (board.length == 0 && word.isEmpty())
            return true;


        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] == word.charAt(0) && exist(board, visited, word, r, c, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean exist(char[][] board, boolean[][] visited, String word, int r, int c, int index) {
        if (index == word.length())
            return true;

        if (r >= board.length || r < 0 || c >= board[r].length || c < 0 || board[r][c] != word.charAt(index) || visited[r][c]) {
            return false;
        }

        visited[r][c] = true;
        if (exist(board, visited, word, r - 1, c, index + 1) ||
                exist(board, visited, word, r + 1, c, index + 1) ||
                exist(board, visited, word, r, c - 1, index + 1) ||
                exist(board, visited, word, r, c + 1, index + 1)) {
            return true;
        }

        visited[r][c] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(board, "ABCCED"));
        System.out.println(exist(board, "SEE"));
        System.out.println(exist(board, "ABCB"));

        char[][] board1 = {{'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'}};
        System.out.println(exist(board1, "AAB"));
    }

}
