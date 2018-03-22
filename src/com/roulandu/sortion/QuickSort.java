package com.roulandu.sortion;

import java.util.Arrays;

/*
 * ��������: ��С����
 * �r�g�}�s��O(nlogn)
 * ���g�}�s��O(log2n)
 * ����˼�룺ѡ��һ����׼�㣬һ������󽫴��ڸû�׼������ݷ������ұߣ�
 * ��С��������ݷ�������ߣ�Ȼ�������ͬ����ʹ�����Ҳ�ֱ�����
 * ����������һ�N������������
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
