package com.roulandu.sortion;

import java.util.Arrays;

/*
 * 插入排序: 从小到大
 * 时间复杂度: O(n^2) , 但在数组有序情况下时间复杂度要比这个小, 最好为O(n)
 * 空间复杂度: O(1)
 * 基本思想：每次将一个待排序的数，按其数值的大小插入前面已经排序部分中适当位置上，直到全部插入完为止
 * 插入排序是一种稳定的排序
 */
public class InsertionSort {
	private static void insertSort(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j] < arr[j - 1]) {
					swap(arr, j, j - 1);
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
			insertSort(arr);
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
