public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board.length == 0){
        	return false;
        }
        //hashtable
        int[] hashtable = new int[9];
        
        //先对每一行查找，看是否有不符合定义的情况
        for(int i = 0; i < board.length; ++i){
        	for(int k = 0; k < 9; ++k){
            	hashtable[k] = 0;
            }
        	for(int j = 0; j < board.length; ++j){
        		if(board[i][j] != '.'){
        			int curValue = board[i][j] - '1';
        			if(hashtable[curValue] > 0){
        				return false;
        			}else{
        				hashtable[curValue]++;
        			}
        		}else{
        			continue;
        		}
        	}
        }
        //再对每一列查找，看是否有不符合定义的情况
        for(int j = 0; j < board.length; ++j){
        	for(int k = 0; k < 9; ++k){
            	hashtable[k] = 0;
            }
        	for(int i = 0; i < board.length; ++i){
        		if(board[i][j] != '.'){
        			int curValue = board[i][j] - '1';
        			if(hashtable[curValue] > 0){
        				return false;
        			}else{
        				hashtable[curValue]++;
        			}
        		}else{
        			continue;
        		}
        	}
        }
        //最后对每一个3*3矩阵查找，看是否又不符合定义的情况
        for(int i = 0; i < board.length; i = i + 3){
        	for(int j = 0; j < board.length; j = j + 3){
        		for(int k = 0; k < 9; ++k){
                	hashtable[k] = 0;
                }
        		for(int row = i; row < i + 3; row++){
        			for(int col = j; col < j + 3; col++){
        				if(board[row][col] != '.'){
                			int curValue = board[row][col] - '1';
                			if(hashtable[curValue] > 0){
                				return false;
                			}else{
                				hashtable[curValue]++;
                			}
                		}else{
                			continue;
                		}
        			}
        		}
        	}
        }
        return true;
    }
}
