package edu.austral.ingsis.math.operators;

public interface Operation {
  double evaluate(double left, double right);

  char getSymbol();
}
