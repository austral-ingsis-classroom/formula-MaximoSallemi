package edu.austral.ingsis.math.operators;

public interface SingleArgumentOperation {
  double evaluate(double value);

  String getSymbol();
}
