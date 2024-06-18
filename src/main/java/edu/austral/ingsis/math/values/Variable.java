package edu.austral.ingsis.math.values;

import java.util.ArrayList;
import java.util.Map;

public class Variable implements Expression {
  private final String name;

  public Variable(String name) {
    this.name = name;
  }

  @Override
  public double evaluate(Map<String, Double> variables) {
    return variables.get(name);
  }

  @Override
  public String toString() {
    return name;
  }

  @Override
  public String nestedToString(boolean nested) {
    return name;
  }

  @Override
  public ArrayList<String> getVariables() {
    ArrayList<String> variables = new ArrayList<>();
    variables.add(name);
    return variables;
  }
}
