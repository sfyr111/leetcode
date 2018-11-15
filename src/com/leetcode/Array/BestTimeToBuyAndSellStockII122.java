package com.leetcode.Array;

/**
 * Created by yangran
 * 2018/11/15
 */

public class BestTimeToBuyAndSellStockII122 {

	public int maxProfit(int[] prices) {
		int total = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			if (prices[i + 1] > prices[i])
				total += prices[i + 1] - prices[i];
		}
		return total;
	}

	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 4, 5, 4, 8};
		int t = new BestTimeToBuyAndSellStockII122().maxProfit(prices);
		System.out.println(t);
	}
}
