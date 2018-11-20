package com.leetcode.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangran
 * 2018/11/20
 */

public class PascalsTriangle118 {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> triangle = new ArrayList<>();

		if (numRows == 0) return triangle;

		triangle.add(new ArrayList<>());
		triangle.get(0).add(1);

		for (int rowNum = 1; rowNum < numRows; rowNum++) {
			List<Integer> row = new ArrayList<>();
			List<Integer> prevRow = triangle.get(rowNum - 1);

			// 行首先加1
			row.add(1);

			// 行中根据上一行计算 loop [ 0 ( 1, rowNum - 1 ) ] 每一行比上一行多一个元素
			for (int j = 1; j < rowNum; j++)
				row.add(prevRow.get(j - 1) + prevRow.get(j));

			// 行尾后加1
			row.add(1);

			triangle.add(row);
		}
		return triangle;
	}
}
