package AlgoUeb2.search;

import AlgoUeb2.lists.DoublyLinkedList;
import AlgoUeb2.lists.Listable;
import AlgoUeb2.sort.Comparator;

public class Search<T> implements Searchable<T>{
    @Override
    public Listable<T> search(Listable<T> list, Comparator<T> comp, T object) {
        Listable<T> matches = new DoublyLinkedList<>();

        for(int i = 0; i < list.size(); i++) {
            if (comp.compare(list.get(i), object) == 0) {
                matches.add(list.get(i));
            }
        }
        return matches;
    }
}
