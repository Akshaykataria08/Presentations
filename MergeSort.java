package intializer;

import java.util.Arrays;

public class AppInit {

	public static void main(String[] args) {
		int[] arr = {7, 2, 1, 16, 8, 10, 3, 9, 4};		
		mergeSort(arr);
		System.out.println("Resultant Array: " + Arrays.toString(arr));
	}

	private static void mergeSort(int[] arr) {
		divideConquer(arr, 0, arr.length-1);
		
	}

	private static void divideConquer(int[] arr, int start, int end) {
		if(start < end) {
			int mid = start + (end - start)/2;
			divideConquer(arr, start, mid);
			divideConquer(arr, mid+1, end);
			combine(arr, start, mid, end);
		}
	}

	private static void combine(int[] arr, int start, int mid, int end) {
		
		int leftArrLen = mid - start + 1;
		int rightArrLen = end - mid;
		

		int[] leftArr = new int[leftArrLen];
		int[] rightArr = new int[rightArrLen];
		
		for(int i=0; i<leftArrLen; ++i) {
			leftArr[i] = arr[start + i];
		}
		
		for(int j=0; j<rightArrLen; ++j) {
			rightArr[j] = arr[mid + 1 + j];
		}

		int leftArrPtr = 0;
		int rightArrPtr = 0;
		int originalArrPtr = start;
		
		while(leftArrPtr < leftArrLen && rightArrPtr < rightArrLen) {
			if(leftArr[leftArrPtr] <= rightArr[rightArrPtr]) {
				arr[originalArrPtr] = leftArr[leftArrPtr];
				++leftArrPtr;
			} else {
				arr[originalArrPtr] = rightArr[rightArrPtr];
				++rightArrPtr;
			}
			++originalArrPtr;
		}
		
		while(leftArrPtr < leftArrLen) {
			arr[originalArrPtr] = leftArr[leftArrPtr];
			++leftArrPtr;
			++originalArrPtr;
		}
		
		while(rightArrPtr < rightArrLen) {
			arr[originalArrPtr] = rightArr[rightArrPtr];
			++rightArrPtr;
			++originalArrPtr;
		}
		
	}

}
