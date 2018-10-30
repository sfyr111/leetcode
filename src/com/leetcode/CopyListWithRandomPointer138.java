package com.leetcode;

import jdk.management.resource.internal.ResourceNatives;

import java.util.HashMap;

/**
 * Created by yangran
 * 2018/10/23
 */

public class CopyListWithRandomPointer138 {
	class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
	}

	public class Solution1 {

		// HashMap，它将旧节点作为键，将新节点作为其值。
		HashMap<RandomListNode, RandomListNode> visitedHash = new HashMap<>();

		public RandomListNode copyRandomList(RandomListNode head) {
			if (head == null) return null;

			// 如果我们已经处理了当前节点，那么我们只返回它的克隆版本。
			if (this.visitedHash.containsKey(head))
				return this.visitedHash.get(head);

			// 创建一个标签 label 与旧节点相同的新节点。（即复制节点）
			RandomListNode node = new RandomListNode(head.label);

			// 将此值保存在哈希映射中。这是必要的，因为可能存在
			// 由于随机指针的随机性而在遍历期间循环，这将有助于我们避免它们。
			this.visitedHash.put(head, node);

			// 递归复制从下一个指针开始一次的剩余链表，然后从随机指针复制。
			// 因此我们有两个独立的递归调用。
			// 最后，我们更新创建的新节点的下一个和随机指针。
			node.next = this.copyRandomList(head.next);
			node.random = this.copyRandomList(head.random);

			return node;
		}
	}

	public class Solution2 {
		// 访问字典以将旧节点引用保存为“key”，将新节点引用保存为“value”
		HashMap<RandomListNode, RandomListNode> visited = new HashMap<>();

		public RandomListNode getCloneNode(RandomListNode node) {
			// 如果该节点存在
			if (node != null) {
				// 检查节点是否在访问的字典中
				if (this.visited.containsKey(node)) {
					// 如果它在被访问的字典中，则返回字典中的新节点引用
					return this.visited.get(node);
				} else {
					// 否则创建一个新节点，添加到字典并返回它
					this.visited.put(node, new RandomListNode(node.label));
					return this.visited.get(node);
				}
			}
			return null;
		}

		public RandomListNode copyRandomList(RandomListNode head) {
			if (head == null) return null;

			RandomListNode oldNode = head;

			// Creating the new head node.
			RandomListNode newNode = new RandomListNode(oldNode.label);
			this.visited.put(oldNode, newNode);

			// 迭代链表，直到克隆所有节点。
			while (oldNode != null) {
				// 获取随机和下一个指针引用的节点的克隆。
				newNode.random = this.getCloneNode(oldNode.random);
				newNode.next = this.getCloneNode(oldNode.next);

				// 在链接列表中向前移动一步。
				oldNode = oldNode.next;
				newNode = newNode.next;
			}
			return this.visited.get(head);
		}
	}

	public class Solution3 {
		public RandomListNode copyRandomList(RandomListNode head) {
			if (head == null) return null;

			// 创建原始和复制节点的新编织列表 Creating a new weaved list of original and copied nodes
			RandomListNode ptr = head;
			while (ptr != null) {
				RandomListNode newNode = new RandomListNode(ptr.label);

				// newNode 接到 prt 后面，用原 ptr.next 继续
				// Inserting the cloned node just next to the original node.
				// If A->B->C is the original linked list,
				// Linked list after weaving cloned nodes would be A->A'->B->B'->C->C'
				newNode.next = ptr.next;
				ptr.next = newNode;
				ptr = newNode.next;
			}

			ptr = head; // 指针复原

			// Now link the random pointers of the new nodes created.
			// Iterate the newly created list and use the original nodes' random pointers,
			// to assign references to random pointers for cloned nodes.
			while (ptr != null) {
				ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
				ptr = ptr.next.next;
			}

			// Unweave the linked list to get back the original linked list and the cloned list.
			// i.e. A->A'->B->B'->C->C' would be broken to A->B->C and A'->B'->C'
			RandomListNode ptr_old_list = head; // A->B->C
			RandomListNode ptr_new_list = head.next; // A'->B'->C'
			RandomListNode head_old = head.next; // 用于拷贝出来的指针
			while (ptr_old_list != null) {
				ptr_old_list.next = ptr_old_list.next.next;
				ptr_new_list.next = (ptr_new_list.next != null) ? ptr_new_list.next.next : null;
				ptr_old_list = ptr_old_list.next;
				ptr_new_list = ptr_new_list.next;
			}
			return head_old;
		}
	}

}
