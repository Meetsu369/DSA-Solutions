// Problem: Sudoku Solver
// Platform: leetcode
// Rating/Difficulty: Hard
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/sudoku-solver/
// Solved on: 2026-10-02T10:27:17.366Z

class Solution {

    boolean[][] rows = new boolean[9][10];
    boolean[][] cols = new boolean[9][10];
    boolean[][] boxes = new boolean[9][10];

    public void solveSudoku(char[][] board) {

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                if (board[row][col] != '.') {

                    int digit = board[row][col] - '0';
                    int box = (row / 3) * 3 + (col / 3);

                    rows[row][digit] = true;
                    cols[col][digit] = true;
                    boxes[box][digit] = true;
                }
            }
        }

        solve(board);
    }

    private boolean solve(char[][] board) {

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                if (board[row][col] == '.') {

                    int box = (row / 3) * 3 + (col / 3);

                    for (int digit = 1; digit <= 9; digit++) {

                        if (rows[row][digit] ||
                            cols[col][digit] ||
                            boxes[box][digit]) {
                            continue;
                        }

                        board[row][col] = (char) ('0' + digit);

                        rows[row][digit] = true;
                        cols[col][digit] = true;
                        boxes[box][digit] = true;

                        if (solve(board)) {
                            return true;
                        }

                        board[row][col] = '.';

                        rows[row][digit] = false;
                        cols[col][digit] = false;
                        boxes[box][digit] = false;
                    }

                    return false;
                }
            }
        }

        return true;
    }
}