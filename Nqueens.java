//Time Complexity: O(N!) - factorial
//Space Complexity: O(N) for recursive stack
class Solution {
    List<List<String>> result;
    boolean[][] grid;
    public List<List<String>> solveNQueens(int n) {
        if(n == 0){
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        grid = new boolean[n][n];
        backtrack(0,n);
        return result;
    }
    public void backtrack(int row, int n){
        //base
        if(row == n){
            List<String> answer =  new ArrayList<>();
            for(int i =0; i<n; i++){
                StringBuilder sb = new StringBuilder();
                for(int j =0; j<n; j++){
                    if(grid[i][j] == true){
                        sb.append('Q');
                    }
                    else{
                        sb.append('.');
                    }
                }
                answer.add(sb.toString());
            }
            result.add(answer);
            return;
        }


        //logic
        for(int i=0; i<n;i++){
            if(isSafe(row,i,n)){
                //action
                grid[row][i] = true;
                //recurse
                backtrack(row+1,n);
                //backtrack
                grid[row][i] = false;
            }
        }
    }
    private boolean isSafe(int row, int col, int n){
        //check above if we already have queen
        for(int i = row;i>=0;i--){
            if(grid[i][col] == true){
                return false;
            }
        }
        int i = row;
        int j = col;

        //check upper left diagonal
        while(i>=0 && j>=0){
            if(grid[i][j] == true){
                return false;
            }
            i--;
            j--;
        }

        i = row;
        j = col;
        //check upper right diagonal
        while(i>=0 && j < n){
            if(grid[i][j] == true){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}