package prabu.personal.solutions.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSort {
    public static void main(String args[]) throws IOException {
        System.out.println("Please enter integer values seperated with space");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[]  strNums = br.readLine().split(" ");
        int[] numbers = new int[strNums.length];
        for(int i=0; i <strNums.length; i++) {
            numbers[i] = Integer.valueOf(strNums[i]);
        }

        //Sorting starts here
        int[] sortedNums = sortAndMerge(0, numbers.length-1, numbers);

        //Print Sorted order
        System.out.println("Sorted Order is ");
        for(int i=0; i<sortedNums.length; i++) {
            System.out.print(sortedNums[i]+" ");
        }
    }

    public static int[] sort(int[] unSortedArray) throws IOException {
        return sortAndMerge(0, unSortedArray.length-1, unSortedArray);
    }

    public static int[] sortAndMerge(int startPos, int endPos, int[] array) {

        if(startPos < endPos) {
            int median = (startPos+endPos) / 2;

            int[] leftArr = sortAndMerge(startPos, median, array);
            int[] rightArr = sortAndMerge(median+1, endPos, array);

            int[] mergedArr = new int[leftArr.length+rightArr.length];
            int leftPointer = 0, rightPointer = 0, mergePonter = 0;
            while(leftPointer < leftArr.length && rightPointer < rightArr.length) {
                if(leftArr[leftPointer] < rightArr[rightPointer]) {
                    mergedArr[mergePonter++] = leftArr[leftPointer++];
                } else {
                    mergedArr[mergePonter++] = rightArr[rightPointer++];
                }
            }

            while(leftPointer < leftArr.length) {
                mergedArr[mergePonter++] = leftArr[leftPointer++];
            }

            while(rightPointer < rightArr.length) {
                mergedArr[mergePonter++] = rightArr[rightPointer++];
            }
            return mergedArr;
        } else {
            int[] arr = {array[startPos]};
            return arr;
        }
    }
}
