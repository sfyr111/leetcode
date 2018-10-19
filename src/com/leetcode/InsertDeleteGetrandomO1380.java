package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by yangran
 * 2018/10/19
 */

public class InsertDeleteGetrandomO1380 {
	ArrayList<Integer> nums;
	HashMap<Integer, Integer> indexMap;
	Random rand = new Random();

	public InsertDeleteGetrandomO1380() {
		nums = new ArrayList<>();
		indexMap = new HashMap<>();
	}

	public boolean insert(int val) {
		if (indexMap.containsKey(val)) return false;
		indexMap.put(val, nums.size());
		nums.add(val);
		return true;
	}

	public boolean remove(int val) {
		if (!indexMap.containsKey(val)) return false;
		int index = indexMap.get(val);
		if (index < nums.size() - 1) { // 不是最后一个, 用最后一个来替换
			int last = nums.get(nums.size() - 1);
			nums.set(index, last);
			indexMap.put(last, index);
		}
		indexMap.remove(val);
		nums.remove(nums.size() - 1);
		return true;
	}

	public int getRandom() {
		return nums.get(rand.nextInt(nums.size()));
	}
}
