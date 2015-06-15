/******************************************************************
 * Name           : Palaniappan Ramiah, Mounika Porandla
 * ZID            : Z1726972, Z1719789
 * Assignment No. : 3
 * Program Name   : MergeSort.java
 * Description    : Contains the method for Merge Sort algorithm
 *****************************************************************/

package com;

public class MergeSort {

	private int[] array;
	private int[] tempMergArr;
	private int length;

	public int[] doMergeSort(int inputArr[]) {
		this.array = inputArr;
		this.length = inputArr.length;
		this.tempMergArr = new int[length];
		mergeSort(0, length - 1);
		return inputArr;
	}

	private void mergeSort(int lowerIndex, int higherIndex) {

		if (lowerIndex < higherIndex) {
			int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
			// Below step sorts the left side of the array
			mergeSort(lowerIndex, middle);
			// Below step sorts the right side of the array
			mergeSort(middle + 1, higherIndex);
			// Now merge both sides
			mergeParts(lowerIndex, middle, higherIndex);
		}
	}

	private void mergeParts(int lowerIndex, int middle, int higherIndex) {

		for (int i = lowerIndex; i <= higherIndex; i++) {
			tempMergArr[i] = array[i];
		}
		int i = lowerIndex;
		int j = middle + 1;
		int k = lowerIndex;
		while (i <= middle && j <= higherIndex) {
			if (tempMergArr[i] <= tempMergArr[j]) {
				array[k] = tempMergArr[i];
				i++;
			} else {
				array[k] = tempMergArr[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			array[k] = tempMergArr[i];
			k++;
			i++;
		}

	}
}