package com.simi.validbraces.checker;

import java.util.ArrayDeque;
import java.util.Map;

public class BraceChecker {

  private final Map<Character, Character> bracesPair = Map.of(
      ')', '(',
      '}', '{',
      ']', '[');

  public boolean isValid(final String braces) {
    final var inputStack = new ArrayDeque<Character>();
    if (hasOddBraces(braces)) {
      return false;
    }
    for (final var brace : braces.toCharArray()) {
      if (isValidClosingBrace(inputStack, brace)) {
        return false;
      }
      if (bracesPair.containsKey(brace)) {
        if (isNotClosingBrace(inputStack, brace)) {
          return false;
        }
        inputStack.pop();
      } else {
        inputStack.push(brace);
      }
    }
    return inputStack.isEmpty();
  }

  private boolean isNotClosingBrace(final ArrayDeque<Character> inputStack, final char brace) {
    final var poppedBrace = inputStack.peek();
    final var expectedPair = bracesPair.get(brace);
    return !poppedBrace.equals(expectedPair);
  }

  private boolean hasOddBraces(final String braces) {
    return braces == null || braces.length() % 2 == 1;
  }

  private boolean isValidClosingBrace(final ArrayDeque<Character> inputStack, final char brace) {
    return inputStack.isEmpty() && bracesPair.containsKey(brace);
  }

}
