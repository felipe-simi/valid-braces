package com.simi.validbraces.checker;

import java.util.ArrayDeque;
import java.util.Map;

public class BraceChecker {
  Map<Character, Character> bracesPair = Map.of(
      ')', '(',
      '}', '{',
      ']', '[');

  public boolean isValid(final String braces) {
    final var inputStack = new ArrayDeque<Character>();
    if (hasOddBraces(braces)) {
      return false;
    }
    for (int i = 0; i < braces.length(); i++) {
      final var brace = braces.charAt(i);
      if (bracesPair.containsKey(brace)) {
        if (inputStack.isEmpty()) {
          return false;
        }
        final var poppedBrace = inputStack.pop();
        final var expectedPair = bracesPair.get(brace);
        if (!poppedBrace.equals(expectedPair)) {
          return false;
        }
      } else {
        inputStack.push(brace);
      }
    }
    return true;
  }

  private boolean hasOddBraces(String braces) {
    return braces == null || braces.length() % 2 == 1;
  }

}
