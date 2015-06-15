/******************************************************************
 * Name           : Palaniappan Ramiah, Mounika Porandla
 * ZID            : Z1726972, Z1719789
 * Assignment No. : 3
 * Program Name   : SelectionSort.java
 * Description    : Contains the method for SelectionSort algorithm
 *****************************************************************/

package com;

public class SelectionSort {

	public int[] doSelectionSort(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < arr.length; j++)
				if (arr[j] < arr[index])
					index = j;

			int smallerNumber = arr[index];
			arr[index] = arr[i];
			arr[i] = smallerNumber;
		}
		return arr;
	}
}