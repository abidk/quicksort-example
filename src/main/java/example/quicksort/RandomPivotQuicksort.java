package example.quicksort;

import java.util.List;
import java.util.Random;

public class RandomPivotQuicksort extends NumberQuicksort {

  private Random random = new Random();

  @Override
  protected int getPivot(List<Integer> numbers) {
    return numbers.remove(random.nextInt(numbers.size()));
  }
}
