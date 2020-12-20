package AlgoUeb2.sort.algorithms;

import AlgoUeb2.lists.DoublyLinkedList;
import AlgoUeb2.lists.Listable;
import AlgoUeb2.sort.Comparator;
import AlgoUeb2.sort.Sortable;
import AlgoUeb2.sort.Swap;
import AlgoUeb2.util.Student;

import java.util.LinkedList;

public class MergeSort<T> extends Swap<T> implements Sortable<T> {

    @Override
    public void sort(Listable<T> list, Comparator comp) {

    }

    @Override
    public void sort(Listable<T> list, Comparator comp, int begin, int end) {
        int i = begin;
        int j = end;
        T middle = list.get((i + j) / 2);

        while (i <= j) {

        }
    }

    private void split(Listable<T> list, Comparator comp, int begin, int end) {
        if (begin < end) {
            int mid = (begin + end) / 2;

            split(list, comp, begin, mid);
            split(list, comp, mid + 1, end);

            merge(list, comp, begin, mid, end);
        }
    }

    private void merge(Listable<T> list, Comparator comp, int begin, int mid, int end) {
        Listable<T> leftList = new DoublyLinkedList<>();
        Listable<T> rightList = new DoublyLinkedList<>();
        int leftSize = mid - begin + 1;
        int rightSize = end - mid;

        for (int i = 0; i < leftSize; i++) {
            T node = leftList.get(i);
            node = list.get(begin + i);
        }

        for(int i = 0; i < rightSize; i++) {
            T node = rightList.get(i);
            node = list.get(mid + 1 + i);
        }

    }


    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int begin, int end) {
        if (begin < end) {
            // Find the middle point
            int m = (begin + end) / 2;

            // Sort first and second halves
            sort(arr, begin, m);
            sort(arr, m + 1, end);

            // Merge the sorted halves
            merg2e(arr, begin, m, end);
        }
    }

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merg2e(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }


    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver code
    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7};

        System.out.println("Given Array");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}
