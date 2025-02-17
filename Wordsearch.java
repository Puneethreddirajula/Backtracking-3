//Time Complexity: O(m*n*3^k) where k is the length of word, in worst case, we check all 3 directions for a character in word
//Space Complexity: O(k), k is the length of word

public class WordSearch {

    int[][] dirs;
    int m, n;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        int start = 0;
        dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(start)) {
                    if (recurse(board, 0, word, i, j)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean recurse(char[][] board, int index, String word, int row, int col) {
        if (index == word.length()) {
            return true; // Found the full word
        }

        if (row < 0 || row >= m || col < 0 || col >= n || board[row][col] == '#' || board[row][col] != word.charAt(index)) {
            return false; // Out of bounds or already visited or mismatch
        }

        char temp = board[row][col];
        board[row][col] = '#'; // Mark as visited

        for (int[] dir : dirs) {
            int nr = row + dir[0];
            int nc = col + dir[1];

            if (recurse(board, index + 1, word, nr, nc)) {
                return true;
            }
        }

        board[row][col] = temp; // Restore for backtracking
        return false;
    }