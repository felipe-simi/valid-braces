package com.simi.validbraces.checker;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BraceCheckerTest {

  private BraceChecker checker = new BraceChecker();

  @Test
  public void givenParenthesesPair_whenBraceCheckerVerify_thenValidBraces() {
    assertEquals(true, checker.isValid("()"));
  }

  @Test
  public void givenNestedPairs_whenBraceCheckerVerify_thenValidBraces() {
    assertEquals(true, checker.isValid("({})"));
  }

  @Test
  public void givenIncompletePair_whenBraceCheckerVerify_thenInvalidBraces() {
    assertEquals(false, checker.isValid("("));
  }

  @Test
  public void givenAllOpenBraces_whenBraceCheckerVerify_thenInvalidBraces() {
    assertEquals(false, checker.isValid("{{{{"));
  }

  @Test
  public void givenInvalidPairs_whenBraceCheckerVerify_thenInvalidBraces() {
    assertEquals(false, checker.isValid("(){]"));
  }

  @Test
  public void givenUnorderedPairs_whenBraceCheckerVerify_thenInvalidBraces() {
    assertEquals(false, checker.isValid("()]["));
  }

}
