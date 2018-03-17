package com.roulandu.sortion;

import java.util.Arrays;

/*
 * 冒泡排序: 從小到大
 * 時間複雜度O(n^2)
 * 空間複雜度O(1)
 * 基本思想：遍歷數組的第一位到最後，相鄰兩位比較后將較大的放在後面，一次之後數組最大的數字將移動到數組最後
 * 重複此過程，每次遍歷數組的數量依次向前抵減1，直到遍历最後祗剩下一個元素，數組排序完成
 * 冒泡排序是一種穩定的排序（穩定是指排好序后，原来数组中相同数字的相对顺序不会发生改变）
 */
public class BubbleSort {
	private static void bubbleSort(int[] arr) {
		// 冒泡排序
		if (arr == null || arr.length == 0) {
			return;
		}
		for (int e = arr.length - 1; e > 0; e--) {
			for (int i = 0; i < e; i++) {
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
				}
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		// 异或运算交换两个数数值
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
	}

	private static void Sort(int[] arr1) {
		// 一定对的排序
		Arrays.sort(arr1);
	}

	private static boolean Compare(int[] arr, int[] arr1) {
		// 判断两数组是否一样
		if ((arr.length != arr1.length)) {
			return false;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != arr1[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int times = 10000;
		int maxSize = 100;
		int maxNum = 100;
		int flag = 0;
		while (times != 0) {
			int n = (int) ((maxSize + 1) * Math.random());
			int[] arr = new int[n];
			int[] arr1 = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = (int) ((maxNum + 1) * Math.random()) - (int) ((maxNum + 1) * Math.random());
				arr1[i] = arr[i];
			}
			bubbleSort(arr);
			Sort(arr1);

			if (!Compare(arr, arr1)) {
				flag = 1;
				break;
			}
			times--;
		}
		System.out.println(flag == 1 ? "WRONG" : "OK");
	}
}
