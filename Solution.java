

//public class Solution {
//
//	public static boolean issafe(int sudoku[][],int row,int col,int digit){
//         for(int i =0;i<=8;i++){
//			 if(sudoku[i][col] == digit){
//				 return false;
//			 }
//		 }	 
//			  for(int j =0;j<=8;j++){
//				if(sudoku[row][j] == digit){
//				  return false;
//				}
//			 }
//			 int sr = (row/3)*3;
//			 int sc = (col/3)*3;
//			 for(int i = sr;i<=3;i++){
//				 for(int j = sc;i<=3;j++){
//					 if(sudoku[i][j] == digit){
//						 return false;
//					 }
//				 }
//			 }
//			 return true;
//	}
//	public static boolean sudokusolver(int sudoku[][],int row,int col){
//		if(row == 9){
//			return true;
//		}
//		int nextrow = row; 
//		int nextcol = col+1;
//		if(nextcol == 9){
//			nextrow = row+1;
//			col = 0;
//		}
//		if(sudoku[row][col] != 0){
//			sudoku(sudoku,nextrow,nextcol);
//		}
//		for(int digit = 1;digit<=9;digit++){
//			if(issafe(sudoku,row,col,digit)){
//				sudoku[row][col] = digit;
//				if(sudokusolver(sudoku,nextrow,nextcol)){
//					return true;
//				}
//				sodoku[row][col] = 0;
//			}
//		}
//		return false;
//	} 
//    
//	public static void solveSudoku(int[][] sudoku) {
//        sudokosolver(sudoku,0,0); 
//	}
//	public static void main(String args[]){
//
//	}
//	
//}
//
//
//
//
//
//
//


import java.util.* ;
import java.io.*; 
public class Solution {
	public static boolean issafe(int sudoku[][],int row,int col,int digit){
         for(int i =0;i<=8;i++){
			 if(sudoku[i][col] == digit){
				 return false;
			 }
		 }	 
			  for(int j =0;j<=8;j++){
				if(sudoku[row][j] == digit){
				  return false;
				}
			 }
			 int sr = (row/3)*3;
			 int sc = (col/3)*3;
			 for(int i = sr;i<=3;i++){
				 for(int j = sc;i<=3;j++){
					 if(sudoku[i][j] == digit){
						 return false;
					 }
				 }
			 }
			 return true;
	}
	public static boolean sudokusolver(int sudoku[][],int row,int col){
		if(row == 9 && col == 0){
			return true;
		}
		int nextrow = row; 
		int nextcol = col+1;
		if(nextcol == 9){
			nextrow = row+1;
			col = 0;
		}
		if(sudoku[row][col] != 0){
			sudokusolver(sudoku,nextrow,nextcol);
		}
		for(int digit = 1;digit<=9;digit++){
			if(issafe(sudoku,row,col,digit)){
				sudoku[row][col] = digit;
				if(sudokusolver(sudoku,nextrow,nextcol)){
					return true;
				}
				sudoku[row][col] = 0;
			}
		}
		return false;
	} 
    
	public static void solveSudoku(int[][] sudoku) {
        sudokusolver(sudoku,0,0); 
	}
}