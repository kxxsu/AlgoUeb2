package AlgoUeb2.search;

import AlgoUeb2.lists.Listable;
import AlgoUeb2.sort.Comparator;

public interface Searchable<T> {
    int search(Listable<T> list, Comparator<T> comp, T object);
}
