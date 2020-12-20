package AlgoUeb2.sort.algorithms;

import AlgoUeb2.lists.DoublyLinkedList;
import AlgoUeb2.lists.Listable;
import AlgoUeb2.lists.SinglyLinkedList;
import AlgoUeb2.sort.Comparator;
import AlgoUeb2.sort.CourseComparator;
import AlgoUeb2.sort.Sortable;
import AlgoUeb2.sort.Swap;
import AlgoUeb2.util.Course;
import AlgoUeb2.util.Student;

import java.util.LinkedList;

public class MergeSort<T> extends Swap<T> implements Sortable<T> {

    @Override
    public void sort(Listable<T> list, Comparator comp) {

    }

    @Override
    public void sort(Listable<T> list, Comparator comp, int begin, int end) {
        if (begin < end) {
            int mid = (begin + end) / 2;

            sort(list, comp, begin, mid);
            sort(list, comp, mid + 1, end);

            merge(list, comp, begin, mid, end);
        }
    }

    private void merge(Listable<T> list, Comparator comp, int begin, int mid, int end) {
        Listable<T> leftList = new DoublyLinkedList<>();
        Listable<T> rightList = new DoublyLinkedList<>();
        int leftSize = mid - begin + 1;
        int rightSize = end - mid;

        for (int i = 0; i < leftSize; i++) {
            leftList.add(list.get(begin + i));
        }

        for(int i = 0; i < rightSize; i++) {
            rightList.add(list.get(mid + 1 + i));
        }

        int i = 0; // start index of leftList
        int j = 0; // start index of rightList
        //int k = begin; // start index of merged List

        for(int k = i; k <= end; k++) {
            if(comp.compare(leftList.get(k), rightList.get(k)) < 0) {
                list.set(k, leftList.get(i));
                i++;
            } else {
                list.set(k, rightList.get(j));
                j--;
            }
        }



        /*while(i < leftSize && j < rightSize) {
            if(comp.compare(leftList.get(i), rightList.get(j)) < 0) {
                list.set(k, leftList.get(i));
                i++;
            } else {
                list.set(k, rightList.get(j));
                j++;
            }
        }

        while(i < leftSize) {
            list.set(k, leftList.get(i));
            i++;
            k++;
        }
        while(j < rightSize) {
            list.set(k, rightList.get(j));
            j++;
            k++;
        }*/


        /*
        Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
        */
    }
}
