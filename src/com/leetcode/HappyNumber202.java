package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yangran
 * 2018/10/13
 */

public class HappyNumber202 {

	/**
	 * 1. 从 n 的个位 -> 十位 -> 百位... 的平方开始累加
	 * 2. 累加结果为 1 则继续循环此累加值
	 * 3. 当 Set 结构出现重复的 n 为死循环
	 */
	public boolean isHappy(int n) {
		Set<Integer> inLoop = new HashSet<>();
		int squareSum; // 平方和
		int remain; // 取模数

		while (inLoop.add(n)) { // 内循环, 如果重复出现则进入死循环 false
			squareSum = 0;
			while (n > 0) {
				remain = n % 10; // 取模
				squareSum += remain * remain; // 累加取模值
				n = n / 10; // 个位数时为 0
			}
			if (squareSum == 1)
				return true;
			else
				n = squareSum; // 继续循环累加结果
		}
		return false;
	}

	public static void main(String[] args) {
		boolean b = new HappyNumber202().isHappy(33);
		System.out.println(b);
	}
}
