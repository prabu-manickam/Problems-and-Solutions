package prabu.personal.solutions.solutions;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;

public class MatchNonDistinctValueArrays {

    public static void main(String[] args) {
        System.out.println("Minimum number of swaps to match arrays "+minimumSwapsToMatchArray(new int[] {1,0,0,1,5,6,7,8,9}, new int[] {1,1,0,0,5,9,8,7,6}));
    }

    public static int minimumSwapsToMatchArray(int[] array1, int[] array2) {

        Map<Integer, LinkedList<Integer>> memoryMap = new HashMap<>();

        System.out.println("Array 1 Values (ORIGINAL) ::> ");
        for(int i=0; i< array1.length; i++) {
            System.out.print(array1[i]+", ");
        }
        System.out.println();

        System.out.println("Array 2 Values (ORIGINAL) ::> ");
        for(int i=0; i< array2.length; i++) {
            System.out.print(array2[i]+", ");
        }
        System.out.println();

        for(int i=0; i< array1.length; i++) {

            if(memoryMap.get(array1[i]) == null) {
                memoryMap.put(array1[i], new LinkedList<>());
            }

            memoryMap.get(array1[i]).offer(i);
        }

        //Array2 Position arrays
        int[] array2Pos = new int[array2.length];
        int[] array2PosOfPos = new int[array2.length];
        System.out.println("Array 2 Positions (ORIGINAL) ::> ");
        for(int i=0; i< array2.length; i++) {
            array2Pos[i] = memoryMap.get(array2[i]).pollFirst();
            array2PosOfPos[array2Pos[i]] = i;
            System.out.print(array2Pos[i]+", ");
        }
        System.out.println();

        System.out.println("Array 2 Positions of Positions  ::> ");
        for(int i=0; i< array2PosOfPos.length; i++) {
            System.out.print(array2PosOfPos[i]+", ");
        }
        System.out.println();

        int swaps = 0;

        for(int i=0; i<array1.length; i++) {
            if(i != array2Pos[i]) {
                //Swap positions here
                int tmpPos = array2PosOfPos[i];
                int tmpVal = array2Pos[i];
                array2Pos[i] = array2Pos[tmpPos];
                array2Pos[tmpPos] = tmpVal;
                System.out.println("SWAPPING Positions :: "+array2[i]+" <=> "+array2[tmpPos]);

                //Swap values here
                int tmp = array2[i];
                array2[i] = array2[tmpPos];
                array2[tmpPos] = tmp;

                //Swap positions of positions here
                int tmpPosVal = array2PosOfPos[tmpVal];
                array2PosOfPos[tmpVal] = array2PosOfPos[i];
                array2PosOfPos[i] = tmpPosVal;

                swaps++;
            } //else it is already in position
        }

        System.out.println("Array 2 Positions (SWAPPED) ::> ");
        for(int i=0; i< array2.length; i++) {
            System.out.print(array2Pos[i]+", ");
        }
        System.out.println();

        System.out.println("Array 2 values (SWAPPED) ::> ");
        for(int i=0; i< array2.length; i++) {
            System.out.print(array2[i]+", ");
        }
        System.out.println();

        return swaps;
    }


}
