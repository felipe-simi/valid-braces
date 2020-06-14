package com.simi.validbraces.checker;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BraceCheckerTest {

  private BraceChecker checker = new BraceChecker();

  @Test
  public void givenParenthesesPair_whenBraceCheckerVerify_thenValidBraces() {
    assertEquals(true, checker.isValid("()"));
  }

}
