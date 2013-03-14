package example.quicksort;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class NumberQuicksortTest {

  private NumberQuicksort sorter;

  @Before
  public void setUp() {
    sorter = new NumberQuicksort();
  }

  @Test
  public void sortShouldReturnOriginalListWhenInputListContainsZeroItems() {
    List<Integer> numbers = buildNumbers();
    assertEquals(numbers, sorter.sort(numbers));
  }

  @Test
  public void sortShouldReturnOriginalListWhenInputListContainsOneItem() {
    List<Integer> numbers = buildNumbers(1);

    assertEquals(numbers, sorter.sort(numbers));
    assertListEquals(new Integer[] { 1 }, sorter.sort(numbers));
  }

  @Test
  public void sortShouldReturnListInIncrementedOrder() {
    List<Integer> sortedList = sorter.sort(buildNumbers(4, 1));
    assertListEquals(new Integer[] { 1, 4 }, sortedList);

    sortedList = sorter.sort(buildNumbers(1, 7, 5, 5, 9, 3, 4));
    assertListEquals(new Integer[] { 1, 3, 4, 5, 5, 7, 9 }, sortedList);

    sortedList = sorter.sort(buildNumbers(0, 7, 1, 5, 2, 3, 4));
    assertListEquals(new Integer[] { 0, 1, 2, 3, 4, 5, 7 }, sortedList);
  }

  @Test
  public void sortShouldSortNegativeNumbersAndReturnListInIncrementedOrder() {
    List<Integer> sortedList = sorter.sort(buildNumbers(1, 7, -5, 5, 9, 3, 4));
    assertListEquals(new Integer[] { -5, 1, 3, 4, 5, 7, 9 }, sortedList);

    sortedList = sorter.sort(buildNumbers(-1, -7, -5, -5, -9, -3, -4));
    assertListEquals(new Integer[] { -9, -7, -5, -5, -4, -3, -1 }, sortedList);
  }

  @Test
  public void mergePartitionsShouldMergeInputArgumentsAndReturnListInSpecificOrder() {
    List<Integer> mergedList = sorter.mergePartitions(buildNumbers(1), 2, buildNumbers(3));
    assertListEquals(new Integer[] { 1, 2, 3 }, mergedList);

    mergedList = sorter.mergePartitions(buildNumbers(2, 3), 1, buildNumbers(4, 5));
    assertListEquals(new Integer[] { 2, 3, 1, 4, 5 }, mergedList);

    mergedList = sorter.mergePartitions(buildNumbers(2, -3), 1, buildNumbers(-4, 5));
    assertListEquals(new Integer[] { 2, -3, 1, -4, 5 }, mergedList);
  }

  @Test
  public void getPivotShouldRemoveAndReturnNumberFromList() {
    List<Integer> numbers = buildNumbers(1, 2, 3, 4, 5, 6, 7, 8, 9);

    assertEquals(9, numbers.size());

    int pivot = sorter.getPivot(numbers);
    assertFalse(numbers.contains(pivot));
    assertEquals(8, numbers.size());

    pivot = sorter.getPivot(numbers);
    assertFalse(numbers.contains(pivot));
    assertEquals(7, numbers.size());
  }

  @Test
  public void getPivotShouldReturnFirstNumberFromListWhenListSizeEqualsOne() {
    assertEquals(7, sorter.getPivot(buildNumbers(7)));
  }

  @Test
  public void getPivotShouldReturnMiddleNumberWhenListLengthIsOdd() {
    assertEquals(2, sorter.getPivot(buildNumbers(1, 2, 3)));
    assertEquals(1, sorter.getPivot(buildNumbers(5, 6, 1, 3, 2)));
  }

  @Test
  public void getPivotShouldReturnMiddlePlusOneNumberWhenListLengthIsEven() {
    assertEquals(2, sorter.getPivot(buildNumbers(1, 2)));
    assertEquals(3, sorter.getPivot(buildNumbers(1, 2, 3, 4)));
  }

  private void assertListEquals(Integer[] expected, List<Integer> actual) {
    assertArrayEquals(expected, actual.toArray(new Integer[0]));
  }

  private List<Integer> buildNumbers(int... numbers) {
    List<Integer> numberList = new ArrayList<Integer>();
    for (int number : numbers) {
      numberList.add(number);
    }
    return numberList;
  }
}
