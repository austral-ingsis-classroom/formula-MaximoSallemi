package edu.austral.ingsis.math.operators;

public class Multiplication implements Operation {
  @Override
  public double evaluate(double left, double right) {
    return left * right;
  }

  @Override
  public char getSymbol() {
    return '*';
  }
}
