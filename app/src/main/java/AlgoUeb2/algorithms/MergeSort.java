package AlgoUeb2.algorithms;

import AlgoUeb2.lists.DoublyLinkedList;
import AlgoUeb2.lists.Listable;
import AlgoUeb2.sort.Comparator;
import AlgoUeb2.sort.Sortable;
import AlgoUeb2.sort.Swap;

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
        Listable<T> copyList = new DoublyLinkedList<>();

        for (int i = 0; i < list.size(); i++) {
            copyList.add(list.get(i));
        }

        int i;
        int j;

        for (i = begin; i <= mid; i++) {
            copyList.set(i, list.get(i));
        }
        for (j = mid + 1; j <= end; j++) {
            copyList.set(end + mid + 1 - j, list.get(j));
        }

        i = begin;
        j = end;

        for(int k = i; k <= end; k++) {
            if(comp.compare(copyList.get(i), copyList.get(j)) < 0) {
                list.set(k, copyList.get(i));
                i++;
            } else {
                list.set(k, copyList.get(j));
                j--;
            }
        }
    }
}
