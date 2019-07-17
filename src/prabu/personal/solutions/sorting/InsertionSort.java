package prabu.personal.solutions.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InsertionSort {
    public static void main(String args[]) throws IOException {
        System.out.println("Please enter integer values seperated with space");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[]  strNums = br.readLine().split(" ");
        int[] numbers = new int[strNums.length];
        for(int i=0; i <strNums.length; i++) {
            numbers[i] = Integer.valueOf(strNums[i]);
        }

        //Sorting starts here
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < i; j++) {
                if(numbers[j] > numbers[i]) {
                    int temp = numbers[i];

                    //Shift the elements to the next positions - from the last
                    for(int k=i; k>j; k--) {
                        numbers[k] = numbers[k-1];
                    }

                    numbers[j] = temp;

                    break;
                }
            }

        }

        //Print Sorted order
        System.out.println("Sorted Order is ");
        for(int i=0; i<numbers.length; i++) {
            System.out.print(numbers[i]+" ");
        }
    }

    public static int[] sort(int[] array) throws IOException {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if(array[j] > array[i]) {
                    int temp = array[i];

                    //Shift the elements to the next positions - from the last
                    for(int k=i; k>j; k--) {
                        array[k] = array[k-1];
                    }

                    array[j] = temp;

                    break;
                }
            }

        }

        return array;
    }
}
