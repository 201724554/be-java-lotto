package kr.codesquad;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WinnerChecker {

  private static final int[] winningNumberCount = {3, 4, 5, 6};

  public Map<Integer, Integer> check(
      List<LottoNumbers> numbersList,
      LottoNumbers winningNumber
  ) {
    Map<Integer, Integer> map = Arrays.stream(WinningAmount.values())
                                      .collect(Collectors.toMap(WinningAmount::getCorrectCount, w -> 0, (a, b) -> b));

    numbersList.stream()
               .mapToInt(winningNumber::countMatch)
               .filter(map::containsKey)
               .forEach(matchCount -> map.put(matchCount, map.get(matchCount) + 1));

    return map;
  }

}
