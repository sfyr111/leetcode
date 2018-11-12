package com.leetcode.HashTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yangran
 * 2018/10/13
 */

public class BinaryTreeInorderTraversal94 {

	  public class TreeNode {
			int val;
			TreeNode left;
			TreeNode right;
			TreeNode(int x) { val = x; }
	  }

	public List<Integer> inorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		ArrayList<Integer> ret = new ArrayList<>();

		TreeNode cur = root;
		while (!stack.isEmpty() || cur != null) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}

			cur = stack.pop();
			ret.add(cur.val);
			cur = cur.right;
		}

		return ret;
	}
}
