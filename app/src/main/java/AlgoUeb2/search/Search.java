package AlgoUeb2.search;

import AlgoUeb2.lists.Listable;
import AlgoUeb2.sort.Comparator;

public class Search<T> implements Searchable<T>{
    @Override
    public int search(Listable<T> list, Comparator<T> comp, T object) {

        for(int i = 0; i < list.size(); i++) {
            if (comp.compare(list.get(i), object) == 0) {
                return i;
            }
        }
        return -1;
    }
}
