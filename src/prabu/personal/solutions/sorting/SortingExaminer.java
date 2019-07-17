package prabu.personal.solutions.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;

public class SortingExaminer {
    public static void main(String args[]) throws IOException {
        System.out.println("Please enter integer values seperated with space");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[]  strNums = br.readLine().split(" ");
        int[] numbers = new int[strNums.length];
        for(int i=0; i <strNums.length; i++) {
            numbers[i] = Integer.valueOf(strNums[i]);
        }

        Instant then = Instant.now();
        printArray(SelectionSort.sort(numbers.clone()));
        System.out.println("Selection Sorting completed in (nano sec) - "+ Duration.between(then, Instant.now()).toNanos());


        then = Instant.now();
        printArray(InsertionSort.sort(numbers.clone()));
        System.out.println("Insertion Sorting completed in (nano sec) - "+ Duration.between(then, Instant.now()).toNanos());

        then = Instant.now();
        printArray(BubbleSort.sort(numbers.clone()));
        System.out.println("Bubble Sorting completed in (nano sec) - "+ Duration.between(then, Instant.now()).toNanos());

        then = Instant.now();
        printArray(MergeSort.sort(numbers.clone()));
        System.out.println("Merge Sorting completed in (nano sec) - "+ Duration.between(then, Instant.now()).toNanos());

        then = Instant.now();
        printArray(QuickSort.sort(numbers.clone()));
        System.out.println("Quick Sorting completed in (nano sec) - "+ Duration.between(then, Instant.now()).toNanos());
    }

    public static void printArray(int[] numbers) {
        //Print Sorted order
        System.out.println(LocalDateTime.now()+" - Sorted Order is ");
        for(int i=0; i<numbers.length; i++) {
            System.out.print(numbers[i]+" ");
        }
        System.out.println();
    }
}
