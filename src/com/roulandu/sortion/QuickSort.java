package com.roulandu.sortion;

import java.util.Arrays;

/*
 * 快速排序: 從小到大
 * 時間複雜度O(nlogn)
 * 空間複雜度O(log2n)
 * 基本思想：选定一个基准点，一次排序后将大于该基准点的数据放在其右边，
 * 而小于其的数据放在其左边，然后调用相同函数使左侧和右侧分别有序。
 * 快速排序是一種不穩定的排序
 */
public class QuickSort {
	private static void quickSort(int[] a, int left, int right) {
		if (left < right) {
			int pivot = a[left];
			int low = left;
			int high = right;
			while (low < high) {
				while (low < high && a[high] >= pivot) {
					high--;
				}
				a[low] = a[high];
				while (low < high && a[low] <= pivot) {
					low++;
				}
				a[high] = a[low];
			}
			a[low] = pivot;
			quickSort(a, left, low - 1);
			quickSort(a, low + 1, right);
		}
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
			quickSort(arr, 0, arr.length - 1);
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
