package com.simi.validbraces.checker;

public class BraceChecker {

  public boolean isValid(String braces) {
    if (hasOddBraces(braces)) {
      return false;
    }
    return true;
  }

  private boolean hasOddBraces(String braces) {
    return braces == null || braces.length() % 2 == 1;
  }

}
