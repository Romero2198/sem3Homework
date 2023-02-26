package sem3Homework;

import java.util.Arrays;

public class sem3Homework1 {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 3, 5, 7, 1, 3};
        int[] result = mergeSort(arr);
        System.out.println(Arrays.toString(result));
    }
    private static int[] mergeSort(int[] sortArr) {
        int[] buffer1 = Arrays.copyOf(sortArr, sortArr.length);
        int[] buffer2 = new int[sortArr.length];
        int[] result = mergeSortInner(buffer1, buffer2, 0, sortArr.length);
        return result;
    }
    private static int[] mergeSortInner(int[] buffer1, int[] buffer2, int startIndex, int endIndex){
        if (startIndex >= (endIndex - 1)) return buffer1;
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergeSortInner(buffer1, buffer2, startIndex, middle);
        int[] sorted2 = mergeSortInner(buffer1, buffer2, middle, endIndex);

        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result;
        if (sorted1 == buffer1) result = buffer2;
        else result = buffer1;
        while (index1 < middle && index2 < endIndex) {
            if (sorted1[index1] < sorted2[index2]) {
                result[destIndex++] = sorted1[index1++];
            }else {
                result[destIndex++] = sorted2[index2++];
            }
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }
}
