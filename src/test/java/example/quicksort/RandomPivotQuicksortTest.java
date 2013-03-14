package example.quicksort;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class RandomPivotQuicksortTest {

  private RandomPivotQuicksort sorter;

  @Before
  public void setUp() {
    sorter = new RandomPivotQuicksort();
  }

  @Test
  public void getPivotShouldReturnPivotNumbersInRandomSequence() {
    List<Integer> numbers1 = buildNumbers(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
    List<Integer> pivotNumbers1 = new ArrayList<Integer>();
    for (int x = 0; x < 10; x++) {
      pivotNumbers1.add(sorter.getPivot(numbers1));
    }

    List<Integer> numbers2 = buildNumbers(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
    List<Integer> pivotNumbers2 = new ArrayList<Integer>();
    for (int x = 0; x < 10; x++) {
      pivotNumbers2.add(sorter.getPivot(numbers2));
    }

    assertNotSame(Arrays.toString(pivotNumbers1.toArray()), Arrays.toString(pivotNumbers2.toArray()));
  }

  @Test
  public void getPivotShouldRemoveAndReturnNumberFromList() {
    List<Integer> numbers = buildNumbers(1, 2, 3, 4, 5, 6, 7, 8, 9);

    assertEquals(9, numbers.size());

    int pivot = sorter.getPivot(numbers);
    assertFalse(numbers.contains(pivot));
    assertEquals(8, numbers.size());

    pivot = sorter.getPivot(numbers);
    pivot = sorter.getPivot(numbers);
    assertFalse(numbers.contains(pivot));
    assertEquals(6, numbers.size());
  }

  @Test
  public void sortShouldReturnListInIncrementedOrder() {
    List<Integer> sortedList = sorter.sort(buildNumbers(4, 1));
    assertListEquals(new Integer[] { 1, 4 }, sortedList);

    sortedList = sorter.sort(buildNumbers(1, 7, 5, 5, 9, 3, 4));
    assertListEquals(new Integer[] { 1, 3, 4, 5, 5, 7, 9 }, sortedList);

    sortedList = sorter.sort(buildNumbers(0, 7, 1, 5, 2, 3, 4));
    assertListEquals(new Integer[] { 0, 1, 2, 3, 4, 5, 7 }, sortedList);

    sortedList = sorter.sort(buildNumbers(1, 7, -5, 5, 9, 3, 4));
    assertListEquals(new Integer[] { -5, 1, 3, 4, 5, 7, 9 }, sortedList);
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
