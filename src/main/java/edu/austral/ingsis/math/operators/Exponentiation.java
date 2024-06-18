package edu.austral.ingsis.math.operators;

public class Exponentiation implements Operation {
  @Override
  public double evaluate(double left, double right) {
    return Math.pow(left, right);
  }

  @Override
  public char getSymbol() {
    return '^';
  }
}
