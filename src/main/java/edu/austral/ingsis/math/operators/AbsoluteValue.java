package edu.austral.ingsis.math.operators;

public class AbsoluteValue implements SingleArgumentOperation {
  @Override
  public double evaluate(double value) {
    return Math.abs(value);
  }

  @Override
  public String getSymbol() {
    return "| |";
  }
}
