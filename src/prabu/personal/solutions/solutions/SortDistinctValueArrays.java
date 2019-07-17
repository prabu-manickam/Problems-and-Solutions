package prabu.personal.solutions.solutions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SortDistinctValueArrays {

    public static void main(String[] args) {
        System.out.println("Minimum number of swaps to match arrays "+minimumSwapsToSortDistinctValueArrays(new int[] {1,3,5,9,8,7,6,2,4}));
    }

    public static int minimumSwapsToSortDistinctValueArrays(int[] arr) {


        System.out.println("Array 2 Values (ORIGINAL) ::> ");
        for(int i=0; i< arr.length; i++) {
            System.out.print(arr[i]+", ");
        }
        System.out.println();

        int min = arr[0];
        for(int i=1; i< arr.length; i++) {
            if(min > arr[i]) min = arr[i];
        }

        //Array2 Position arrays
        int swaps = 0;

        for(int i=0; i< arr.length; ) {
            if(i != arr[i]-min) {
                //swapping
                int temp = arr[arr[i]-min];
                arr[arr[i]-min] = arr[i];
                arr[i]  = temp;
                swaps++;
            } else {
                i++;
            }
        }

        System.out.println("Array 2 values (SWAPPED) ::> ");
        for(int i=0; i< arr.length; i++) {
            System.out.print(arr[i]+", ");
        }
        System.out.println();

        return swaps;
    }


}
