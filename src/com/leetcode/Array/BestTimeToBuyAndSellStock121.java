package com.leetcode.Array;

/**
 * Created by yangran
 * 2018/11/20
 */

public class BestTimeToBuyAndSellStock121 {

	public int maxProfit(int[] prices) {
		int maxCurProfit = 0; // 当前最大收益 从第一天开始买入一直计算到最后一天每天的当天
		int maxRetProfit = 0; // 找到的要返回的最大收益
		for (int i = 1; i < prices.length; i++) {
			maxCurProfit = Math.max(0, maxCurProfit += prices[i] - prices[i - 1]);
			maxRetProfit = Math.max(maxCurProfit, maxRetProfit);
		}
		return maxRetProfit;
	}

	public static void main(String[] args) {
		int[] prices = {7, 1, 5, 3, 6, 4};
		int ret = new BestTimeToBuyAndSellStock121().maxProfit(prices);
		System.out.println(ret);
	}
}
