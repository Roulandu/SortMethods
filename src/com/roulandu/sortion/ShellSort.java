package com.roulandu.sortion;

import java.util.Arrays;

/*
 * ϣ������: ��С����
 * ʱ�临�Ӷ�: O(n^1.3) , �����������������ʱ�临�Ӷ�Ҫ�����С, ���ΪO(n)
 * �ռ临�Ӷ�: O(1)
 * ����˼�룺���÷���Ĳ�������ʽ������������һ�ν���һ�£�ϣ���Ƿ�Ϊ���鲽������
 * ϣ��������һ�ֲ��ȶ�������
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
