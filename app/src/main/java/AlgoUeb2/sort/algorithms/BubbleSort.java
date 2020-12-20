package AlgoUeb2.sort.algorithms;

import AlgoUeb2.lists.Listable;
import AlgoUeb2.sort.Comparator;
import AlgoUeb2.sort.Sortable;
import AlgoUeb2.sort.Swap;

public class BubbleSort<T> extends Swap<T> implements Sortable<T> {

    @Override
    public void sort(Listable<T> list, Comparator comp) {
        for (int i = 1; i < list.size(); i++) {
            for (int e = 0; e < list.size() - i; e++) {
                if(comp.compare(list.get(e), list.get(e + 1)) > 0) {
                    swap(list, e, e + 1);
                }
            }
        }
    }

    @Override
    public void sort(Listable<T> list, Comparator comp, int begin, int end) {

    }
}
