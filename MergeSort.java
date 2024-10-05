import java.util.Arrays;

public class MergeSort {

    // Merge two subarrays L and M into arr
    void merge(int[] arr, int left, int mid, int right) {
        // Find sizes of two subarrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        int[] L = new int[n1];
        int[] M = new int[n2];

        // Copy data to temp arrays L[] and M[]
        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            M[j] = arr[mid + 1 + j];

        // Merge the temp arrays back into arr[left..right]

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= M[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = M[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements of L[], if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy the remaining elements of M[], if any
        while (j < n2) {
            arr[k] = M[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[left..right] using merge()
    void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Find the middle point
            int mid = (left + right) / 2;

            // Sort first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    // Utility function to print the array
    static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = { 12, 11, 13, 5, 6, 7 };
        System.out.println("Given Array");
        printArray(arr);

        MergeSort ms = new MergeSort();
        ms.mergeSort(arr, 0, arr.length - 1);

        System.out.println("\nSorted Array");
        printArray(arr);
    }
}
