package org.example;


public class CalculadorCombustible {
    private static CalculadorCombustible instance;
    private CalculadorCombustible() {}

    public static CalculadorCombustible getInstance() {
        if (instance == null) {
            instance = new CalculadorCombustible();
        }
        return instance;
    }

    public int calcularCombustible(Avion avion, int distancia) {
            return avion.volar(distancia);
        }
}
