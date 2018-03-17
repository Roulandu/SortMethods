package com.roulandu.sortion;

import java.util.Arrays;

/*
 * ð������: ��С����
 * �r�g�}�s��O(n^2)
 * ���g�}�s��O(1)
 * ����˼�룺��v���M�ĵ�һλ�����ᣬ������λ���^���^��ķ������棬һ��֮�ᔵ�M���Ĕ��֌��Ƅӵ����M����
 * ���}���^�̣�ÿ�α�v���M�Ĕ���������ǰ�֜p1��ֱ������������ʣ��һ��Ԫ�أ����M�������
 * ð��������һ�N���������򣨷�����ָ�ź����ԭ����������ͬ���ֵ����˳�򲻻ᷢ���ı䣩
 */
public class BubbleSort {
	private static void bubbleSort(int[] arr) {
		// ð������
		if (arr == null || arr.length == 0) {
			return;
		}
		for (int e = arr.length - 1; e > 0; e--) {
			for (int i = 0; i < e; i++) {
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
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
			bubbleSort(arr);
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