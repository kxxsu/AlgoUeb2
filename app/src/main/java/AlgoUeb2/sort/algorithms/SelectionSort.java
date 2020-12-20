package AlgoUeb2.sort.algorithms;

import AlgoUeb2.lists.Listable;
import AlgoUeb2.sort.Comparator;
import AlgoUeb2.sort.Sortable;
import AlgoUeb2.sort.Swap;

public class SelectionSort<T> extends Swap<T> implements Sortable<T> {

    @Override
    public void sort(Listable<T> list, Comparator comp) {
        int minimum = 0;
        for (int i = 0; i < list.size(); i++) {
            minimum = i;
            for (int e = i + 1; e < list.size(); e++) {
                if (comp.compare(list.get(e), list.get(minimum)) < 0) {
                    minimum = e;
                }
            }
            swap(list, i, minimum);
        }
    }

    @Override
    public void sort(Listable<T> list, Comparator comp, int begin, int end) {

    }
}
