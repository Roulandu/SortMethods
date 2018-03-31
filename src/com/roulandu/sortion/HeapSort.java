package com.roulandu.sortion;

import java.util.Arrays;

/*
 * 堆排序: 從小到大
 * 時間複雜度O(nlogn)
 * 空間複雜度O(1)
 * 基本思想：先将数组构成一个完全二叉树，从后向前寻找非叶节点并构造大根堆，
 * 然后循环这个操作，将根节点输出后再重复构建，直到输出所有节点为止
 * 堆排序是一種不穩定的排序
 */
public class HeapSort {

	private static void heapSort(int[] arr, int n) {
		int i, j, k;
		for (i = n / 2 - 1; i >= 0; i--) {
			while (2 * i + 1 < n) {
				j = 2 * i + 1;
				if ((j + 1) < n) {
					if (arr[j] < arr[j + 1]) {
						j++;
					}
				}
				if (arr[i] < arr[j]) {
					swap(arr, i, j);
					i = j;
				} else {
					break;
				}
			}
		}
		for (i = n - 1; i > 0; i--) {
			swap(arr, i, 0);
			k = 0;
			while (2 * k + 1 < i) {
				j = 2 * k + 1;
				if ((j + 1) < i) {
					if (arr[j] < arr[j + 1]) {
						j++;
					}
				}
				if (arr[k] < arr[j]) {
					swap(arr, k, j);
					k = j;
				} else {
					break;
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
			heapSort(arr, arr.length);
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
