/******************************************************************
 * Name           : Palaniappan Ramiah, Mounika Porandla
 * ZID            : Z1726972, Z1719789
 * Assignment No. : 3
 * Program Name   : BubbleSort.java
 * Description    : Contains the method for Bubble sort algorithm
 *****************************************************************/

package com;

public class BubbleSort {

	// logic to sort the elements
	public int[] doBubbleSort(int array[]) {
		int n = array.length;
		int k;
		for (int m = n; m >= 0; m--) {
			for (int i = 0; i < n - 1; i++) {
				k = i + 1;
				if (array[i] > array[k]) {
					swapNumbers(i, k, array);
				}
			}
		}
		return array;
	}

	private static void swapNumbers(int i, int j, int[] array) {

		int temp;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}