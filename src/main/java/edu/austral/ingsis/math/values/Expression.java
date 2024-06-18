package edu.austral.ingsis.math.values;

import java.util.ArrayList;
import java.util.Map;

public interface Expression {
  double evaluate(Map<String, Double> variables);

  String toString();

  String nestedToString(boolean nested);

  ArrayList<String> getVariables();
}
