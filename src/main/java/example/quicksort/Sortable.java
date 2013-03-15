package example.quicksort;

import java.util.List;

public interface Sortable<T> {

  public List<T> sort(List<T> items);

}
