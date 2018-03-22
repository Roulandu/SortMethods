package com.roulandu.sortion;

import java.util.Arrays;

/*
 * 希尔排序: 从小到大
 * 时间复杂度: O(n^1.3) , 但在数组有序情况下时间复杂度要比这个小, 最好为O(n)
 * 空间复杂度: O(1)
 * 基本思想：采用分组的插入排序方式，插入排序是一次交换一下，希尔是分为几组步进交换
 * 希尔排序是一种不稳定的排序
 */
public class ShellSort {
	private static void shellSort(int[] a) {
		int n = a.length;
		int h;
		for (h = n / 2; h > 0; h /= 2) {
			for (int i = h; i < n; i++) {
				for (int j = i - h; j >= 0; j -= h) {
					if (a[j] > a[j + h]) {
						swap(a, j, j + h);
					}
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
			shellSort(arr);
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
