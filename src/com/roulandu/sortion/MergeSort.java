package com.roulandu.sortion;

import java.util.Arrays;

/*
 * 归并排序: 从小到大
 * 时间复杂度: O(nlogn)
 * 空间复杂度: O(n)
 * 基本思想：将数组分成n部分，然后将相邻的部分合并 并排成有序，重复此过程，直到数组有序
 * 归并排序是一种稳定的排序
 */
public class MergeSort {
	private static int[] mergeSort(int[] array, int low, int high) {
		int mid = (low + high) / 2;
		if (low < high) {
			mergeSort(array, low, mid);
			mergeSort(array, mid + 1, high);
			merge(array, low, mid, high);
		}
		return array;
	}

	private static void merge(int[] array, int low, int mid, int high) {
		int[] temp = new int[high - low + 1];
		int i = low;
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= high) {
			if (array[i] < array[j]) {
				temp[k++] = array[i++];
			} else {
				temp[k++] = array[j++];
			}
		}
		while (i <= mid) {
			temp[k++] = array[i++];
		}
		while (j <= high) {
			temp[k++] = array[j++];
		}
		for (int x = 0; x < temp.length; x++) {
			array[x + low] = temp[x];
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
			int[] arr2 = mergeSort(arr, 0, arr.length - 1);
			Sort(arr1);

			if (!Compare(arr2, arr1)) {
				flag = 1;
				break;
			}
			times--;
		}
		System.out.println(flag == 1 ? "WRONG" : "OK");
	}
}
