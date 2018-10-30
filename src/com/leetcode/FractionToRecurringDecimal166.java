package com.leetcode;

import java.util.HashMap;

/**
 * Created by yangran
 * 2018/10/30
 */

public class FractionToRecurringDecimal166 {

	public String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0) return "0";

		StringBuilder res = new StringBuilder();

		// false 0, true 1
		// false ^ true -> 1, true ^ true -> 0, false ^ false -> 0
		res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
		long num = Math.abs((long) numerator);
		long den = Math.abs((long) denominator);

		// 整数部分
		res.append(num / den);
		num %= den;
		if (num == 0) // 整除
			return res.toString();

		// 小数部分
		res.append(".");
		HashMap<Long, Integer> map = new HashMap<>();
		map.put(num, res.length()); // put 取模的结果
		while (num != 0) { // 取模值不停 *10 / den， 如果是有限循环肯定会等于0
			num *= 10;
			res.append(num / den); // append 一个整数
			num %= den; // 再次取模
			if (map.containsKey(num)) {
				int index = map.get(num);
				res.insert(index, "(");
				res.append(")");
				break;
			} else {
				map.put(num, res.length());
			}
		}
		return res.toString();
	}
}
