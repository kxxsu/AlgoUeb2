package AlgoUeb2.algorithms;

import AlgoUeb2.lists.Listable;
import AlgoUeb2.sort.Comparator;
import AlgoUeb2.sort.Sortable;
import AlgoUeb2.sort.Swap;

public class InsertionSort<T> extends Swap<T> implements Sortable<T> {

    @Override
    public void sort(Listable<T> list, Comparator comp) {
        for (int i = 1; i < list.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (comp.compare(list.get(j), list.get(j - 1)) < 0) {
                    swap(list, j, j - 1);
                }
            }
        }
    }

    @Override
    public void sort(Listable<T> list, Comparator comp, int begin, int end) {

    }
}
