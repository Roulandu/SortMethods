package com.roulandu.sortion;

import java.util.Arrays;

/*
 * ��������: ��С����
 * ʱ�临�Ӷ�: O(n^2) , �����������������ʱ�临�Ӷ�Ҫ�����С, ���ΪO(n)
 * �ռ临�Ӷ�: O(1)
 * ����˼�룺ÿ�ν�һ�������������������ֵ�Ĵ�С����ǰ���Ѿ����򲿷����ʵ�λ���ϣ�ֱ��ȫ��������Ϊֹ
 * ����������һ���ȶ�������
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
		// ������㽻����������ֵ
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
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
