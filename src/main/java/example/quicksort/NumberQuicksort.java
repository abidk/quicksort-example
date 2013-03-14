package example.quicksort;

import java.util.ArrayList;
import java.util.List;

/**
 * Implemented simple version:
 * https://en.wikipedia.org/wiki/Quicksort#Simple_version
 * 
 */
public class NumberQuicksort implements Sortable<List<Integer>> {

  public List<Integer> sort(List<Integer> numbers) {
    if (numbers.size() <= 1) {
      return numbers;
    }

    int pivot = getPivot(numbers);

    List<Integer> smallNumbers = new ArrayList<Integer>();
    List<Integer> bigNumbers = new ArrayList<Integer>();
    for (int number : numbers) {
      if (number < pivot) {
        smallNumbers.add(number);
      } else {
        bigNumbers.add(number);
      }
    }
    return mergePartitions(sort(smallNumbers), pivot, sort(bigNumbers));
  }

  protected List<Integer> mergePartitions(List<Integer> partition, int pivot, List<Integer> otherPartition) {
    List<Integer> mergedList = new ArrayList<Integer>();
    mergedList.addAll(partition);
    mergedList.add(pivot);
    mergedList.addAll(otherPartition);
    return mergedList;
  }

  protected int getPivot(List<Integer> numbers) {
    return numbers.remove(numbers.size() / 2);
  }

}
