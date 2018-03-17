package com.roulandu.sortion;

import java.util.Arrays;

/*
 * 选择排序: 从小到大
 * 时间复杂度: O(n^2)
 * 空间复杂度: O(1)
 * 基本思想: 将当前最小数和后面逐个比较，当发现比他小的数就使其变成最小的数，直到数组遍历一遍
 * 然后将其和待排序部分第一位互换位置，重复此过程，直到没有待排序部分为止，排序完成
 * 选择排序是一种不稳定的排序
 */
public class SelectionSort {
	private static void selectSort(int[] arr) {
		// 选择排序
		if (arr == null || arr.length == 0) {
			return;
		}
		int min;
		for (int i = 0; i < arr.length; i++) {
			min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}
			}
			if (min != i) {
				swap(arr, i, min);
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
			selectSort(arr);
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
