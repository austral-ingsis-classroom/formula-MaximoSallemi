package edu.austral.ingsis.math.values;

import java.util.ArrayList;
import java.util.Map;

public class Value implements Expression {
  private final double value;

  public Value(double value) {
    this.value = value;
  }

  @Override
  public double evaluate(Map<String, Double> variables) {
    return value;
  }

  public String toString() {
    return Integer.toString((int) value);
  }

  @Override
  public String nestedToString(boolean nested) {
    return Integer.toString((int) value);
  }

  @Override
  public ArrayList<String> getVariables() {
    return new ArrayList<>();
  }
}
