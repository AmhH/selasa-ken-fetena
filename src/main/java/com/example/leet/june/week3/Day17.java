package com.example.leet.june.week3;

import java.util.Arrays;

/**
 * Surrounded Regions
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * Example:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * Explanation:
 *
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped
 * to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
 * Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */
public class Day17 {

    public static void solve(char[][] board) {

        if (board.length < 3 || board[0].length < 3) {
            return;
        }

        int r = board.length;
        int c = board[0].length;

        boolean[][] visited = new boolean[r][c];

        //first and last row
        for (int j=0; j<c; j++) {
            markBorderConnectedZeros(board, 0, j, r, c, visited);
            markBorderConnectedZeros(board, r-1, j, r, c, visited);
        }

        //first and last column
        for (int i=0; i<r; i++) {
            markBorderConnectedZeros(board, i, 0, r, c, visited);
            markBorderConnectedZeros(board, i, c-1, r, c, visited);
        }

        for (int i=1; i<r; i++) {
            for (int j=1; j<c; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private static void markBorderConnectedZeros(char[][] board, int i, int j,
                                          int r, int c, boolean[][] visited) {
        if (i<0 || i>= r) {
            return;
        }

        if (j<0 || j>= c) {
            return;
        }

        if (board[i][j] == 'X' || visited[i][j]) {
            return;
        }

        visited[i][j] = true;

        markBorderConnectedZeros(board, i+1, j, r, c, visited);
        markBorderConnectedZeros(board, i-1, j, r, c, visited);
        markBorderConnectedZeros(board, i, j+1, r, c, visited);
        markBorderConnectedZeros(board, i, j-1, r, c, visited);

    }


    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X'},{'X', 'O', 'O', 'X'},{'X', 'X', 'O', 'X'},{'X', 'O', 'X', 'X'}};
        solve(board);
        System.out.println(Arrays.deepToString(board));
    }

    class Solution {
        public void solve(char[][] board) {
            if(board == null || board.length == 0 || board[0].length == 0)
                return;

            int m = board.length, n = board[0].length;

            for(int j = 0; j<n; j++){
                if(board[0][j] == 'O')
                    bfs(board, 0, j);
                if(board[m-1][j] == 'O')
                    bfs(board, m-1, j);
            }

            for(int i = 0; i<m; i++){
                if(board[i][0] == 'O')
                    bfs(board, i, 0);
                if(board[i][n-1] == 'O')
                    bfs(board, i, n-1);
            }

            convert(board, 'O', 'X');
            convert(board, 'I', 'O');

        }

        public void bfs(char[][] board, int i, int j){
            if(i < 0 || i>= board.length || j < 0 || j>=board[0].length || board[i][j] != 'O')
                return;
            board[i][j] = 'I';
            bfs(board, i-1, j);
            bfs(board, i+1, j);
            bfs(board, i, j-1);
            bfs(board, i, j+1);
        }

        public void convert(char[][] board, char a, char b){
            for(int i = 0; i<board.length; i++){
                for(int j = 0; j<board[0].length; j++){
                    if(board[i][j] == a)
                        board[i][j] = b;
                }
            }
        }
    }
}
