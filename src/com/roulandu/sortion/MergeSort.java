package com.roulandu.sortion;

import java.util.Arrays;

/*
 * �鲢����: ��С����
 * ʱ�临�Ӷ�: O(nlogn)
 * �ռ临�Ӷ�: O(n)
 * ����˼�룺������ֳ�n���֣�Ȼ�����ڵĲ��ֺϲ� ���ų������ظ��˹��̣�ֱ����������
 * �鲢������һ���ȶ�������
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
		// һ���Ե�����
		Arrays.sort(arr1);
	}

	private static boolean Compare(int[] arr, int[] arr1) {
		// �ж��������Ƿ�һ��
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
