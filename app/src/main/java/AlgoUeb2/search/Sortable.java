package AlgoUeb2.search;

import AlgoUeb2.lists.Listable;

public interface Sortable<T> {
    void sort(Listable<T> list, Comparator comp);
}
