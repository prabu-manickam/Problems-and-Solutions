package prabu.personal.solutions.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelectionSort {
    public static void main(String args[]) throws IOException {
        System.out.println("Please enter integer values seperated with space");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[]  strNums = br.readLine().split(" ");
        int[] numbers = new int[strNums.length];
        for(int i=0; i <strNums.length; i++) {
            numbers[i] = Integer.valueOf(strNums[i]);
        }

        //Sorting starts here
        int[] sortedNumbers = new int[strNums.length];
        int point = 0;
        while(point < strNums.length) {
            int min = numbers[0], minPos = 0;
            for (int i = 1; i < numbers.length; i++) {
                if(numbers[i] < min) {
                    min = numbers[i];
                    minPos = i;
                }
            }

            numbers[minPos] = Integer.MAX_VALUE;
            sortedNumbers[point++] = min;
        }

        //Print Sorted order
        System.out.println("Sorted Order is ");
        for(int i=0; i<sortedNumbers.length; i++) {
            System.out.print(sortedNumbers[i]+" ");
        }
    }

    public static int[] sort(int[] unSortedArr) throws IOException {
        int[] sortedNumbers = new int[unSortedArr.length];
        int point = 0;
        while(point < unSortedArr.length) {
            int min = unSortedArr[0], minPos = 0;
            for (int i = 1; i < unSortedArr.length; i++) {
                if(unSortedArr[i] < min) {
                    min = unSortedArr[i];
                    minPos = i;
                }
            }

            unSortedArr[minPos] = Integer.MAX_VALUE;
            sortedNumbers[point++] = min;
        }
      return sortedNumbers;
    }
}
