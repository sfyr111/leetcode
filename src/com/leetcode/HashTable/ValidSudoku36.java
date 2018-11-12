package com.leetcode.HashTable;

import java.util.HashSet;

/**
 * Created by yangran
 * 2018/10/22
 */

public class ValidSudoku36 {

	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			HashSet<Character> rows = new HashSet<>();
			HashSet<Character> columns = new HashSet<>();
			HashSet<Character> cube = new HashSet<>();
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.' && !rows.add(board[i][j])) {
					return false;
				}
				if (board[j][i] != '.' && !columns.add(board[j][i])) {
					return false;
				}
				int x = 3 * (i / 3) + (j / 3);
				int y = 3 * (i % 3) + (j % 3);
				System.out.print("i=");
				System.out.print(i);
				System.out.print(',');
				System.out.print("j=");
				System.out.print(j);
				System.out.print(" > ");
				System.out.print("x=");
				System.out.print(x);
				System.out.print(',');
				System.out.print("y=");
				System.out.print(y);
				System.out.print("  int x = 3 * (i / 3) + (j / 3),");
				System.out.println("int y = 3 * (i % 3) + (j % 3)");
				if (board[x][y] != '.' && !cube.add(board[x][y])) {
					return false;
				}
			}
			System.out.println("=============");
		}
		return true;
	}

	public static void main(String[] args) {
		char[][] arr = new char[][]{
						{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
						,
						{'6', '.', '.', '1', '9', '5', '.', '.', '.'}
						,
						{'.', '9', '8', '.', '.', '.', '.', '6', '.'}
						,
						{'8', '.', '.', '.', '6', '.', '.', '.', '3'}
						,
						{'4', '.', '.', '8', '.', '3', '.', '.', '1'}
						,
						{'7', '.', '.', '.', '2', '.', '.', '.', '6'}
						,
						{'.', '6', '.', '.', '.', '.', '2', '8', '.'}
						,
						{'.', '.', '.', '4', '1', '9', '.', '.', '5'}
						,
						{'.', '.', '.', '.', '8', '.', '.', '7', '9'}

		};
//		boolean b = new ValidSudoku36().isValidSudoku(arr);
//		System.out.println(b);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int x = 3 * (i / 3) + (j / 3);
				int y = 3 * (i % 3) + (j % 3);
				System.out.print("i=");
				System.out.print(i);
				System.out.print(',');
				System.out.print("j=");
				System.out.print(j);
				System.out.print(" > ");
				System.out.print("x=");
				System.out.print(x);
				System.out.print(',');
				System.out.print("y=");
				System.out.print(y);
				System.out.print("  int x = 3 * (i / 3) + (j / 3),");
				System.out.println("int y = 3 * (i % 3) + (j % 3)");
			}
			System.out.println("============");
		}
	}
}
