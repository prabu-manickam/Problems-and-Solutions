package prabu.personal.solutions.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickSort {
    public static void main(String args[]) throws IOException {
        System.out.println("Please enter integer values seperated with space");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[]  strNums = br.readLine().split(" ");
        int[] numbers = new int[strNums.length];
        for(int i=0; i <strNums.length; i++) {
            numbers[i] = Integer.valueOf(strNums[i]);
        }

        //Sorting starts here
        sortAndMerge(0, numbers.length-1, numbers);

        //Print Sorted order
        System.out.println("Sorted Order is ");
        for(int i=0; i<numbers.length; i++) {
            System.out.print(numbers[i]+" ");
        }
    }

    public static int[] sort(int[] unSortedArray) throws IOException {
        sortAndMerge(0, unSortedArray.length-1, unSortedArray);
        return unSortedArray;
    }

    public static void sortAndMerge(int startPos, int endPos, int[] array) {
        if(startPos < endPos) {
            int midVal = array[endPos], leftPointer=startPos, rightPonter=startPos;

            while (rightPonter <= endPos) {
                if (array[rightPonter] < midVal) {
                    swap(leftPointer, rightPonter, array);
                    leftPointer++;
                }
                rightPonter++;
            }
            if(array[leftPointer] > array[endPos])
                swap(leftPointer, endPos, array);

            sortAndMerge(startPos, leftPointer - 1, array);
            sortAndMerge(leftPointer + 1, endPos, array);
        }
    }

    private static void swap(int leftPos, int rightPos, int[] array) {
        int temp = array[rightPos];
        array[rightPos] = array[leftPos];
        array[leftPos] = temp;
    }
}
