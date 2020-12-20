package AlgoUeb2.sort;

import AlgoUeb2.lists.Listable;

import java.util.List;

public interface Sortable<T> {
    void sort(Listable<T> list, Comparator comp);
    void sort(Listable<T> list, Comparator comp, int begin, int end);
}
