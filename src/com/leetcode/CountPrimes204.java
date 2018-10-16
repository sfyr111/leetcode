package com.leetcode;

/**
 * Created by yangran
 * 2018/10/13
 */

public class CountPrimes204 {
	public int countPrimes(int n) {
		boolean[] notPrimes = new boolean[n];
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (!notPrimes[i]) {
				count++; // 是质数
				// 标记质数的倍数为非质数
				for (int j = 2; i * j < n ; j++) {
					notPrimes[i * j] = true;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int b = new CountPrimes204().countPrimes(17);
		System.out.println(b);
	}
}
