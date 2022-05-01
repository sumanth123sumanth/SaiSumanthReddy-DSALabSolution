package com.greatlearning.treesum;

import java.util.HashSet;

public class FindSumPair {

	static class Node {
		int data;
		Node left, right;
	};

	static Node NewNode(int data) {
		Node temp = new Node();
		temp.data = data;
		temp.left = null;
		temp.right = null;
		return temp;
	}

	public Node insert(Node root, int val) {
		if (root == null) {
			return NewNode(val);
		}

		if (val < root.data) {
			root.left = insert(root.left, val);
		} else {
			root.right = insert(root.right, val);
		}
		return root;
	}

	public static boolean findPairUtil(Node root, int sum, HashSet<Integer> set) {

		if (root == null) {
			return false;
		}

		if (findPairUtil(root.left, sum, set)) {
			return true;
		}

		if (set.contains(sum - root.data)) {
			System.out.println("Pair is (" + (sum - root.data) + ", " + root.data + ")");
			return true;
		} else {
			set.add(root.data);
		}

		return findPairUtil(root.right, sum, set);
	}

	public static void findPairWithGivenSum(Node root, int sum) {
		HashSet<Integer> set = new HashSet<Integer>();
		if (!findPairUtil(root, sum, set)) {
			System.out.print("Nodes are not found");
		}
	}

	public static void main(String[] args) {
		Node root = null;

		FindSumPair findPair = new FindSumPair();
		root = findPair.insert(root, 40);
		root = findPair.insert(root, 20);
		root = findPair.insert(root, 60);
		root = findPair.insert(root, 10);
		root = findPair.insert(root, 30);
		root = findPair.insert(root, 50);
		root = findPair.insert(root, 70);
		
		int sum =130;
		findPairWithGivenSum(root,sum);

	}

}
